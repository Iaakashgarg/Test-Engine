package project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.to.QuestionInfoTO;
import project.to.TestInfoTO;
import utility.ErrorHandling;

public class QuestionInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(QuestionInfoTO record) {
        try {
            String query = "insert into questioninfo ";
            query += " (testid,sectionid,questiontext,optiona,optionb,optionc,optiond,answer) ";
            query += " values(?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, record.getTestid());
            stmt.setInt(2, record.getSectionid());
            stmt.setString(3, record.getQuestiontext());
            stmt.setString(4, record.getOptiona());
            stmt.setString(5, record.getOptionb());
            stmt.setString(6, record.getOptionc());
            stmt.setString(7, record.getOptiond());
            stmt.setString(8, record.getAnswer());
         
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(QuestionInfoTO record) {
        try {
            String query = "update questioninfo ";
            query += " set testid=?,sectionid=?,questiontext=?,optiona=?,optionb=?,optionc=?,optiond=?,answer=? ";
            query += " where questionid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, record.getTestid());
            stmt.setInt(2, record.getSectionid());
            stmt.setString(3, record.getQuestiontext());
            stmt.setString(4, record.getOptiona());
            stmt.setString(5, record.getOptionb());
            stmt.setString(6, record.getOptionc());
            stmt.setString(7, record.getOptiond());
            stmt.setString(8, record.getAnswer());
       //     stmt.setString(9, record.getSubjectid());
            stmt.setInt(9, record.getQuestionid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int questionid) {
        try {
            String query = "delete from questioninfo ";
            query += " where questionid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, questionid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public QuestionInfoTO getRecord(int questionid) {
        try {
            String query = "select questionid,testid,sectionid,questiontext,optiona,optionb,optionc,optiond,answer ";
            query += " from questioninfo ";
            query += " where questionid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, questionid);
            QuestionInfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new QuestionInfoTO();
                result.setQuestionid(rs.getInt("questionid"));
                result.setTestid(rs.getInt("testid"));
                result.setSectionid(rs.getInt("sectionid"));
                result.setQuestiontext(rs.getString("questiontext"));
                result.setOptiona(rs.getString("optiona"));
                result.setOptionb(rs.getString("optionb"));
                result.setOptionc(rs.getString("optionc"));
                result.setOptiond(rs.getString("optiond"));
                result.setAnswer(rs.getString("answer"));
         //       result.setSubjectid(rs.getString("subjectid"));
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }

    public List<QuestionInfoTO> getAllRecord() {
        try {
            String query = "select questionid,testid,qi.sectionid,si.marks,\n"
                    + "questiontext,optiona,optionb,optionc,optiond,\n"
                    + "answer from questioninfo qi join sectioninfo si\n"
                    + "on qi.sectionid = si.sectionid";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            List<QuestionInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    QuestionInfoTO qit = new QuestionInfoTO();
                    qit.setQuestionid(rs.getInt("questionid"));
                    qit.setTestid(rs.getInt("testid"));
                    qit.setSectionid(rs.getInt("sectionid"));
                    qit.setQuestiontext(rs.getString("questiontext"));
                    qit.setOptiona(rs.getString("optiona"));
                    qit.setOptionb(rs.getString("optionb"));
                    qit.setOptionc(rs.getString("optionc"));
                    qit.setOptiond(rs.getString("optiond"));
                    qit.setAnswer(rs.getString("answer"));
             //       qit.setSubjectid(rs.getString("subjectid"));
                    qit.setMarks(rs.getInt("marks"));
                    result.add(qit);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }

    public List<QuestionInfoTO> getAllRecord(int testid) {
        try {
            String query = "select questionid,testid,qi.sectionid,si.marks,\n"
                    + "questiontext,optiona,optionb,optionc,optiond,\n"
                    + "answer from questioninfo qi join sectioninfo si\n"
                    + "on qi.sectionid = si.sectionid"
                    + " where testid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, testid);
            List<QuestionInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    QuestionInfoTO qit = new QuestionInfoTO();
                    qit.setQuestionid(rs.getInt("questionid"));
                    qit.setTestid(rs.getInt("testid"));
                    qit.setSectionid(rs.getInt("sectionid"));
                    qit.setQuestiontext(rs.getString("questiontext"));
                    qit.setOptiona(rs.getString("optiona"));
                    qit.setOptionb(rs.getString("optionb"));
                    qit.setOptionc(rs.getString("optionc"));
                    qit.setOptiond(rs.getString("optiond"));
                    qit.setAnswer(rs.getString("answer"));
                 //   qit.setSubjectid(rs.getString("subjectid"));
                    qit.setMarks(rs.getInt("marks"));
                    result.add(qit);
                } while (rs.next());
            }
            rs.close();
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    }
}
