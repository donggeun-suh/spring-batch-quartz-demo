package batch.demo.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

@Component
public class PrintScheduler {
//    @Scheduled(fixedDelay = 1000) // 이전 Task의 종료 시점부터 정의된 시간만큼
//    public void printAfterwardsBySecond(){
//        System.out.println("start-------------------------");
//        for (int i = 0; i <10 ; i++) {
//            System.out.println("printAfterwards");
//        }
//    }
//
//    @Scheduled(fixedRate = 1000) // 이전 Task의 시작 시점부터 정의된 시간만큼
//    public void printAtStartBySecond(){
//        System.out.println("start-------------------------");
//        for (int i = 0; i <10; i++) {
//            System.out.println("printAtStart");
//        }
//    }
//
//    @Scheduled(fixedRate = 1000, initialDelay = 3000) // 초기 대기 시간
//    public void initialDelay(){
//        System.out.println("start-------------------------");
//        for (int i = 0; i <10; i++) {
//            System.out.println("initialDelay");
//        }
//    }

//    @Scheduled(cron = "0 0 18 * * *", zone = "Asia/Seoul") // 매일 오후 6시에 scheduling
//    public void cronSetting(){
//        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
//        // time: 2023년 12월 2일 토요일
//        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
//        //2023-12-02 토 18:00
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("YYYY-MM-dd E HH:mm", Locale.KOREA);
//        System.out.println("time: " + now.format(formatter));
//        System.out.println("time: " + now.format(formatter2));
//        System.out.println("start-------------------------");
//        for (int i = 0; i <10; i++) {
//            System.out.println("cronSetting");
//        }
//    }
}
