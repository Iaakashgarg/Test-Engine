package project.to;

import java.sql.Timestamp;

public class ResultInfoTO {

    private int resultid;
    private int testid;
    private String username;
    private int totalquestion;
    private int totalattempt;
    private int totalright;
    private int totalmarks;
    private Timestamp resultdate;

    public int getResultid() {
        return resultid;
    }

    public void setResultid(int resultid) {
        this.resultid = resultid;
    }

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalquestion() {
        return totalquestion;
    }

    public void setTotalquestion(int totalquestion) {
        this.totalquestion = totalquestion;
    }

    public int getTotalattempt() {
        return totalattempt;
    }

    public void setTotalattempt(int totalattempt) {
        this.totalattempt = totalattempt;
    }

    public int getTotalright() {
        return totalright;
    }

    public void setTotalright(int totalright) {
        this.totalright = totalright;
    }

    public int getTotalmarks() {
        return totalmarks;
    }

    public void setTotalmarks(int totalmarks) {
        this.totalmarks = totalmarks;
    }

    public Timestamp getResultdate() {
        return resultdate;
    }

    public void setResultdate(Timestamp resultdate) {
        this.resultdate = resultdate;
    }

}
