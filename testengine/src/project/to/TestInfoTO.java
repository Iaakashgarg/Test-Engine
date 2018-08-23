package project.to;

public class TestInfoTO {
    private int testid;
    private String testname;
    private String subjectid;
    private String description;
    private int totalquestion;
    private String testlevel;

    public int getTestid() {
        return testid;
    }

    public void setTestid(int testid) {
        this.testid = testid;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalquestion() {
        return totalquestion;
    }

    public void setTotalquestion(int totalquestion) {
        this.totalquestion = totalquestion;
    }

    public String getTestlevel() {
        return testlevel;
    }

    public void setTestlevel(String testlevel) {
        this.testlevel = testlevel;
    }
    public String toString(){
        return String.valueOf(testid) + "[" + testname + "]" ;
    }
    
    
}
