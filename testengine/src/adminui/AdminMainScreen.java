package adminui;

import java.beans.PropertyVetoException;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

public class AdminMainScreen extends javax.swing.JFrame {

    public AdminMainScreen() {
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

        deskpane = new javax.swing.JDesktopPane();
        desktopPane2 = new adminui.DesktopPane();
        desktopPane1 = new adminui.DesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jmiAddSubject = new javax.swing.JMenuItem();
        jmiViewSubject = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jmiAddSection = new javax.swing.JMenuItem();
        jmiViewSection = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiAddTest = new javax.swing.JMenuItem();
        jmiViewTest = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiAddQuestion = new javax.swing.JMenuItem();
        jmiViewQuestion = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jmiViewResult = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jmiAddStudent = new javax.swing.JMenuItem();
        jmiViewStudent = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane2.add(desktopPane1);
        desktopPane1.setBounds(0, 0, 0, 0);

        javax.swing.GroupLayout deskpaneLayout = new javax.swing.GroupLayout(deskpane);
        deskpane.setLayout(deskpaneLayout);
        deskpaneLayout.setHorizontalGroup(
            deskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        deskpaneLayout.setVerticalGroup(
            deskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );
        deskpane.setLayer(desktopPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(deskpane, java.awt.BorderLayout.CENTER);

        jMenu3.setText("Subject Operations");

        jmiAddSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/addd.png"))); // NOI18N
        jmiAddSubject.setText("Add New Subject");
        jmiAddSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddSubjectActionPerformed(evt);
            }
        });
        jMenu3.add(jmiAddSubject);

        jmiViewSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/vieww.png"))); // NOI18N
        jmiViewSubject.setText("View Subject Details");
        jmiViewSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewSubjectActionPerformed(evt);
            }
        });
        jMenu3.add(jmiViewSubject);

        jMenuBar1.add(jMenu3);

        jMenu1.setBorder(null);
        jMenu1.setText("Section Operations");

        jmiAddSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/addd.png"))); // NOI18N
        jmiAddSection.setText("Add New Section");
        jmiAddSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddSectionActionPerformed(evt);
            }
        });
        jMenu1.add(jmiAddSection);

        jmiViewSection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/vieww.png"))); // NOI18N
        jmiViewSection.setText("View Section Details");
        jmiViewSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewSectionActionPerformed(evt);
            }
        });
        jMenu1.add(jmiViewSection);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Test Operations");

        jmiAddTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/addd.png"))); // NOI18N
        jmiAddTest.setText("Add New Test");
        jmiAddTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddTestActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAddTest);

        jmiViewTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/vieww.png"))); // NOI18N
        jmiViewTest.setText("View Test Details");
        jmiViewTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewTestActionPerformed(evt);
            }
        });
        jMenu2.add(jmiViewTest);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Question Operations");

        jmiAddQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/addd.png"))); // NOI18N
        jmiAddQuestion.setText("Add New Question");
        jmiAddQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddQuestionActionPerformed(evt);
            }
        });
        jMenu4.add(jmiAddQuestion);

        jmiViewQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/vieww.png"))); // NOI18N
        jmiViewQuestion.setText("View Question Details");
        jmiViewQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewQuestionActionPerformed(evt);
            }
        });
        jMenu4.add(jmiViewQuestion);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Result Operations");

        jmiViewResult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/vieww.png"))); // NOI18N
        jmiViewResult.setText("View Result Details");
        jmiViewResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewResultActionPerformed(evt);
            }
        });
        jMenu5.add(jmiViewResult);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("Student Operations");

        jmiAddStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/addd.png"))); // NOI18N
        jmiAddStudent.setText("Add New Student");
        jmiAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAddStudentActionPerformed(evt);
            }
        });
        jMenu7.add(jmiAddStudent);

        jmiViewStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminui/vieww.png"))); // NOI18N
        jmiViewStudent.setText("View Student Details");
        jmiViewStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiViewStudentActionPerformed(evt);
            }
        });
        jMenu7.add(jmiViewStudent);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAddSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddSubjectActionPerformed
        showScreen(new AddNewSubject());
    }//GEN-LAST:event_jmiAddSubjectActionPerformed

    private void jmiViewSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewSectionActionPerformed
        showScreen(new ViewSectionDetails());
    }//GEN-LAST:event_jmiViewSectionActionPerformed

    private void jmiViewTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewTestActionPerformed
        showScreen(new ViewTestDetails());
    }//GEN-LAST:event_jmiViewTestActionPerformed

    private void jmiViewSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewSubjectActionPerformed
        showScreen(new ViewSubjectDetails());
    }//GEN-LAST:event_jmiViewSubjectActionPerformed

    private void jmiAddSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddSectionActionPerformed
        showScreen(new AddNewSection());
    }//GEN-LAST:event_jmiAddSectionActionPerformed

    private void jmiAddTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddTestActionPerformed
        showScreen(new AddNewTest());
    }//GEN-LAST:event_jmiAddTestActionPerformed

    private void jmiAddQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddQuestionActionPerformed
        showScreen(new AddNewQuestion());
    }//GEN-LAST:event_jmiAddQuestionActionPerformed

    private void jmiViewQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewQuestionActionPerformed
        showScreen(new ViewQuestionDetails());
    }//GEN-LAST:event_jmiViewQuestionActionPerformed

    private void jmiViewResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewResultActionPerformed
        showScreen(new ViewResultDetails());
    }//GEN-LAST:event_jmiViewResultActionPerformed

    private void jmiAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAddStudentActionPerformed
        showScreen(new AddNewStudent());
    }//GEN-LAST:event_jmiAddStudentActionPerformed

    private void jmiViewStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiViewStudentActionPerformed
        showScreen(new ViewStudentDetails());
    }//GEN-LAST:event_jmiViewStudentActionPerformed

    private void showScreen(JInternalFrame jif) {
        jif.setVisible(true);
        deskpane.add(jif);
        try {
            jif.setSelected(true);
        } catch (PropertyVetoException ex) {
        }
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskpane;
    private adminui.DesktopPane desktopPane1;
    private adminui.DesktopPane desktopPane2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jmiAddQuestion;
    private javax.swing.JMenuItem jmiAddSection;
    private javax.swing.JMenuItem jmiAddStudent;
    private javax.swing.JMenuItem jmiAddSubject;
    private javax.swing.JMenuItem jmiAddTest;
    private javax.swing.JMenuItem jmiViewQuestion;
    private javax.swing.JMenuItem jmiViewResult;
    private javax.swing.JMenuItem jmiViewSection;
    private javax.swing.JMenuItem jmiViewStudent;
    private javax.swing.JMenuItem jmiViewSubject;
    private javax.swing.JMenuItem jmiViewTest;
    // End of variables declaration//GEN-END:variables
}
