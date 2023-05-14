package cn.llynsyw.juc.createThread;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.CreateFutureTask")
public class CreateFutureTask {

    public static void main(String[] args) {
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);
                return 100;
            }
        });

    }
}
