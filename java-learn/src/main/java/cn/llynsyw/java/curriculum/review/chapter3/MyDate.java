package cn.llynsyw.java.curriculum.review.chapter3;

public class MyDate {
    private int year, month, day;//������
    private static int thisYear;

    static {
        thisYear = 2019;
    }

    public MyDate(int year, int moth, int day) {
        this.set(year, month, day);
    }

    public MyDate() {
        this(1970, 1, 1);
    }

    public MyDate(MyDate date){
        this.set(date);
    }

    public void set(int year, int month, int day) {
        this.year = year;
        this.month = (month >= 1 && month <= 12) ? month : 1;
        this.day = (day >= 1 && day <= 31) ? day : 1;
    }

    public void set(MyDate date) {
        this.set(date.year, date.month, date.day);
    }


    public int getYear() {
        return year;
    }

    public int getMoth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public static int getThisYear() {
        return thisYear;
    }

    public String toString() {
        return year + "��" + String.format("%02d", month) + "��" + String.format("%02d", day) + "��";
    }

    public boolean equals(MyDate date) {
        return this == date || date != null && this.year == date.year && this.month == date.month && this.day == date.day;
    }
}
