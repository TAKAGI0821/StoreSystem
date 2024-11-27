/*
 * nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt をクリックしてライセンスを変更可能
 * nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java をクリックしてテンプレートを編集可能
 */

/**
 * 入力エラーに関するガイドを表示するダイアログ
 */
public class Error_Registration extends javax.swing.JDialog {

    /**
     * Error_Registrationクラスのコンストラクタ
     * @param parent 親フレーム
     * @param modal モーダルダイアログかどうか
     */
    public Error_Registration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); // GUIコンポーネントを初期化
    }

    /**
     * GUIの初期化メソッド。
     * このコードはNetBeansのGUIデザイナによって自動生成されています。
     * 手動での編集は非推奨です。
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // ラベルの宣言とテキスト設定
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        // ダイアログの終了動作とタイトル設定
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registration Error");

        // 各ラベルのテキストとフォント設定
        jLabel1.setFont(new java.awt.Font("MS UI Gothic", 0, 14)); // NOI18N
        jLabel1.setText("正しい記入方法");

        jLabel3.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel3.setText("正しい入力をしてください。");

        jLabel4.setFont(new java.awt.Font("MS UI Gothic", 0, 14)); // NOI18N
        jLabel4.setText("・人数を入力する前に0は付けないようにしてください。例：09、005など");

        jLabel5.setFont(new java.awt.Font("MS UI Gothic", 0, 14)); // NOI18N
        jLabel5.setText("・時間（H）を入力する前に0は付けないようにしてください。例：09,005など");

        jLabel6.setFont(new java.awt.Font("MS UI Gothic", 0, 14)); // NOI18N
        jLabel6.setText("・入力できる人数は1以上16以下です。");

        jLabel7.setFont(new java.awt.Font("MS UI Gothic", 0, 14)); // NOI18N
        jLabel7.setText("・入力できる時間は17:00～23:00です。");

        jLabel8.setFont(new java.awt.Font("MS UI Gothic", 0, 14)); // NOI18N
        jLabel8.setText("・1桁の時間（M）を入力するときに00と入力しないでください。例：009,005など");

        // レイアウト設定
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(19, 19, 19))
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
            java.util.logging.Logger.getLogger(Error_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Error_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Error_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Error_Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* ダイアログを作成して表示 */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Error_Registration dialog = new Error_Registration(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1; // タイトルラベル
    private javax.swing.JLabel jLabel3; // メインメッセージラベル
    private javax.swing.JLabel jLabel4; // 入力例ラベル1
    private javax.swing.JLabel jLabel5; // 入力例ラベル2
    private javax.swing.JLabel jLabel6; // 入力例ラベル3
    private javax.swing.JLabel jLabel7; // 入力例ラベル4
    private javax.swing.JLabel jLabel8; // 入力例ラベル5
    // End of variables declaration//GEN-END:variables
}
