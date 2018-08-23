package adminui;

import java.util.List;
import javax.swing.JOptionPane;
import operations.Validations;
import project.dao.SectionInfoDAO;
import project.dao.SubjectInfoDAO;
import project.to.SectionInfoTO;
import project.to.SubjectInfoTO;
import utility.CommonOperations;

public class AddNewSection extends javax.swing.JInternalFrame {

    private int sectionid;

    public AddNewSection() {
        initComponents();
        jcbSubjectID.removeAllItems();
        jcbSubjectID.addItem("Choose Any Subject ID");
        List<SubjectInfoTO> subjectid = new SubjectInfoDAO().getAllRecord();
        if (subjectid != null && subjectid.size() > 0) {
            for (SubjectInfoTO sit : subjectid) {
                jcbSubjectID.addItem(sit);
            }
        }
    }

    public AddNewSection(int sectionid) {
        this();
        SectionInfoTO record = new SectionInfoDAO().getRecord(sectionid);
        if (record != null) {
            this.sectionid = sectionid;
            setTitle("Update Section Details");
            btnAddSection.setText("Update Section Details");
            jtfSectionName.setText(record.getSectionname());
            for (int i = 1; i < jcbSubjectID.getItemCount(); i++) {
                SubjectInfoTO sit = (SubjectInfoTO) jcbSubjectID.getItemAt(i);
                if (sit.getSubjectid().equals(record.getSubjectid())) {
                    jcbSubjectID.setSelectedIndex(i);
                    break;
                }
            }
            jtfMarks.setText(String.valueOf(record.getMarks()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfMarks = new javax.swing.JTextField();
        jtfSectionName = new javax.swing.JTextField();
        btnAddSection = new javax.swing.JButton();
        jcbSubjectID = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add New Secton Details");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Choose Subject ID:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Enter Section Name:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Enter Marks/Question:");

        jtfMarks.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jtfSectionName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnAddSection.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnAddSection.setText("Add New Section");
        btnAddSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSectionActionPerformed(evt);
            }
        });

        jcbSubjectID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSectionName, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnAddSection, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfSectionName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbSubjectID, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnAddSection, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSectionActionPerformed
        String message = "";
        boolean allvalid = true;
        String sectionname = jtfSectionName.getText().trim();
        String mark = jtfMarks.getText().trim();

        if (Validations.isEmpty(sectionname)) {
            allvalid = false;
            message += "Please Fill Any Value in Section Name Box\n\n";
        } else if (!Validations.onlyCharacter(sectionname)) {
            allvalid = false;
            message += "Please Enter Character Value in Section Name Box\n\n";
        }
        if (jcbSubjectID.getSelectedIndex() == 0) {
            allvalid = false;
            message += "Please Choose Any Subject ID\n\n";
        }
        if (Validations.isEmpty(mark)) {
            allvalid = false;
            message += "Please Fill Any Value in Marks Box\n\n";
        } else if (!Validations.isNumeric(mark)) {
            allvalid = false;
            message += "Please Enter Numeric Value in Marks Box\n\n";
        }

        if (allvalid) {
            SectionInfoTO record = new SectionInfoTO();
            SubjectInfoTO sit = (SubjectInfoTO) jcbSubjectID.getSelectedItem();
            record.setSectionid(record.getSectionid());
            record.setSectionname(sectionname);
            record.setSubjectid(sit.getSubjectid());
            record.setMarks(Integer.parseInt(mark));
            SectionInfoDAO action = new SectionInfoDAO();
            if (btnAddSection.getText().contains("Add")) {
                if (action.insertRecord(record)) {
                    message = "New Section is Added in System";
                } else {
                    if (action.getErrormessage().contains("key")) {
                        message = "Primary Key Failure\n\nAttempt for Duplicate Entry ";
                    } else {
                        message = "Insertion Failure Due TO " + action.getErrormessage();
                    }
                }
    }//GEN-LAST:event_btnAddSectionActionPerformed
  else if (btnAddSection.getText().contains("Update")) {
                record.setSectionid(sectionid);
                if (action.updateRecord(record)) {
                    message = "Section Record is Updated in System";
                } else {
                    if (action.getErrormessage().contains("Cannot delete or update a parent row")) {
                        message = "Foreign Key Failure\n\nAttempt to Update Primary Row ";
                    } else {
                        message = "Updation Failure Due TO " + action.getErrormessage();
                    }
                }
                CommonOperations.showScreen(getDesktopPane(), new ViewSectionDetails());
                dispose();
            } else {
                message = "Not Proper Operations";
            }
        }

        JOptionPane.showMessageDialog(this, message);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox jcbSubjectID;
    private javax.swing.JTextField jtfMarks;
    private javax.swing.JTextField jtfSectionName;
    // End of variables declaration//GEN-END:variables
}
