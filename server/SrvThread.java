package server;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

class SrvThread extends Thread {

    private Socket soc;
    public static int li_count = 0;

    /**
     * コンストラクタ
     * 新しいスレッドを作成し、接続されたクライアントのIPアドレスを表示
     * 
     * @param socket 接続されたソケット
     */
    public SrvThread(Socket socket) {
        soc = socket;
        System.out.println("Thread is Generated. Connect to " + soc.getInetAddress());
    }

    /**
     * クライアントにデータを送信するメソッド
     * 
     * @param SendClient_data 送信するデータのHashMap
     */
    public void Thread_Recieve_and_SendtoClient(HashMap<String, String> SendClient_data) {
        System.out.println("Thread_Recieve_and_SendtoClient::" + SendClient_data);
        try {
            ObjectMapper mapper = new ObjectMapper();
            PrintWriter writer = new PrintWriter(soc.getOutputStream(), true);
            writer.println(mapper.writeValueAsString(SendClient_data)); // データをJSON形式で送信
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * スレッドの実行内容
     * クライアントからのリクエストを受け取り、対応する処理を実行
     */
    public void run() {
        int a = 0;
        List L = new List();
        ArrayList<ArrayList> seatinfo = new ArrayList<>();
        ArrayList<List.Structure1> r_list = new ArrayList<>();

        // 初回の場合、席情報を初期化
        if (li_count == 0) {
            seatinfo = L.AddL_List(seatinfo, L.NewAddList(1, 6, 2));
            seatinfo = L.AddL_List(seatinfo, L.NewAddList(2, 6, 1, 3));
            seatinfo = L.AddL_List(seatinfo, L.NewAddList(3, 6, 2, 4));
            seatinfo = L.AddL_List(seatinfo, L.NewAddList(4, 6, 3));
            seatinfo = L.AddL_List(seatinfo, L.NewAddList(5, 4, 6, 7));
            seatinfo = L.AddL_List(seatinfo, L.NewAddList(6, 4, 5, 8));
            seatinfo = L.AddL_List(seatinfo, L.NewAddList(7, 4, 5, 8));
            seatinfo = L.AddL_List(seatinfo, L.NewAddList(8, 4, 6, 7));
            seatinfo = L.AddL_List(seatinfo, L.NewAddList(9, 8, 10));
            seatinfo = L.AddL_List(seatinfo, L.NewAddList(10, 8, 9));
            li_count++;
        }

        while (true) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                PrintWriter writer = new PrintWriter(soc.getOutputStream(), true);

                String line;

                // クライアントからのデータを受信
                if ((line = reader.readLine()) != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    HashMap<String, String> de_map = mapper.readValue(line, HashMap.class);
                    System.out.println(de_map);

                    ArrayList list = new ArrayList();
                    ReservationList R = new ReservationList();
                    StringManage S = new StringManage();

                    HashMap<String, String> data = new HashMap<>();
                    String str;

                    // 受信したデータに基づいて処理を分岐
                    switch (de_map.get("Type")) {
                        case "RtS1":
                            // 候補リストを検索してクライアントに送信
                            str = R.Search(seatinfo, r_list, de_map.get("time"), de_map.get("p_num"), de_map.get("e"));
                            String[] str1 = str.split(":");
                            data.put("Type", "StR1");
                            data.put("rec1", str1[0]);
                            data.put("rec2", str1[1]);
                            data.put("rec3", str1[2]);
                            data.put("e", de_map.get("e"));
                            Main.sendall(data);
                            break;

                        case "RtS2":
                            // 予約を確定してリストを更新
                            r_list = R.AddReservation(r_list, de_map.get("time"), de_map.get("p_num"), de_map.get("e"), de_map.get("name"), de_map.get("s_num"));
                            str = S.MakeString(r_list);
                            data.put("Type", "StR2");
                            data.put("list", str);
                            Main.sendall(data);
                            break;

                        case "RtS3":
                            // 予約をキャンセルしてリストを更新
                            r_list = R.DeleteReservation(r_list, de_map.get("time"), de_map.get("s_num"));
                            if (!r_list.isEmpty()) {
                                str = S.MakeString(r_list);
                                data.put("Type", "StR3");
                                data.put("list", str);
                            }
                            Main.sendall(data);
                            break;

                        case "RtS4":
                            // 開始処理
                            String[] seats = de_map.get("s_num").split("/");
                            for (String seat : seats) {
                                data.put("Type", "StZ" + seat);
                                data.put("time", de_map.get("time"));
                                Main.sendall(data);
                            }
                            break;

                        case "ZtS":
                            // 特別な操作を実行
                            String s_num = de_map.get("s_num");
                            data.put("Type", "StR3");
                            data.put("s_num", s_num);
                            r_list = R.DeleteReservation(r_list, de_map.get("time"), s_num);
                            Main.sendall(data);
                            break;
                    }
                }

            } catch (IOException ioex) {
                ioex.printStackTrace();
            } finally {
                try {
                    if (a == 1) {
                        soc.close(); // ソケットを閉じる
                    }
                } catch (IOException ioex) {
                    ioex.printStackTrace();
                }
            }
        }
    }
}
