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
import project.dao.SubjectInfoDAO;
import project.dao.TestInfoDAO;
import project.to.SubjectInfoTO;
import project.to.TestInfoTO;

/**
 *
 * @author HP
 */
public class ViewTestDetails extends javax.swing.JInternalFrame {

    List<TestInfoTO> testinfo;
    private JPopupMenu popupmenu;
    private int row;

    public ViewTestDetails() {
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
        if (row != -1 && testinfo != null && row < testinfo.size()) {
            AddNewTest ant = new AddNewTest(testinfo.get(row));
            ant.setVisible(true);
            getDesktopPane().add(ant);
            try {
                ant.setSelected(true);
            } catch (PropertyVetoException ex) {
            }
            dispose();
        }
        row = -1;
    }

    public void deleterecord() {
        if (row != -1 && testinfo != null && row < testinfo.size()) {
            int result = JOptionPane.showConfirmDialog(this, "Are You Sure To Delete This Record?", "Message From System", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                TestInfoTO record = testinfo.get(row);
                TestInfoDAO action = new TestInfoDAO();
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
        testinfo = new TestInfoDAO().getAllRecord();
        String colnames[] = {"Test ID", "Test Name", "Subject ID", "Description", "TotalQuestion", "TestLevel"};
        Object[][] records = null;
        if (testinfo != null && testinfo.size() > 0) {
            records = new Object[testinfo.size()][colnames.length];
            int i = 0;
            for (TestInfoTO tit : testinfo) {
                records[i] = new Object[]{tit.getTestid(), tit.getTestname(), tit.getSubjectid(), tit.getDescription(), tit.getTotalquestion(), tit.getTestlevel()};
                i++;
            }
        } else {
            records = new Object[1][colnames.length];
            records[0] = new Object[]{"No Records", "No Records", "No Records", "No Records", "No Records", "No Records"};
        }
        DefaultTableModel dtm = new DefaultTableModel(records, colnames);
        tableTest.setModel(dtm);
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
        tableTest = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("View Test Details");

        tableTest.setModel(new javax.swing.table.DefaultTableModel(
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
        tableTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTestMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTest);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Load Again");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        bindTables();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableTestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTestMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            int rowatpoint = tableTest.rowAtPoint(evt.getPoint());
            tableTest.getSelectionModel().setSelectionInterval(rowatpoint, rowatpoint);
            popupmenu.show(tableTest, evt.getX(), evt.getY());
            row = tableTest.getSelectedRow();
        }
    }//GEN-LAST:event_tableTestMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableTest;
    // End of variables declaration//GEN-END:variables
}