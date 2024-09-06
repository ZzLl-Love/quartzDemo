package cn.zyy.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Author: Zz
 * @Date: 2024/09/06/22:44
 * @Description: 致敬
 *
 * 简单用法
 */
public class TestJob {

    public static void main(String[] args) throws SchedulerException {

        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("job","jobDetail")
                .build();

        // 触发器 指定执行时间 ，开始结束时间
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "trigger1")
                .usingJobData("trigger", "trigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1)
                .repeatForever()).build();

        //调度器 基于trigger 的设定执行job
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.scheduleJob(jobDetail,trigger);

        //启动
        scheduler.start();

    }
}
