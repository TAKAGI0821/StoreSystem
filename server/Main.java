package server;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * サーバープログラムのメインクラス
 */
public class Main {
    private static SrvThread[] clients;

    /**
     * 全てのクライアントにデータを送信する
     * 
     * @param Sendall_data 送信するデータのハッシュマップ
     */
    public static void sendall(HashMap<String, String> Sendall_data) {
        System.out.println("sendall::start");

        int j = 0;
        for (SrvThread c1 : clients) {
            System.out.println("sendall::" + j++);
            c1.Thread_Recieve_and_SendtoClient(Sendall_data);
        }
    }

    public static void main(String[] args) {
        // 店のIDを判定する正規表現パターン
        Pattern ptn1 = Pattern.compile("1");
        Pattern ptn1_1 = Pattern.compile("1_1");
        ServerSocket serverSoc = null;
        clients = new SrvThread[2]; // 最大接続クライアント数
        int connectedCount = 0;

        try {
            // サーバーソケットを30000番ポートで作成
            serverSoc = new ServerSocket(30000);
            boolean flag = true;

            System.out.println("Waiting for Connection. ");
            while (flag) {
                Socket socket = null;

                // クライアントからの接続を待機
                socket = serverSoc.accept();

                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                    // クライアントから受信したデータを読み込む
                    String line = reader.readLine();
                    Matcher mc1 = ptn1.matcher(line);
                    Matcher mc1_1 = ptn1_1.matcher(line);

                    while (true) {
                        // 店のIDを確認し、適切な処理を実行
                        if (mc1.matches() || mc1_1.matches()) {
                            // 該当する店のIDが見つかったことをクライアントに通知
                            writer.println(line);
                            writer.flush();

                            // 店1に対応するスレッドを開始
                            if (connectedCount < clients.length) {
                                clients[connectedCount] = new SrvThread(socket);
                                clients[connectedCount].start();
                                connectedCount++;
                            }
                            break;

                        } else {
                            // 該当する店が存在しない場合の処理
                            System.out.println("この店の情報はありません");
                            writer.println("-1");
                            writer.flush();
                        }
                    }

                } catch (IOException ioex) {
                    ioex.printStackTrace();
                }

                System.out.println("Waiting for New Connection. ");
            }
        } catch (IOException e) {
            System.out.println("IOException!");
            e.printStackTrace();
        } finally {
            // サーバーソケットをクローズ
            try {
                if (serverSoc != null) {
                    serverSoc.close();
                }
            } catch (IOException ioex) {
                ioex.printStackTrace();
            }
        }
    }
}
