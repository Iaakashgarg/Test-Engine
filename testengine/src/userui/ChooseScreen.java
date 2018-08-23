package userui;

import java.util.List;
import javax.swing.JOptionPane;
import project.dao.SubjectInfoDAO;
import project.dao.TestInfoDAO;
import project.to.SubjectInfoTO;
import project.to.TestInfoTO;

public class ChooseScreen extends javax.swing.JInternalFrame {

    private String username;

    public ChooseScreen(String username) {
        this();
        this.username = username;
    }

    private int testid;

    public ChooseScreen(int testid) {
        this();
        this.testid = testid;
    }

    public ChooseScreen() {
        initComponents();
        jcbSubjectID.removeAllItems();
        jcbTestID.removeAllItems();
        jcbSubjectID.addItem("Choose Any Subject ID");

        List<SubjectInfoTO> subjectid = new SubjectInfoDAO().getAllRecord();
        if (subjectid != null && subjectid.size() > 0) {
            for (SubjectInfoTO sit : subjectid) {
                jcbSubjectID.addItem(sit);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jcbTestID = new javax.swing.JComboBox();
        jcbSubjectID = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Choose Test Details");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Choose Subject ID:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Choose Test ID:");

        btnStart.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnStart.setText("Start Test");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jcbTestID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jcbSubjectID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jcbSubjectID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbSubjectIDItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 102, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcbSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbTestID, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTestID, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        String message = "";
        boolean allvalid = true;
        if (jcbSubjectID.getSelectedIndex() == 0) {
            allvalid = false;
            message += "Please Choose Any Subject ID\n\n";
        }
        if (jcbTestID.getSelectedIndex() == 0) {
            allvalid = false;
            message += "Please Choose Any Test ID\n\n";
        }

        if (allvalid) {
            TestInfoTO tit = (TestInfoTO) jcbTestID.getSelectedItem();
            TestFrame tf = new TestFrame(tit.getTestid(), username);
            tf.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, message);
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void jcbSubjectIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbSubjectIDItemStateChanged
        jcbTestID.removeAllItems();
        jcbTestID.addItem("Choose Any Test ID");
        if (jcbSubjectID.getSelectedIndex() > 0) {
            SubjectInfoTO sit = (SubjectInfoTO) jcbSubjectID.getSelectedItem();
            List<TestInfoTO> testid = new TestInfoDAO().getAllRecord(sit.getSubjectid());
            if (testid != null && testid.size() > 0) {
                for (TestInfoTO tit : testid) {
                    jcbTestID.addItem(tit);
                }
            }
        }
    }//GEN-LAST:event_jcbSubjectIDItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox jcbSubjectID;
    private javax.swing.JComboBox jcbTestID;
    // End of variables declaration//GEN-END:variables
}
