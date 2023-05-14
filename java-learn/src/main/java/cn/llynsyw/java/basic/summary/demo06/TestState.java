package cn.llynsyw.java.basic.summary.demo06;


public class TestState {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("线程t结束.....");
        });

        //创建后获取线程t状态
        Thread.State s=t.getState();
        System.out.println("线程t创建后但未启动时状态"+s);


        //启动后获取线程t状态
        t.start();
        System.out.println("刚启动线程时的状态"+t.getState());

        Thread.State before=t.getState();
        //持续获取终止前线程t的状态
        while (s!=Thread.State.TERMINATED){
            s=t.getState(); //更新t线程状态
            if(s!=before)
            {
                System.out.println("线程状态更新为"+s);
                before=s;
            }
        }
    }
}
