package cn.llynsyw.java.basic.summary.demo07;

public class DeathLock {
    public static void main(String[] args) {
        Makeup m1 = new Makeup(Makeup.LIPSTICK, "灰姑凉--->");
        Makeup m2 = new Makeup(Makeup.MIRROR, "白雪公主--->");
        m1.start();
        m2.start();
    }
}

//镜子
class Mirror {

}

//口红
class Lipstick {

}

//化妆
class Makeup extends Thread {
    //添加static修饰符保证只有一份资源
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    static public final int LIPSTICK = 0x1;
    static public final int MIRROR = 0x2;
    int choice; //选择
    String girlName;   //使用化妆品的人名

    //构造方法
    Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //互相持有对方的锁
    private void makeup() throws InterruptedException {
        if (choice == LIPSTICK) {
            synchronized (lipstick) {//获得口红的锁后
                System.out.println(this.girlName + "正在使用口红....");
                Thread.sleep(1000);//使用一秒钟
                System.out.println(this.girlName + "想要使用镜子.....");
                synchronized (mirror) {
                    System.out.println(this.girlName + "正在使用镜子....");
                    Thread.sleep(1000);//使用一秒钟
                }
                System.out.println(this.girlName + "使用完镜子....");
            }
            System.out.println(this.girlName + "使用完口红.....");
        } else {
            synchronized (mirror) {//获得镜子的锁后
                System.out.println(this.girlName + "正在使用口红....");
                Thread.sleep(1000);//使用一秒钟

                System.out.println(this.girlName + "想要使用口红.....");
                synchronized (lipstick) {
                    System.out.println(this.girlName + "正在使用口红....");
                    Thread.sleep(1000);//使用一秒钟
                }
                System.out.println(this.girlName + "使用完口红....");
            }
            System.out.println(this.girlName + "使用完镜子.....");
        }
    }
}