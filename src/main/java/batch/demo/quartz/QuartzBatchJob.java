package batch.demo.quartz;

import batch.demo.util.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class QuartzBatchJob extends QuartzJob {

    private final JobLauncher jobLauncher;

    private final BeanUtil beanUtil;


    @Override
    @SneakyThrows
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        Job job = (Job) beanUtil.getBean((String) jobDataMap.get("JOB_NAME"));

        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("curDate", new Date())
                .toJobParameters();


        jobLauncher.run(job, jobParameters);
    }
}
