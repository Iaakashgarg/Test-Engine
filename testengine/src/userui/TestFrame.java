package userui;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import project.dao.QuestionInfoDAO;
import project.dao.ResultInfoDAO;
import project.to.QuestionInfoTO;
import project.to.ResultInfoTO;

public class TestFrame extends javax.swing.JFrame implements Runnable {

    private int testid;
    private String username;
    int time;
    private int index;
    private List<QuestionInfoTO> questions;
    private List<String> answers;

    public TestFrame(int testid, String username) {
        this();
        this.testid = testid;
        this.username = username;
        QuestionInfoDAO qid = new QuestionInfoDAO();
        questions = qid.getAllRecord(testid);
        if (questions != null && questions.size() > 0) {
            index = 0;
            answers = new ArrayList<>();
            for (int i = 1; i <= questions.size(); i++) {
                answers.add("");
            }
            displayQuestion(index);
            time = 1200;
            new Thread(this).start();
        }
    }

    //Code For Timer
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            time--;
            int minute = time / 60;
            int second = time % 60;
            String message = "";
            message += (minute <= 9 ? ("0" + minute) : minute);
            message += ":";
            message += (second <= 9 ? ("0" + second) : second);
            lblTime.setText(message);
            if (time == 0) {
                break;
            }
        }
        JOptionPane.showMessageDialog(this, "Times UP!!!");
        dispose();
    }

    public TestFrame() {
        initComponents();
        setSize(getToolkit().getScreenSize());
    }

    private void displayQuestion(int i) {
        if (questions != null && i < questions.size()) {
            QuestionInfoTO ques = questions.get(i);
            int id = i + 1;
            jtaQuestion.setText(ques.getQuestiontext());
            jrbOptionA.setText(ques.getOptiona());
            jrbOptionB.setText(ques.getOptionb());
            jrbOptionC.setText(ques.getOptionc());
            jrbOptionD.setText(ques.getOptiond());
            optionGroup.clearSelection();
            jlQuestion.setText("Question No." + String.valueOf(id));
            String answer = answers.get(i);
            if (answer.equals("A")) {
                jrbOptionA.setSelected(true);
            } else if (answer.equals("B")) {
                jrbOptionB.setSelected(true);
            } else if (answer.equals("C")) {
                jrbOptionC.setSelected(true);
            } else if (answer.equals("D")) {
                jrbOptionD.setSelected(true);
            }
        }
    }

    private void processQuestion(int i) {
        if (answers != null && i < answers.size()) {
            String answer = answers.get(i);
            if (jrbOptionA.isSelected()) {
                answer = "A";
            } else if (jrbOptionB.isSelected()) {
                answer = "B";
            } else if (jrbOptionC.isSelected()) {
                answer = "C";
            } else if (jrbOptionD.isSelected()) {
                answer = "D";
            }
            answers.set(i, answer);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaQuestion = new javax.swing.JTextArea();
        jlQuestion = new javax.swing.JLabel();
        jrbOptionA = new javax.swing.JRadioButton();
        jrbOptionB = new javax.swing.JRadioButton();
        jrbOptionC = new javax.swing.JRadioButton();
        jrbOptionD = new javax.swing.JRadioButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

        jtaQuestion.setEditable(false);
        jtaQuestion.setColumns(20);
        jtaQuestion.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jtaQuestion.setRows(5);
        jScrollPane1.setViewportView(jtaQuestion);

        jlQuestion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jlQuestion.setText("Question Text");

        optionGroup.add(jrbOptionA);
        jrbOptionA.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jrbOptionA.setText("Option A");

        optionGroup.add(jrbOptionB);
        jrbOptionB.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jrbOptionB.setText("Option B");

        optionGroup.add(jrbOptionC);
        jrbOptionC.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jrbOptionC.setText("Option C");

        optionGroup.add(jrbOptionD);
        jrbOptionD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jrbOptionD.setText("Option D");

        btnPrevious.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnPrevious.setText("Previous");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnEnd.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEnd.setText("End Test");
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndActionPerformed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        lblTime.setText("00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbOptionD)
                            .addComponent(jrbOptionC)
                            .addComponent(jrbOptionB)
                            .addComponent(jrbOptionA)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(258, 258, 258)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTime)
                        .addGap(43, 43, 43)
                        .addComponent(btnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(308, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jrbOptionA)
                .addGap(29, 29, 29)
                .addComponent(jrbOptionB)
                .addGap(28, 28, 28)
                .addComponent(jrbOptionC)
                .addGap(33, 33, 33)
                .addComponent(jrbOptionD)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        if (index > 0) {
            processQuestion(index);
            index--;
            displayQuestion(index);
        } else {
            JOptionPane.showMessageDialog(this, "You are At First Question");
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (index + 1 < questions.size()) {
            processQuestion(index);
            index++;
            displayQuestion(index);
        } else {
            JOptionPane.showMessageDialog(this, "You Are At Last Question");
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndActionPerformed
        processQuestion(index);
        int result = JOptionPane.showConfirmDialog(this, "Are You Sure To Exit from Test?", "Message From Admin", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            int totalright, totalquestion, totalmarks, obtainedmarks, totalattempt;
            totalright = totalmarks = totalattempt = obtainedmarks = 0;
            totalquestion = questions.size();
            for (int i = 0; i < totalquestion; i++) {
                QuestionInfoTO ques = questions.get(i);
                String answer = answers.get(i);
                totalmarks += ques.getMarks();
                if (!answer.equals("")) {
                    totalattempt++;
                    if (answer.equals(ques.getAnswer())) {
                        totalright++;
                        obtainedmarks += ques.getMarks();
                    }
                }
            }

            ResultInfoDAO rid = new ResultInfoDAO();
            ResultInfoTO results = new ResultInfoTO();
            results.setTestid(testid);
            results.setUsername(username);
            results.setTotalquestion(totalquestion);
            results.setTotalattempt(totalattempt);
            results.setTotalright(totalright);
            results.setTotalmarks(obtainedmarks);
            rid.insertRecord(results);

            String message = " Total Question : " + totalquestion + "\n\n";
            message += " Total Marks : " + totalmarks + "\n\n";
            message += " Total Attempt : " + totalattempt + "\n\n";
            message += " Total Right : " + totalright + "\n\n";
            message += " Obtained Marks : " + obtainedmarks + "\n\n";
            JOptionPane.showMessageDialog(this, "ThankYou!!!\nYour Response Has Been Saved");
            dispose();
        }
    }//GEN-LAST:event_btnEndActionPerformed

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
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlQuestion;
    private javax.swing.JRadioButton jrbOptionA;
    private javax.swing.JRadioButton jrbOptionB;
    private javax.swing.JRadioButton jrbOptionC;
    private javax.swing.JRadioButton jrbOptionD;
    private javax.swing.JTextArea jtaQuestion;
    private javax.swing.JLabel lblTime;
    private javax.swing.ButtonGroup optionGroup;
    // End of variables declaration//GEN-END:variables
}
