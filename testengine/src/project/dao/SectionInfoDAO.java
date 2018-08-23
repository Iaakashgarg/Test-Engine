package project.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import project.to.SectionInfoTO;
import project.to.TestInfoTO;
import utility.ErrorHandling;

public class SectionInfoDAO {

    private String errormessage;

    public String getErrormessage() {
        return errormessage;
    }

    public boolean insertRecord(SectionInfoTO record) {
        try {
            String query = "insert into sectioninfo ";
            query += " (sectionname,subjectid,marks) ";
            query += " values(?,?,?)";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setString(1, record.getSectionname());
            stmt.setString(2, record.getSubjectid());
            stmt.setInt(3, record.getMarks());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean updateRecord(SectionInfoTO record) {
        try {
            String query = "update sectioninfo ";
            query += " set sectionname=?,subjectid=?,marks=? ";
            query += " where sectionid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setString(1, record.getSectionname());
            stmt.setString(2, record.getSubjectid());
            stmt.setInt(3, record.getMarks());
            stmt.setInt(4, record.getSectionid());
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public boolean deleteRecord(int sectionid) {
        try {
            String query = "delete from sectioninfo ";
            query += " where sectionid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, sectionid);
            boolean result = stmt.executeUpdate() > 0;
            stmt.close();
            return result;
        } catch (Exception ex) {
            errormessage = ex.toString();
            ErrorHandling.displayStackTrace(ex);
            return false;
        }
    }

    public SectionInfoTO getRecord(int sectionid) {
        try {
            String query = "select sectionid,sectionname,subjectid,marks ";
            query += " from sectioninfo ";
            query += " where sectionid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            stmt.setInt(1, sectionid);
            SectionInfoTO result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new SectionInfoTO();
                result.setSectionid(rs.getInt("sectionid"));
                result.setSectionname(rs.getString("sectionname"));
                result.setSubjectid(rs.getString("subjectid"));
                result.setMarks(rs.getInt("marks"));
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

    public List<SectionInfoTO> getAllRecord() {
        try {
            String query = "select sectionid,sectionname,subjectid,marks ";
            query += " from sectioninfo ";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            List<SectionInfoTO> result = null;
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    SectionInfoTO st = new SectionInfoTO();
                    st.setSectionid(rs.getInt("sectionid"));
                    st.setSectionname(rs.getString("sectionname"));
                    st.setSubjectid(rs.getString("subjectid"));
                    st.setMarks(rs.getInt("marks"));
                    result.add(st);
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
    public List<SectionInfoTO> getAllRecord(String subjectid) {
        try {
            String query = "select sectionid,sectionname,subjectid,marks ";
            query += " from sectioninfo ";
            query += " where subjectid = ?";
            PreparedStatement stmt = project.dao.DataConnection.getStatement(query);
            List<SectionInfoTO> result = null;
            stmt.setString(1,subjectid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new ArrayList<>();
                do {
                    SectionInfoTO st = new SectionInfoTO();
                    st.setSectionid(rs.getInt("sectionid"));
                    st.setSectionname(rs.getString("sectionname"));
                    st.setSubjectid(rs.getString("subjectid"));
                    st.setMarks(rs.getInt("marks"));
                    result.add(st);
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
