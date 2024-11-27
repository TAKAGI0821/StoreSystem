package server;

import java.util.ArrayList;

/**
 * リスト操作および構造体を扱うユーティリティクラス
 */
public class List {
    
    /**
     * 新しいStructure1をリストに追加
     * @param list1 Structure1を保持するリスト
     * @param x Structure1のaフィールド
     * @param y Structure1のbフィールド
     * @param z Structure1のcフィールド
     * @param str Structure1のstrフィールド
     * @param list Structure1のlistフィールド
     * @return 更新されたリスト
     */
    public ArrayList<Structure1> AddStructure(ArrayList<Structure1> list1, int x, int y, int z, String str, ArrayList list) {
        list1.add(SetStructure1(x, y, z, str, list));
        return list1;
    }
    
    /**
     * Structure1のインスタンスを作成
     * @param x aフィールド
     * @param y bフィールド
     * @param z cフィールド
     * @param str strフィールド
     * @param list listフィールド
     * @return 新しいStructure1インスタンス
     */
    public Structure1 SetStructure1(int x, int y, int z, String str, ArrayList list) {
        Structure1 S = new Structure1();
        S.a = x;
        S.b = y;
        S.c = z;
        S.str = str;
        S.list = list;
        return S;
    }
    
    public class Structure1 {
        int a;
        int b;
        int c;
        String str;
        ArrayList list;
    }
    
    /**
     * Structure1をリストから削除
     * @param list1 Structure1を保持するリスト
     * @param x 削除条件に使用するaフィールドの値
     * @param list 削除条件に使用するlistフィールドの内容
     * @return 更新されたリスト
     */
    public ArrayList<Structure1> DeleteStructure(ArrayList<Structure1> list1, int x, ArrayList list) {
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).a == x && list1.get(i).list.size() == list.size()) {
                int flag = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list1.get(i).list.get(j) == list.get(j)) {
                        flag++;
                    }
                }
                if (flag == list.size()) {
                    list1.remove(i);
                }
            }
        }
        return list1;
    }

    // 単純なリストの操作
    public ArrayList AddList(ArrayList list, int... x) {
        for (int i : x) {
            list.add(i);
        }
        return list;
    }

    public ArrayList NewAddList(int... x) {
        ArrayList list = new ArrayList();
        for (int i : x) {
            list.add(i);
        }
        return list;
    }

    public int TakeList(ArrayList list, int x) {
        return (int) list.get(x);
    }

    public void PrintList(ArrayList list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }

    // 要素数3の構造体を扱うリストの操作
    public ArrayList<Structure3> AddS3_List(ArrayList<Structure3> s3_list, int x, int y, int z) {
        s3_list.add(SetStr3(x, y, z));
        return s3_list;
    }

    public int TakeS3_List(ArrayList<Structure3> s3_list, int x, int y) {
        switch (y) {
            case 1:
                return s3_list.get(x).a;
            case 2:
                return s3_list.get(x).b;
            case 3:
                return s3_list.get(x).c;
        }
        return 0;
    }

    public ArrayList TakeS3_List_List(ArrayList<Structure3> s3_list, int x) {
        ArrayList list = new ArrayList();
        AddList(list, s3_list.get(x).a, s3_list.get(x).b, s3_list.get(x).c);
        return list;
    }

    public Structure3 SetStr3(int x, int y, int z) {
        Structure3 str3 = new Structure3();
        str3.a = x;
        str3.b = y;
        str3.c = z;
        return str3;
    }

    class Structure3 {
        int a;
        int b;
        int c;
    }

    // リストのリストを扱う操作
    public ArrayList<ArrayList> AddL_List(ArrayList<ArrayList> l_list, ArrayList list) {
        l_list.add(list);
        return l_list;
    }

    public ArrayList TakeL_List(ArrayList<ArrayList> l_list, int x) {
        return l_list.get(x);
    }

    // リストを含む要素数3の構造体を扱うリストの操作
    public ArrayList<Structure3L> AddS3L_List(ArrayList<Structure3L> s3l_list, int x, int y, ArrayList list) {
        s3l_list.add(SetStr3L(x, y, list));
        return s3l_list;
    }

    public int TakeES3L_List(ArrayList<Structure3L> s3l_list, int x, int y) {
        switch (y) {
            case 1:
                return s3l_list.get(x).a;
            case 2:
                return s3l_list.get(x).b;
        }
        return 0;
    }

    public ArrayList TakeLS3L_List(ArrayList<Structure3L> s3l_list, int x) {
        return s3l_list.get(x).c;
    }

    public ArrayList TakeS3L_List_List(ArrayList<Structure3L> s3l_list, int x) {
        ArrayList list = new ArrayList();
        AddList(list, s3l_list.get(x).a, s3l_list.get(x).b);
        AddL_List(list, s3l_list.get(x).c);
        return list;
    }

    public Structure3L SetStr3L(int x, int y, ArrayList list) {
        Structure3L str3l = new Structure3L();
        str3l.a = x;
        str3l.b = y;
        str3l.c.add(list);
        return str3l;
    }

    class Structure3L {
        int a;
        int b;
        ArrayList c = new ArrayList();
    }
}
