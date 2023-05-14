package cn.llynsyw.design.pattern.exp.composition;

public class CompositionClient {
    public static void main(String[] args) {

        Component member1 = new Member("m1", "this is a good day");
        Component member2 = new Member("m2", "视屏：这是一条视屏");
        Component member3 = new Member("m3", "连接：https://baidu.com");
        Component member4 = new Member("m4");
        Component member5 = new Member("m5");
        Component member6 = new Member("m6");


        Component group1 = new Group("帅比群1");
        Component group2 = new Group("帅比群2");
        Component group3 = new Group("正常群");

        group1.add(member1);
        group1.add(member2);
        group1.add(member4);
        group1.add(member5);

        group2.add(member2);
        group2.add(member3);

        group3.add(group1);
        group3.add(group2);
        group3.add(member1);
        group3.add(member2);
        group3.add(member3);
        group3.add(member6);


        member1.share(group3);
    }
}
