package batch.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class PrintJobConfig {

    @Bean
    public Job printJob(JobRepository jobRepository, Step printJobStep){
        return new JobBuilder("printJob", jobRepository)
                .start(printJobStep)
                .build();

    }

    @Bean
    public Step printJobStep(JobRepository jobRepository, Tasklet printJobTasklet, PlatformTransactionManager platformTransactionManager){
        return new StepBuilder("printJobStep", jobRepository)
                .tasklet(printJobTasklet, platformTransactionManager).build();
    }

    @Bean
    public Tasklet printJobTasklet(){
        return ((contribution, chunkContext) -> {
            System.out.println("printJob test");
            return RepeatStatus.FINISHED;
        });
    }
}