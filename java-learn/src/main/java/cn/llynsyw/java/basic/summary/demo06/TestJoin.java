package cn.llynsyw.java.basic.summary.demo06;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("The TestJoin Thread is running--->"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(new TestJoin());
        t.start();

        for (int i = 0;  i < 5;  i++) {
            System.out.println("The main Thread is running--->"+i);
            Thread.sleep(100);
            if(i==1){
                System.out.println("阻塞主线程...");
                t.join();  //将t线程插队到main之前并将main阻塞直到t线程执行完
            }
        }


    }
}
