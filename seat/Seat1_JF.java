import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Objects;

/**
 * 座席1の注文画面を管理するクラス
 */
public class Seat1_JF extends javax.swing.JFrame {

    // 静的フィールドの定義
    static String signal_comp; // 状態を示す信号（初期値: null）
    private Socket soc; // 通信に使用するソケット
    static StringBuilder pass = new StringBuilder(); // パスワード用の文字列
    public static String Time; // 時間情報（サーバから受信）

    /**
     * コンストラクタ
     * @param sct ソケット
     * @param t サーバから受信した時間情報
     */
    public Seat1_JF(Socket sct, String t) {
        initComponents(); // GUIコンポーネントの初期化
        signal_comp = "null"; // 初期値設定
        soc = sct; // ソケットの設定
        Time = t; // 時間情報の設定
    }

    /**
     * GUIコンポーネントの初期化
     * このメソッドは自動生成されたコードで、直接編集しないことを推奨。
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        // ボタンやタブの作成・設定
        // 各ボタンやタブの動作イベントは以下で定義されています
    }

    /**
     * 「会計」ボタンがクリックされた時の動作
     * @param evt マウスクリックイベント
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        // 「ありがとうございました」の画面を表示
        Thanks th = new Thanks(this, true);
        th.setVisible(true);

        // 掃除完了ダイアログを開く
        S1_C dialog = new S1_C(this, false, soc);
        dialog.setVisible(true);
        dialog.Seat1_JF_setFrame(this); // フレームの設定
    }

    /**
     * 入力されたパスワードを設定する
     * @param a 入力文字列 (-1 の場合はクリア)
     */
    public void Set(String a) {
        if (Objects.equals(a, "-1")) {
            pass.setLength(0); // パスワードをクリア
        } else {
            pass.append(a); // パスワードを追加
        }
    }

    /**
     * 掃除完了状態をサーバに送信
     */
    public void Set_Comp() {
        System.out.println("Set_Comp::" + pass);

        // パスワードが正しい場合
        if (Objects.equals(pass.toString(), "123")) {
            System.out.println("Set_Comp::パスワードあってますよ");
            pass.setLength(0); // パスワードをクリア

            try {
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));

                // サーバに掃除完了を通知するデータを送信
                HashMap<String, String> data = new HashMap<>();
                data.put("Type", "ZtS");
                data.put("s_num", "10");
                data.put("time", Time);

                ObjectMapper mapper = new ObjectMapper();
                writer.println(mapper.writeValueAsString(data)); // JSON形式で送信
                writer.flush();

                // 掃除完了後に画面を閉じる
                this.dispose();

            } catch (IOException e) {
                System.out.println("IOException!");
                e.printStackTrace();
            }

        } else {
            // パスワードが間違っている場合
            Error dialog = new Error(this, true);
            dialog.setVisible(true);
        }
    }

    /**
     * メインメソッド (テスト用)
     */
    public static void main(String args[]) {
        // Nimbus Look and Feelの設定（UIの見た目を調整）
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // GUIコンポーネントの宣言（NetBeansのGUIエディタが生成）
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane11;
    private javax.swing.JTabbedPane jTabbedPane12;
    private javax.swing.JTabbedPane jTabbedPane13;
    private javax.swing.JTabbedPane jTabbedPane14;
    private javax.swing.JTabbedPane jTabbedPane15;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTabbedPane jTabbedPane9;
}
