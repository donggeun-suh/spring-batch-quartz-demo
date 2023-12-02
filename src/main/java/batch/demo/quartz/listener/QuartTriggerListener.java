package batch.demo.quartz.listener;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class QuartTriggerListener implements TriggerListener {
    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        System.out.println("Trigger 실행");
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        JobDataMap map =  context.getJobDetail().getJobDataMap();

        int executeCount = 1;

        if(map.containsKey("executeCount")) {
            executeCount = (int) map.get("executeCount");
        }

        return executeCount >= 3 ;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        System.out.println("Trigger 실패");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        System.out.println("Trigger 성공");
    }
}
