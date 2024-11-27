package server;

import java.util.ArrayList;

/**
 * リストやカスタムオブジェクト構造を操作するための文字列処理ユーティリティクラス
 * 
 */
public class StringManage {

    /**
     * Structure1オブジェクトのリストを1つのフォーマット済み文字列に変換する。
     * 各オブジェクトはカンマで区切られ、オブジェクト同士はコロンで区切られる。
     *
     * @param list List.Structure1オブジェクトのArrayList
     * @return フォーマットされた文字列
     */
    public String MakeString(ArrayList<List.Structure1> list) {
        String str;
        String str1;
        int a = list.get(0).a;
        int b = list.get(0).b;
        int c = list.get(0).c;
        String str2 = list.get(0).str;
        ArrayList<?> list1 = list.get(0).list;
        str = a + "," + MakeSlash(list1) + "," + str2 + "," + b + "," + c;

        for (int i = 1; i < list.size(); i++) {
            a = list.get(i).a;
            b = list.get(i).b;
            c = list.get(i).c;
            str2 = list.get(i).str;
            list1 = list.get(i).list;
            str1 = a + "," + MakeSlash(list1) + "," + str2 + "," + b + "," + c;
            str = str + ":" + str1;
        }
        return str;
    }

    /**
     * 整数を文字列に変換する。
     *
     * @param a 整数値
     * @return 文字列形式の整数
     */
    public String ChangeString(int a) {
        return Integer.toString(a);
    }

    /**
     * 文字列を整数に変換する。
     *
     * @param str 文字列形式の整数
     * @return 整数値
     */
    public int ChangeInteger(String str) {
        return Integer.parseInt(str);
    }

    /**
     * 整数リストをスラッシュ区切りの文字列に変換する。
     *
     * @param list 整数のArrayList
     * @return スラッシュ区切り文字列
     */
    public String MakeSlash(ArrayList<?> list) {
        String str = ChangeString((int) list.get(0));
        for (int i = 1; i < list.size(); i++) {
            str = str + "/" + list.get(i);
        }
        return str;
    }

    /**
     * スラッシュ区切りの文字列を整数リストに変換する。
     *
     * @param str スラッシュ区切り文字列
     * @return 整数のArrayList
     */
    public ArrayList<Integer> DeleteSlash(String str) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] data = str.split("/");
        for (String s : data) {
            list.add(ChangeInteger(s));
        }
        return list;
    }

    /**
     * 整数リストをカンマ区切りの文字列に変換する。
     *
     * @param list 整数のArrayList
     * @return カンマ区切り文字列
     */
    public String MakeComma(ArrayList<?> list) {
        String str = ChangeString((int) list.get(0));
        for (int i = 1; i < list.size(); i++) {
            str = str + "," + list.get(i);
        }
        return str;
    }

    /**
     * カンマ区切りの文字列を整数リストに変換する。
     *
     * @param str カンマ区切り文字列
     * @return 整数のArrayList
     */
    public ArrayList<Integer> DeleteComma(String str) {
        ArrayList<Integer> list = new ArrayList<>();
        String[] data = str.split(",");
        for (String s : data) {
            list.add(ChangeInteger(s));
        }
        return list;
    }
}
