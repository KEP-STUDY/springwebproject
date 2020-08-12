package com.example.demo.task;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FileCheckTask {
    // cron 은 주기를 제어한다. 아래는 매분 0초마다 한 번씩 실행됨.
    @Scheduled(cron = "0 * * * * *")
    // cron = s m h d M w y
    public void checkFiles() throws Exception {
        log.warn("File Check Task run...");
        log.warn("======================================");
    }
}
