//package batch.demo.quartz;
//
//// QuartzConfig.java
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfig {
//
//    @Bean
//    public JobDetail printJobDetail() {
//        return JobBuilder.newJob(QuartzBatchJob.class)
//                .withIdentity("printJob")
//                .storeDurably()
//                .build();
//    }
//
//    @Bean
//    public Trigger printJobTrigger() {
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(10) // Run every 10 seconds
//                .repeatForever();
//
//        return TriggerBuilder.newTrigger()
//                .forJob(printJobDetail())
//                .withIdentity("printJobTrigger")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
//}