package cn.zyy.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author: Zz
 * @Date: 2024/09/06/20:46
 * @Description: 致敬
 *
 *
 *
 */
public class TimerTest {

    public static void main(String[] args) {
        Timer timer = new Timer(); //任务启动
        for (int i = 0; i < 2; i++) {
            FooTimerTask task = new FooTimerTask("foo"+i);

            /**
             * timer.schedule()   真正执行的时间取决于上次任务的执行时间 丢任务 (少执行了任务)
             *
             *
             * timer.scheduleAtFixedRate();  严格按照预设时间 （执行时间紊乱）
             *
             */
            timer.schedule(task, new Date(),2000); //任务添加

        }
    }
}


class FooTimerTask  extends TimerTask {

    private String name;

    public FooTimerTask(String name) {
        this.name = name;
    }

    // 创建日期格式化对象
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    int i = 0;
    @Override
    public void run() {



        try {
            System.out.println("-----------------------------"+(++i)+"--------------------------------");
            System.out.println("name="+name + ",startTime----"+ formatter.format(new Date()));
            Thread.sleep(3000);
            System.out.println("name="+name + ",endTime----"+ formatter.format(new Date()));
            System.out.println("-----------------------------"+(i)+"--------------------------------");

            // 为了避免上面的问题，启动线程池来执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}