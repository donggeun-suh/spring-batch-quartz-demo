package batch.demo.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class QuartzJobListener implements JobListener {
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        System.out.println("Job 수행 전");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        System.out.println("Job 중단");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        System.out.println("Job 수행 완료 후");
    }
}
