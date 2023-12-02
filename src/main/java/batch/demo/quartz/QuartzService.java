package batch.demo.quartz;

import batch.demo.quartz.listener.QuartTriggerListener;
import batch.demo.quartz.listener.QuartzJobListener;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class QuartzService {
    private final Scheduler scheduler;
    private static final String JOB_NAME = "JOB_NAME";

    @PostConstruct
    public void init(){
        try {
            scheduler.clear();
            scheduler.getListenerManager().addJobListener(new QuartzJobListener());
            scheduler.getListenerManager().addTriggerListener(new QuartTriggerListener());

            addJob(QuartzBatchJob.class, "printJob", "printJobDesc", "0 * * ? * *");



        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends Job> void addJob(Class<? extends Job> job, String name, String desc, String cron) throws SchedulerException {
        JobDetail jobDetail = buildJobDetail(job, name, desc);
        Trigger trigger = buildCronTrigger(cron);

        if(scheduler.checkExists(jobDetail.getKey())) scheduler.deleteJob(jobDetail.getKey());
        scheduler.scheduleJob(jobDetail, trigger);
    }


    public <T extends Job> JobDetail buildJobDetail(Class<? extends Job> job, String name, String desc){
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(JOB_NAME, name);
        jobDataMap.put("executeCount", 1);

        return JobBuilder.newJob(job)
                .withIdentity(name)
                .withDescription(desc)
                .usingJobData(jobDataMap)
                .build();
    }



    private Trigger buildCronTrigger(String cronExp){
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExp))
                .build();
    }



}
