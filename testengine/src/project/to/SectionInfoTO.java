package project.to;


public class SectionInfoTO {
    private int sectionid;
    private String sectionname;
    private String subjectid;
    private int marks;

    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionid) {
        this.sectionid = sectionid;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    public String toString(){
        return String.valueOf(sectionid) + "[" + sectionname + "]" ;
    }
    
}
