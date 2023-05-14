package cn.llynsyw.java.basic.summary.demo01;


//模拟龟兔赛跑
public class Race implements Runnable {
    //是否结束
    private boolean end = false;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---->已经跑了" + i + "米");
            if (end) break;
            if (Thread.currentThread().getName() == "rabbit") {
                i++;        //兔子跑步长加1
                if (i == 61)   //如果兔子到了61m就睡觉2毫秒
                {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (i >= 100) {
                end = true;   //结束比赛
                System.out.println("比赛结束胜利者是" + Thread.currentThread().getName());
            }

        }
    }

    //主方法
    public static void main(String[] args) {
       /* Race race = new Race();

        //兔子线程
        new Thread(race, "rabbit").start();

        //乌龟线程
        new Thread(race, "tortoise").start();*/

        new Thread(new Race(), "rabbit").start();

        new Thread(new Race(), "tortoise").start();
    }
}
