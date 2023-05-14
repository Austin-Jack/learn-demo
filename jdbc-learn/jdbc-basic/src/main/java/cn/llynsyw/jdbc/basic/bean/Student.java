package cn.llynsyw.jdbc.basic.bean;

/**
 * @ClassName Student
 * @Description
 * @package jdbc_bean
 * @Author luolinyuan
 * @Date 2021/8/16
 **/
public class Student {
    private int flowID;     //流水号
    private int type;       //考试类型
    private String IDCard;  //身份证
    private String examCard; //考号
    private String name;    //姓名
    private String location;  //城市
    private int grade;  //成绩

    public Student() {
    }

    public Student(int type, String IDCard, String examCard, String name, String location, int grade) {
        this.type = type;
        this.IDCard = IDCard;
        this.examCard = examCard;
        this.name = name;
        this.location = location;
        this.grade = grade;
    }

    public int getFlowID() {
        return flowID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getExamCard() {
        return examCard;
    }

    public void setExamCard(String examCard) {
        this.examCard = examCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "flowID=" + flowID +
                ", type=" + type +
                ", IDCard='" + IDCard + '\'' +
                ", examCard='" + examCard + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", grade=" + grade +
                '}';
    }
}
