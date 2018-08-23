package project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.to.ResultInfoTO;
import utility.ErrorHandling;

public class ResultInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(ResultInfoTO record) {
        try {
            String query = "insert into resultinfo ";
            query += " (testid,username,totalquestion,totalattempt,totalright,totalmarks,resultdate) ";
            query += " values(?,?,?,?,?,?,sysdate())";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, record.getTestid());
            stmt.setString(2, record.getUsername());
            stmt.setInt(3, record.getTotalquestion());
            stmt.setInt(4, record.getTotalattempt());
            stmt.setInt(5, record.getTotalright());
            stmt.setInt(6, record.getTotalmarks());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(ResultInfoTO record) {
        try {
            String query = "update resultinfo ";
            query += " set testid=?,username=?,totalquestion=?,totalattempt=?,totalright=?,totalmarks=?,resultdate=? ";
            query += " where resultid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, record.getTestid());
            stmt.setString(2, record.getUsername());
            stmt.setInt(3, record.getTotalquestion());
            stmt.setInt(4, record.getTotalattempt());
            stmt.setInt(5, record.getTotalright());
            stmt.setInt(6, record.getTotalmarks());
            stmt.setTimestamp(7, record.getResultdate());
            stmt.setInt(8, record.getResultid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int resultid) {
        try {
            String query = "delete from resultinfo ";
            query += " where resultid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, resultid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public ResultInfoTO getRecord(int resultid) {
        try {
            String query = "select resultid,testid,username,totalquestion,totalattempt,totalright,totalmarks,resultdate ";
            query += " from resultinfo ";
            query += " where resultid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, resultid);
            ResultInfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ResultInfoTO();
                result.setResultid(rs.getInt("resultid"));
                result.setTestid(rs.getInt("testid"));
                result.setUsername(rs.getString("username"));
                result.setTotalquestion(rs.getInt("totalquestion"));
                result.setTotalattempt(rs.getInt("totalattempt"));
                result.setTotalright(rs.getInt("totalright"));
                result.setTotalmarks(rs.getInt("totalmarks"));
                result.setResultdate(rs.getTimestamp("resultdate"));
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

    public List<ResultInfoTO> getAllRecord() {
        try {
            String query = "select resultid,testid,username,totalquestion,totalattempt,totalright,totalmarks,resultdate ";
            query += " from resultinfo ";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            List<ResultInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ResultInfoTO rit = new ResultInfoTO();
                    rit.setResultid(rs.getInt("resultid"));
                    rit.setTestid(rs.getInt("testid"));
                    rit.setUsername(rs.getString("username"));
                    rit.setTotalquestion(rs.getInt("totalquestion"));
                    rit.setTotalattempt(rs.getInt("totalattempt"));
                    rit.setTotalright(rs.getInt("totalright"));
                    rit.setTotalmarks(rs.getInt("totalmarks"));
                    rit.setResultdate(rs.getTimestamp("resultdate"));
                    result.add(rit);
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

    public List<ResultInfoTO> getAllRecord(String username) {
        try {
            String query = "select resultid,testid,username,totalquestion,totalattempt,totalright,totalmarks,resultdate ";
            query += " from resultinfo ";
            query += " where username = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setString(1, username);
            List<ResultInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    ResultInfoTO rit = new ResultInfoTO();
                    rit.setResultid(rs.getInt("resultid"));
                    rit.setTestid(rs.getInt("testid"));
                    rit.setUsername(rs.getString("username"));
                    rit.setTotalquestion(rs.getInt("totalquestion"));
                    rit.setTotalattempt(rs.getInt("totalattempt"));
                    rit.setTotalright(rs.getInt("totalright"));
                    rit.setTotalmarks(rs.getInt("totalmarks"));
                    rit.setResultdate(rs.getTimestamp("resultdate"));
                    result.add(rit);
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
