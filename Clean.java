/*
 * クリックして nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt からライセンスを変更してください
 * クリックして nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java を編集してください
 */

/**
 * 掃除完了の通知を表示するダイアログクラス
 */
public class Clean extends javax.swing.JDialog {

    /**
     * Cleanクラスのコンストラクタ
     * @param parent 親フレーム
     * @param modal モーダルダイアログかどうか
     */
    public Clean(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); // GUIコンポーネントの初期化
    }

    /**
     * コンストラクタ内で呼び出されるメソッド。
     * GUIコンポーネントを初期化します。
     * このメソッドの内容はNetBeansのGUIエディタによって自動生成されます。
     * 手動での変更は推奨されません。
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        // ラベルコンポーネントの定義
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        // ウィンドウのデフォルトの終了動作を設定（ダイアログを閉じる）
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // jLabel1のプロパティを設定
        jLabel1.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // フォントの設定
        jLabel1.setText("掃除完了を受信しました。"); // テキストの設定

        // jLabel2のプロパティを設定
        jLabel2.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // フォントの設定
        jLabel2.setText("画面を更新してください。"); // テキストの設定

        // レイアウトの設定
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack(); // ダイアログのサイズ調整
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
            java.util.logging.Logger.getLogger(Clean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* ダイアログを作成して表示 */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Clean dialog = new Clean(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0); // アプリケーションを終了
                    }
                });
                dialog.setVisible(true); // ダイアログを可視化
            }
        });
    }

    // メンバ変数の宣言（NetBeans GUIエディタによって生成）
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
}
