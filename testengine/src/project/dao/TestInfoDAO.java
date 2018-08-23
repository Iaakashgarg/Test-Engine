package project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.to.SubjectInfoTO;
import project.to.SectionInfoTO;
import project.to.TestInfoTO;
import utility.ErrorHandling;

public class TestInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(TestInfoTO record) {
        try {
            String query = "insert into testinfo ";
            query += " (testname,subjectid,description,totalquestion,testlevel) ";
            query += " values(?,?,?,?,?)";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setString(1, record.getTestname());
            stmt.setString(2, record.getSubjectid());
            stmt.setString(3, record.getDescription());
            stmt.setInt(4, record.getTotalquestion());
            stmt.setString(5, record.getTestlevel());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(TestInfoTO record) {
        try {
            String query = "update testinfo ";
            query += " set testname=?,subjectid=?,description=?,totalquestion=?,testlevel=? ";
            query += " where testid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setString(1, record.getTestname());
            stmt.setString(2, record.getSubjectid());
            stmt.setString(3, record.getDescription());
            stmt.setInt(4, record.getTotalquestion());
            stmt.setString(5, record.getTestlevel());
            stmt.setInt(6, record.getTestid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int testid) {
        try {
            String query = "delete from testinfo ";
            query += " where testid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, testid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public TestInfoTO getRecord(int testid) {
        try {
            String query = "select testid,testname,subjectid,description,totalquestion,testlevel ";
            query += " from testinfo ";
            query += " where testid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, testid);
            TestInfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new TestInfoTO();
                result.setTestid(rs.getInt("testid"));
                result.setTestname(rs.getString("testname"));
                result.setSubjectid(rs.getString("subjectid"));
                result.setDescription(rs.getString("description"));
                result.setTotalquestion(rs.getInt("totalquestion"));
                result.setTestlevel(rs.getString("testlevel"));
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

    public List<TestInfoTO> getAllRecord() {
        try {
            String query = "select testid,testname,subjectid,description,totalquestion,testlevel ";
            query += " from testinfo ";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            List<TestInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TestInfoTO tit = new TestInfoTO();
                    tit.setTestid(rs.getInt("testid"));
                    tit.setTestname(rs.getString("testname"));
                    tit.setSubjectid(rs.getString("subjectid"));
                    tit.setDescription(rs.getString("description"));
                    tit.setTotalquestion(rs.getInt("totalquestion"));
                    tit.setTestlevel(rs.getString("testlevel"));
                    result.add(tit);
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

    public List<TestInfoTO> getAllRecord(String subjectid) {
        try {
            String query = "select testid,testname,subjectid,description,totalquestion,testlevel ";
            query += " from testinfo ";
            query += " where subjectid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setString(1, subjectid);
            List<TestInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TestInfoTO tit = new TestInfoTO();
                    tit.setTestid(rs.getInt("testid"));
                    tit.setTestname(rs.getString("testname"));
                    tit.setSubjectid(rs.getString("subjectid"));
                    tit.setDescription(rs.getString("description"));
                    tit.setTotalquestion(rs.getInt("totalquestion"));
                    tit.setTestlevel(rs.getString("testlevel"));
                    result.add(tit);
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

    public List<TestInfoTO> getAllRecord(int sectionid) {
        try {
            String query = "select testid,testname,subjectid,description,totalquestion,testlevel ";
            query += " from testinfo ";
            query += " where sectionid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, sectionid);
            List<TestInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    TestInfoTO tit = new TestInfoTO();
                    tit.setTestid(rs.getInt("testid"));
                    tit.setTestname(rs.getString("testname"));
                    tit.setSubjectid(rs.getString("subjectid"));
                    tit.setDescription(rs.getString("description"));
                    tit.setTotalquestion(rs.getInt("totalquestion"));
                    tit.setTestlevel(rs.getString("testlevel"));
                    result.add(tit);
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
