package cn.llynsyw.jdbc.basic.demo04;


import cn.llynsyw.jdbc.basic.bean.Student;
import cn.llynsyw.jdbc.basic.util.JDBCUtils;
import org.junit.Test;

import java.util.Scanner;

/**
 * @ClassName Exercise2
 * @Description
 * @package jdbc_exercise
 * @Author luolinyuan
 * @Date 2021/8/16
 **/
public class Exercise2 {
    //问题一，向examstudent表中调价一条数据
    @Test
    public void testInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("四级/六级：");
        int type = scanner.nextInt();
        System.out.printf("身份证号：");
        String IDCard = scanner.next();
        System.out.printf("准考证号：");
        String examCard = scanner.next();
        System.out.printf("学生姓名：");
        String studentName = scanner.next();
        System.out.printf("所在城市：");
        String location = scanner.next();
        System.out.printf("考试成绩");
        int grade = scanner.nextInt();

        String sql = "insert into examstudent(type,IDCard,examCard,studentName,location,grade) values(?,?,?,?,?,?)";
        int insertCount = JDBCUtils.update(sql, type, IDCard, examCard, studentName, location, grade);
        if (insertCount > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败！");
        }

    }

    @Test
    public void queryWithIDCardOrExamCard() {
        System.out.println("请输入需要查询的类型:");
        System.out.printf("a.准考证号\t");
        System.out.printf("b.身份证号\n");
        Scanner scanner = new Scanner(System.in);
        String selection = scanner.next();
        if ("a".equalsIgnoreCase(selection)) {
            System.out.printf("请输入准考证号：");
            String examCard = scanner.next();
            String sql = "select flowID,type,IDCard,examCard,StudentName name,location,grade from examStudent  where examCard=?";
            Student student = JDBCUtils.getInstance(Student.class, sql, examCard);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("不存在此准考证号");
            }
        } else if ("b".equalsIgnoreCase(selection)) {
            System.out.printf("请输入身份证号：");
            String IDCard = scanner.next();
            String sql = "select flowID,type,IDCard,examCard,StudentName name,location,grade from examStudent  where IDCard=?";
            Student student =JDBCUtils.getInstance(Student.class, sql, IDCard);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("不存在此准考证号");
            }
        } else {
            System.out.println("输入有误！");
        }

    }

    @Test
    public void testDeleteByExamCard() {
        System.out.printf("请输入学生考号：");
        Scanner scanner = new Scanner(System.in);
        String examCard = scanner.next();
        String sql = "delete from examstudent where examCard =?";
        int deleteCount =JDBCUtils.update(sql, examCard);
        if (deleteCount >0) {
            System.out.println("删除成功！");
        } else {
            System.out.println("查无此人！");
        }
    }


}
