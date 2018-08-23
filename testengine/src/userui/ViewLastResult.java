package userui;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import project.dao.ResultInfoDAO;
import project.to.ResultInfoTO;

public class ViewLastResult extends javax.swing.JInternalFrame {

    private String username;
    List<ResultInfoTO> results;

    public ViewLastResult(String username) {
        this();
        this.username = username;
        bindTables(username);
    }

    public ViewLastResult() {
        initComponents();
    }

    public void bindTables(String value) {
        results = new ResultInfoDAO().getAllRecord(value);
        String[] colnames = {"Test ID", "UserName", "Total Question", "Total Attempt", "Total Right", "Total Marks", "Result Date"};
        Object[][] records = null;
        if (results != null && results.size() > 0) {
            records = new Object[results.size()][colnames.length];
            int i = 0;
            for (ResultInfoTO rit : results) {
                records[i] = new Object[]{rit.getTestid(), rit.getUsername(), rit.getTotalquestion(), rit.getTotalattempt(), rit.getTotalright(), rit.getTotalmarks(), rit.getResultdate()};
                i++;
            }
        } else {
            records = new Object[1][colnames.length];
            records[0] = new Object[]{"No Record", "No Record", "No Record", "No Record", "No Record", "No Record", "No Record"};
        }
        DefaultTableModel dtm = new DefaultTableModel(records, colnames);
        tableResult.setModel(dtm);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableResult = new javax.swing.JTable();
        btnLoad = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Last Result Details");

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableResult);

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
                .addGap(175, 175, 175)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        bindTables(username);
    }//GEN-LAST:event_btnLoadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableResult;
    // End of variables declaration//GEN-END:variables
}
