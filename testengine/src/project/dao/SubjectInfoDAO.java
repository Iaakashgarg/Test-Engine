package project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.to.SubjectInfoTO;
import utility.ErrorHandling;


public class SubjectInfoDAO {
   private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(SubjectInfoTO record) {
        try {
            String query = "insert into subjectinfo ";
            query += " (subjectid,subjectname,description) ";
            query += " values(?,?,?)";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setString(1, record.getSubjectid());
            stmt.setString(2, record.getSubjectname());
            stmt.setString(3, record.getDescription());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(SubjectInfoTO record) {
        try {
            String query = "update subjectinfo ";
            query += " set subjectname=?,description=? ";
            query += " where subjectid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setString(1, record.getSubjectname());
            stmt.setString(2, record.getDescription());
            stmt.setString(3, record.getSubjectid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(String subjectid) {
        try {
            String query = "delete from subjectinfo ";
            query += " where subjectid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setString(1, subjectid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }
    public SubjectInfoTO getRecord(String subjectid){
        try{
            String query = "select subjectid,subjectname,description ";
            query += " from subjectinfo ";
            query += " where subjectid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setString(1,subjectid);
            SubjectInfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = new SubjectInfoTO();
                result.setSubjectid(rs.getString("subjectid"));
                result.setSubjectname(rs.getString("subjectname"));
                result.setDescription(rs.getString("description"));
            }
            rs.close();
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    } 
    
    public List<SubjectInfoTO> getAllRecord(){
        try{
            String query = "select subjectid,subjectname,description ";
            query += " from subjectinfo ";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            List<SubjectInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                result = new ArrayList<>();
                do{
                    SubjectInfoTO sit = new SubjectInfoTO();
                sit.setSubjectid(rs.getString("subjectid"));
                sit.setSubjectname(rs.getString("subjectname"));
                sit.setDescription(rs.getString("description"));
                result.add(sit);
                }while(rs.next());
            }
            rs.close();
            stmt.close();
            return result;
        }catch(Exception ex){
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return null;
        }
    } 
}
