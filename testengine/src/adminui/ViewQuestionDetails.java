/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import project.dao.QuestionInfoDAO;
import project.to.QuestionInfoTO;

/**
 *
 * @author HP
 */
public class ViewQuestionDetails extends javax.swing.JInternalFrame {

    List<QuestionInfoTO> questioninfo;
    private JPopupMenu popupmenu;
    private int row;

    public ViewQuestionDetails() {
        initComponents();
        bindTables();
        popupmenu = new JPopupMenu();
        JMenuItem deleteitem = new JMenuItem("Delete This Record");
        try {
            ImageIcon icon;
            icon = new ImageIcon(getClass().getResource("/adminui/delete.png"));
            deleteitem.setIcon(icon);
        } catch (Exception ex) {
        }
        popupmenu.add(deleteitem);
        JMenuItem edititem = new JMenuItem("Edit This Record");
        try {
            ImageIcon icon;
            icon = new ImageIcon(getClass().getResource("/adminui/update1.png"));
            edititem.setIcon(icon);
        } catch (Exception ex) {
        }
        popupmenu.add(edititem);
        deleteitem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                deleterecord();
            }
        });
        edititem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editrecord();
            }
        });
        row = -1;
    }

    public void editrecord() {
        if (row != -1 && questioninfo != null && row < questioninfo.size()) {
            AddNewQuestion anq = new AddNewQuestion(questioninfo.get(row));
            anq.setVisible(true);
            getDesktopPane().add(anq);
            try {
                anq.setSelected(true);
            } catch (PropertyVetoException ex) {
            }
            dispose();
        }
        row = -1;
    }

    public void deleterecord() {
        if (row != -1 && questioninfo != null && row < questioninfo.size()) {
            int result = JOptionPane.showConfirmDialog(this, "Are You Sure To Delete This Record?", "Message From System", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                QuestionInfoTO record = questioninfo.get(row);
                QuestionInfoDAO action = new QuestionInfoDAO();
                String message = "";
                if (action.deleteRecord(record.getTestid())) {
                    message = "Record is Removed From DataBase";
                    bindTables();
                } else {
                    if (action.getErrormessage().contains("foreign")) {
                        message = "Foreign Key Failure\n\nAttempt to Delete Primary Row ";
                    } else {
                        message = "Deletion Failure Due TO " + action.getErrormessage();
                    }
                }
                JOptionPane.showMessageDialog(this, message);
            }
        }
        row = -1;
    }

    public void bindTables() {
        questioninfo = new QuestionInfoDAO().getAllRecord();
        String colnames[] = {"Question ID", "Test ID", "Section ID", "Question Text", "Option A", "Option B", "Option C", "Option D", "Answer"};
        Object[][] records = null;
        if (questioninfo != null && questioninfo.size() > 0) {
            records = new Object[questioninfo.size()][colnames.length];
            int i = 0;
            for (QuestionInfoTO qit : questioninfo) {
                records[i] = new Object[]{qit.getQuestionid(), qit.getTestid(), qit.getSectionid(), qit.getQuestiontext(), qit.getOptiona(), qit.getOptionb(), qit.getOptionc(), qit.getOptiond(), qit.getAnswer()};
                i++;
            }
        } else {
            records = new Object[1][colnames.length];
            records[0] = new Object[]{"No Records", "No Records", "No Records", "No Records", "No Records", "No Records", "No Records", "No Records", "No Records"};
        }
        DefaultTableModel dtm = new DefaultTableModel(records, colnames);
        tableQuestion.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableQuestion = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Question Details");

        tableQuestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableQuestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableQuestionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableQuestion);

        btnLoad.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLoad.setText("Load Again");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoad, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        bindTables();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void tableQuestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableQuestionMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int rowatpoint = tableQuestion.rowAtPoint(evt.getPoint());
            tableQuestion.getSelectionModel().setSelectionInterval(rowatpoint, rowatpoint);
            popupmenu.show(tableQuestion, evt.getX(), evt.getY());
            row = tableQuestion.getSelectedRow();
        }
    }//GEN-LAST:event_tableQuestionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableQuestion;
    // End of variables declaration//GEN-END:variables
}
