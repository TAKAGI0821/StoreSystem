package server;

import java.util.ArrayList;
import server.List.Structure1;

/**
 * 予約管理クラス
 * 予約の追加、削除、検索を行う
 */
public class ReservationList {

    /**
     * 予約を追加する
     *
     * @param list 既存の予約リスト
     * @param a 予約情報（時間、人数、ラベル、名前、座席情報）
     * @return 更新された予約リスト
     */
    public ArrayList<List.Structure1> AddReservation(ArrayList<List.Structure1> list, String... a) {
        List L = new List();
        StringManage SM = new StringManage();
        int time = Integer.parseInt(a[0]);
        int count = Integer.parseInt(a[1]);
        int label = Integer.parseInt(a[2]);
        String name = a[3];
        ArrayList seat = SM.DeleteSlash(a[4]);
        list = L.AddStructure(list, time, count, label, name, seat);
        return list;
    }

    /**
     * 予約を削除する
     *
     * @param list 既存の予約リスト
     * @param a 削除対象の予約情報（時間、座席情報）
     * @return 更新された予約リスト
     */
    public ArrayList<List.Structure1> DeleteReservation(ArrayList<List.Structure1> list, String... a) {
        List L = new List();
        StringManage SM = new StringManage();
        int time = Integer.parseInt(a[0]);
        ArrayList seat = SM.DeleteSlash(a[1]);
        L.DeleteStructure(list, time, seat);
        return list;
    }

    /**
     * 座席を検索する
     *
     * @param seatinfo 座席情報（座席番号、収容人数）
     * @param r_list 既存の予約リスト
     * @param a 検索条件（時間、人数、ラベル）
     * @return 検索結果をカンマ区切りの文字列で返す
     */
    public String Search(ArrayList<ArrayList> seatinfo, ArrayList<List.Structure1> r_list, String... a) {
        List L = new List();

        int time = Integer.parseInt(a[0]); // 検索時間
        int count = Integer.parseInt(a[1]); // 検索人数
        int label = Integer.parseInt(a[2]); // ラベル

        // 簡易予約リストを作成（座席番号、開始時間、終了時間）
        ArrayList<ArrayList> r1_list = new ArrayList<>();
        for (List.Structure1 item : r_list) {
            ArrayList l = new ArrayList();
            int seat = (int) item.list.get(0);
            int starttime = (int) item.a;
            int endtime = starttime + ((int) item.c) * 100;
            r1_list = L.AddL_List(r1_list, L.AddList(l, seat, starttime, endtime));
        }

        // 人数に基づく座席フィルタリング
        ArrayList<ArrayList> c_seat = new ArrayList<>();
        for (ArrayList seatData : seatinfo) {
            int seatcapa = (int) seatData.get(1);
            if (seatcapa >= count) {
                ArrayList l = new ArrayList();
                int seat = (int) seatData.get(0);
                int prim = seatcapa - count;
                c_seat = L.AddL_List(c_seat, L.AddList(l, seat, prim));
            }
        }

        // 簡易予約リストを時間で昇順ソート
        r1_list.sort((a1, a2) -> Integer.compare((int) a1.get(1), (int) a2.get(1)));

        // 各座席に対する検索処理
        ArrayList<ArrayList> c_list = new ArrayList<>();
        for (ArrayList seatData : c_seat) {
            int currentTime = time;
            int seat = (int) seatData.get(0);

            for (ArrayList rData : r1_list) {
                int r_seat = (int) rData.get(0);
                if (seat == r_seat) {
                    currentTime = SearchTime(rData, seat, currentTime, label);
                }
            }

            if (currentTime + label * 100 <= 2300) {
                ArrayList l = new ArrayList();
                int prim = (int) seatData.get(1) + currentTime - time;
                c_list = L.AddL_List(c_list, L.AddList(l, seat, count, currentTime, prim));
            }
        }

        if (c_list.isEmpty()) {
            return "null:null:null";
        }

        // 優先度に基づく座席候補リストのソート
        c_list.sort((a1, a2) -> Integer.compare((int) a1.get(3), (int) a2.get(3)));

        // 検索結果を文字列形式に変換
        StringManage SM = new StringManage();
        StringBuilder str = new StringBuilder(SM.MakeComma(c_list.get(0)));
        for (int i = 1; i < c_list.size(); i++) {
            str.append(":").append(SM.MakeComma(c_list.get(i)));
        }
        str.append(":null:null:null");

        return str.toString();
    }

    /**
     * 時間検索ロジック
     *
     * @param r_list 予約リスト
     * @param seat 座席番号
     * @param time 現在の時間
     * @param label ラベル
     * @return 更新された時間
     */
    public int SearchTime(ArrayList r_list, int seat, int time, int label) {
        int starttime = (int) r_list.get(1);
        int endtime = (int) r_list.get(2);

        if ((starttime <= time && time <= endtime) || (starttime <= time + label * 100 && time + label * 100 <= endtime)) {
            time = endtime;
        }

        return time;
    }
}
