package userui;

import javax.swing.ImageIcon;
import utility.CommonOperations;

public class UserMainScreen extends javax.swing.JFrame {

    private String username;
    private int testid;

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserMainScreen() {
        try {
            ImageIcon icon;
            icon = new ImageIcon(getClass().getResource("/adminui/icon.png"));
            setIconImage(icon.getImage());
        } catch (Exception ex) {
        }
        initComponents();
        setSize(1000, 650);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myDesktopPane1 = new userui.MyDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiChooseSubject = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiViewResult = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiChange = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userui/start1.png"))); // NOI18N
        jMenu1.setText("Start Test");

        jmiChooseSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userui/choose.png"))); // NOI18N
        jmiChooseSubject.setText("Choose Subject");
        jmiChooseSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiChooseSubjectActionPerformed(evt);
            }
        });
        jMenu1.add(jmiChooseSubject);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userui/view.png"))); // NOI18N
        jMenu2.setText("View Result");

        jmiViewResult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userui/vieww.png"))); // NOI18N
        jmiViewResult.setText("View Last Result");
        jmiViewResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewResultActionPerformed(evt);
            }
        });
        jMenu2.add(jmiViewResult);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userui/settings.png"))); // NOI18N
        jMenu3.setText("Settings");

        jmiChange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userui/change.png"))); // NOI18N
        jmiChange.setText("Change Password");
        jmiChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiChangeActionPerformed(evt);
            }
        });
        jMenu3.add(jmiChange);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(myDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(myDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiChangeActionPerformed
        CommonOperations.showScreen(myDesktopPane1, new ChangePassword(username));
    }//GEN-LAST:event_jmiChangeActionPerformed

    private void jmiChooseSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiChooseSubjectActionPerformed
        CommonOperations.showScreen(myDesktopPane1, new ChooseScreen(username));
    }//GEN-LAST:event_jmiChooseSubjectActionPerformed

    private void jmiViewResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewResultActionPerformed
        CommonOperations.showScreen(myDesktopPane1, new ViewLastResult(username));
    }//GEN-LAST:event_jmiViewResultActionPerformed

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
            java.util.logging.Logger.getLogger(UserMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmiChange;
    private javax.swing.JMenuItem jmiChooseSubject;
    private javax.swing.JMenuItem jmiViewResult;
    private userui.MyDesktopPane myDesktopPane1;
    // End of variables declaration//GEN-END:variables
}
