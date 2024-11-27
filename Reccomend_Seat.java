
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Matcher;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
/**
 */
public class Reccomend_Seat extends javax.swing.JDialog {

    /**
     * Creates new form Reccomend_Seat
     */
    public String re1;
    public String re2;
    public String re3;
    public String e;
    StringBuilder pu_name = new StringBuilder();
    public String time = null;
    public String seki = null;
    public String pop_n = null;
    public String label = null;
    Socket soc;

    private Regi_test4 main = null;

    public void re_setMainFrame(Regi_test4 m) {
        this.main = m;
    }

    public Reccomend_Seat(java.awt.Frame parent, boolean modal, Socket sct) {
        super(parent, modal);
        initComponents();
        soc = sct;
    }

    public void Recommend(String rec1, String rec2, String rec3, String extra) {
        re1 = rec1;
        re2 = rec2;
        re3 = rec3;
        e = extra;

        System.out.println("Recommend::" + re1 + "::" + re2 + "::" + re3 + "::" + e);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Recommend Seat and Time", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("MS UI Gothic", 0, 18))); // NOI18N
        jPanel1.setToolTipText("Response");

        jLabel1.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel1.setText("1.");

        jLabel2.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel2.setText("2.");

        jLabel3.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel3.setText("3.");

        jButton1.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jButton1.setText("NULL");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jButton2.setText("NULL");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jButton3.setText("NULL");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel4.setText("番");

        jLabel5.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel5.setText("～");

        jLabel6.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel6.setText("NULL");

        jLabel7.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel7.setText("NULL");

        jButton6.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jButton6.setText("更新");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel8.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jLabel8.setText("name:");

        jButton4.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jButton4.setText("完了");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("MS UI Gothic", 0, 14)); // NOI18N
        jButton5.setText("入力");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("MS UI Gothic", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        int a;
        if ((Objects.equals(re1, "null")) != true) {
            String[] array01 = re1.split(",");
            this.jLabel6.setText(array01[0]);
            a = Integer.parseInt(array01[2]);

            /*サーバに渡す席番*/
            seki = array01[0];
            /*サーバに渡す人数*/
            pop_n = array01[1];
            /*サーバに渡す時間*/
            time = array01[2];
            label = array01[3];

            if ((a % 100) != ((a % 100) % 10)) {
                this.jLabel7.setText((a / 100) + " " + ":" + " " + (a % 100));
            } else {
                this.jLabel7.setText((a / 100) + " " + ":" + " " + "0" + (a % 100));
            }
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        int b;
        if ((Objects.equals(re2, "null")) != true) {
            String[] array02 = re2.split(",");
            this.jLabel6.setText(array02[0]);
            b = Integer.parseInt(array02[2]);

            /*サーバに渡す席番*/
            seki = array02[0];
            /*サーバに渡す人数*/
            pop_n = array02[1];
            /*サーバに渡す時間*/
            time = array02[2];
            label = array02[3];

            if ((b % 100) != ((b % 100) % 10)) {
                this.jLabel7.setText((b / 100) + " " + ":" + " " + (b % 100));
            } else {
                this.jLabel7.setText((b / 100) + " " + ":" + " " + "0" + (b % 100));

            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        int c;
        if ((Objects.equals(re3, "null")) != true) {
            String[] array03 = re3.split(",");
            this.jLabel6.setText(array03[0]);
            c = Integer.parseInt(array03[2]);

            /*サーバに渡す席番*/
            seki = array03[0];
            /*サーバに渡す人数*/
            pop_n = array03[1];
            /*サーバに渡す時間*/
            time = array03[2];
            label = array03[3];

            if ((c % 100) != ((c % 100) % 10)) {
                this.jLabel7.setText((c / 100) + " " + ":" + " " + (c % 100));
            } else {
                this.jLabel7.setText((c / 100) + " " + ":" + " " + "0" + (c % 100));

            }
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        /*日本語のキーボードを表示する*/
        Regi_Dialog_jp dialog = new Regi_Dialog_jp(main, true);
        dialog.re_setMainFrame(this);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        int flag = 0;

        /*何かが入力されていない時*/
        if (pu_name.length() == 0 || time == null || seki == null || pop_n == null) {
            System.out.println("taka");
            Recommend_Error dialog = new Recommend_Error(main, true);
            dialog.setVisible(true);
            flag = 1;
        }

        if (flag == 0) {
            System.out.println("完了");

            String name_s = pu_name.toString();

            HashMap<String, String> data = new HashMap<String, String>();
            data.put("Type", "RtS2");
            data.put("time", time);
            data.put("s_num", seki);
            data.put("p_num", pop_n);
            data.put("name", name_s);
            data.put("e", label);

            try {
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
                ObjectMapper mapper = new ObjectMapper();
                writer.println(mapper.writeValueAsString(data));
                writer.flush();
                //writer.close();
                this.dispose();
                flag = 2;

            } catch (IOException e) {
                // 例外処理
                e.printStackTrace();
            }

        }
        
        if (flag == 2) {
            pu_name.setLength(0);
            time = null;
            pop_n = null;
            seki = null;
            label = null;
        }

        this.jTextArea1.setText("");
        this.jButton1.setText("NULL");
        this.jButton2.setText("NULL");
        this.jButton3.setText("NULL");


    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        int a;
        int b;
        int c;
        
        if((Objects.equals(re1, "null")) == true || (Objects.equals(re1, "null")) == true ||  (Objects.equals(re1, "null")) == true){
            this.jButton1.setText("候補がありません");
            this.jButton2.setText("候補がありません");
            this.jButton3.setText("候補がありません");
        }


        /*席番、人数、時間に分ける*/
        if ((Objects.equals(re1, "null")) != true) {
            String[] array01 = re1.split(",");
            a = Integer.parseInt(array01[2]);

            if ((a % 100) != ((a % 100) % 10)) {
                this.jButton1.setText(array01[0] + "番" + "   " + (a / 100) + " " + ":" + " " + (a % 100) + "～");
            } else {
                this.jButton1.setText(array01[0] + "番" + "   " + (a / 100) + " " + ":" + " " + "0" + (a % 100) + "～");
            }
        }

        /*席番、人数、時間に分ける*/
        if ((Objects.equals(re2, "null")) != true) {
            String[] array02 = re2.split(",");
            b = Integer.parseInt(array02[2]);

            if ((b % 100) != ((b % 100) % 10)) {
                this.jButton2.setText(array02[0] + "番" + "   " + (b / 100) + " " + ":" + " " + (b % 100) + "～");
            } else {
                this.jButton2.setText(array02[0] + "番" + "   " + (b / 100) + " " + ":" + " " + "0" + (b % 100) + "～");

            }
        }

        /*席番、人数、時間に分ける*/
        System.out.println("jbutton6::" + re3);
        if ((Objects.equals(re3, "null")) != true) {
            String[] array03 = re3.split(",");
            c = Integer.parseInt(array03[2]);

            if ((c % 100) != ((c % 100) % 10)) {
                this.jButton3.setText(array03[0] + "番" + "   " + (c / 100) + " " + ":" + " " + (c % 100) + "～");
            } else {
                this.jButton3.setText(array03[0] + "番" + "   " + (c / 100) + " " + ":" + " " + "0" + (c % 100) + "～");

            }
        }


    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public void nameSet(String n) {
        /*人数が何人なのかを表示する*/
        if (n == "-1") {
            this.jTextArea1.setText("");
            // クリアする
            pu_name.setLength(0);
        } else {
            this.jTextArea1.append(n);
            pu_name.append(n);
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reccomend_Seat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reccomend_Seat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reccomend_Seat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reccomend_Seat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}