package cn.zyy.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Zz
 * @Date: 2024/09/06/22:42
 * @Description: 致敬
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        // 创建日期格式化对象
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = formatter.format(new Date());
        System.out.println("My Job execute ---->" + currentTime);

        //获取参数
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        JobDataMap triggerMap = context.getTrigger().getJobDataMap();

        JobDataMap mergeMap = context.getMergedJobDataMap();

        System.out.println("jobDataMap: " + jobDataMap.getString("job"));
        System.out.println("trigger: " + triggerMap.getString("trigger"));
        System.out.println("mergeMap:" + mergeMap.getString("trigger"));
        }
}
