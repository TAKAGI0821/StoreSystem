/*
 * nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt をクリックしてライセンスを変更可能
 * nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java をクリックしてテンプレートを編集可能
 */

/**
 * 通信終了時に表示するダイアログクラス
 */
public class Exit extends javax.swing.JDialog {

    /**
     * Exitクラスのコンストラクタ
     * @param parent 親フレーム
     * @param modal モーダルダイアログかどうか
     */
    public Exit(java.awt.Frame parent, boolean modal) {
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

        // ラベルの宣言と初期化
        jLabel1 = new javax.swing.JLabel();

        // ダイアログの終了動作設定
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        // ラベルの設定
        jLabel1.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel1.setText("通信を正常に終了しました");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt); // クリックイベントを処理
            }
        });

        // レイアウト設定
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack(); // ダイアログのサイズを自動調整
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // ラベルがクリックされたときの処理（未実装）
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(Exit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* ダイアログを作成して表示 */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Exit dialog = new Exit(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1; // ラベル
    // End of variables declaration//GEN-END:variables
}
