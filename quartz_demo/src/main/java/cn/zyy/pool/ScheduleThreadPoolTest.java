package cn.zyy.pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Zz
 * @Date: 2024/09/06/22:12
 * @Description: 致敬
 *
 * 定时任务线程池
 */
public class ScheduleThreadPoolTest {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService  = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 2; i++) {
            scheduledExecutorService.scheduleAtFixedRate(new Task("任务"+i), 0, 2, TimeUnit.SECONDS);
        }
    }
}

class Task implements Runnable{

    int i = 0;

    private String name;

    // 创建日期格式化对象
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Task(String name) {
        this.name = name;
    }

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
