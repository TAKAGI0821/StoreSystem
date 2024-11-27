/*
 * nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt をクリックしてライセンスを変更可能
 * nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java をクリックしてテンプレートを編集可能
 */

/**
 * エラーダイアログを表示するクラス
 */
public class Error_Open extends javax.swing.JDialog {

    /**
     * Error_Openクラスのコンストラクタ
     * @param parent 親フレーム
     * @param modal モーダルダイアログかどうか
     */
    public Error_Open(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); // GUIコンポーネントの初期化
    }

    /**
     * コンストラクタ内で呼び出されるGUI初期化メソッド。
     * このメソッドはNetBeansのGUIデザイナによって自動生成されるため、
     * 手動での変更は推奨されません。
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // ラベルの定義とプロパティ設定
        jLabel1 = new javax.swing.JLabel();

        // ダイアログの閉じる動作とタイトル設定
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Open Error");

        // ラベルのテキストとフォント設定
        jLabel1.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel1.setText("この店のIDを入力してください");

        // レイアウト設定
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack(); // ダイアログのサイズを自動調整
    }// </editor-fold>//GEN-END:initComponents

    /**
     * アプリケーションを起動するメインメソッド
     * @param args コマンドライン引数
     */
    public static void main(String args[]) {
        /* Nimbus外観を設定 */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Error.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Error.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Error.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Error.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* ダイアログを作成して表示 */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Error_Open dialog = new Error_Open(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0); // アプリケーションを終了
                    }
                });
                dialog.setVisible(true); // ダイアログを表示
            }
        });
    }

    // メンバ変数の宣言（NetBeansによる自動生成部分）
    private javax.swing.JLabel jLabel1; // ラベルコンポーネント
    // End of variables declaration//GEN-END:variables
}
