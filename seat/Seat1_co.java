// 必要なライブラリのインポート
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * 座席番号1のクライアント用プログラム
 * 「いらっしゃいませ」画面を表示し、サーバとの通信を管理します。
 * 
 */
public class Seat1_co extends javax.swing.JFrame {

    // サーバとの通信に使用するソケット
    Socket soc;

    /**
     * コンストラクタ
     * ソケットを受け取り、画面を初期化します。
     *
     * @param sct 接続済みのソケット
     */
    public Seat1_co(Socket sct) {
        initComponents();
        soc = sct;
    }

    /**
     * GUIコンポーネントの初期化処理（自動生成コード）
     * 警告：このコードは直接編集しないでください。
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        // GUIコンポーネントの設定
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        // ウィンドウの設定
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("座席番号10");

        jLabel1.setFont(new java.awt.Font("MS UI Gothic", 0, 36));
        jLabel1.setText("いらっしゃいませ！");

        jButton1.setText("終了");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("MS UI Gothic", 0, 18));
        jLabel2.setText("店長のオススメ 期間限定商品 ○○～");

        // レイアウト設定
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }

    /**
     * 終了ボタンがクリックされた際の処理
     * サーバとの接続を閉じて画面を閉じます。
     */
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
        try {
            soc.close(); // ソケットを閉じる
            this.dispose(); // 画面を閉じる
        } catch (IOException ex) {
            Logger.getLogger(Seat1_co.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 画面をクリア（閉じる）するメソッド
     */
    public void Clear() {
        this.dispose();
    }

    /**
     * メインメソッド
     * サーバに接続し、通信の初期化を行います。
     */
    public static void main(String args[]) {
        try {
            // サーバとの接続設定
            Socket socket = new Socket("自分のIPアドレス", 30000);
            System.out.println("サーバに接続しました。IPアドレス " + socket.getInetAddress() + " ポート " + socket.getPort());

            // 店のパスワードを送信
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.println("1_1");
            System.out.println("[送信] 1_1");
            writer.flush();

            // サーバからのレスポンスを受信
            BufferedReader reader_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String Open_res = reader_socket.readLine();
            System.out.println("[受信] " + Open_res);

            // サーバ通信スレッドを開始
            new SrvThread_seat1(socket).start();

        } catch (IOException e) {
            System.out.println("IOException!");
            e.printStackTrace();
        }
    }

    // GUIコンポーネント
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}

// 店1用のサーバ通信スレッド
class SrvThread_seat1 extends Thread {

    private Socket soc;
    Seat1_co frame = new Seat1_co(soc);

    public SrvThread_seat1(Socket sct) {
        soc = sct;
    }

    @Override
    public void run() {
        // 「いらっしゃいませ」の画面を表示
        java.awt.EventQueue.invokeLater(() -> {
            Seat1_co frame = new Seat1_co(soc);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

        // サーバからのデータを受信し続ける
        while (true) {
            try {
                BufferedReader reader_socket = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                String line;
                if ((line = reader_socket.readLine()) != null) {
                    ObjectMapper mapper = new ObjectMapper();
                    HashMap<String, String> de_map = mapper.readValue(line, HashMap.class);
                    System.out.println("受信したデータ: " + de_map);

                    // スタート要求があった場合
                    if (Objects.equals(de_map.get("Type"), "StZ10")) {
                        // 注文画面に切り替え
                        java.awt.EventQueue.invokeLater(() -> {
                            Seat1_JF frame_JF = new Seat1_JF(soc, de_map.get("time"));
                            frame_JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame_JF.setVisible(true);
                        });
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
