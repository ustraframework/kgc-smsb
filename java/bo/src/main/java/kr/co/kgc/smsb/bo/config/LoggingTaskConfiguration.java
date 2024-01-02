package kr.co.kgc.smsb.bo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class LoggingTaskConfiguration {
    @Bean
    @Qualifier("loggingThreadPoolTaskScheduler")
    public ThreadPoolTaskScheduler loggingThreadPoolTaskScheduler() {
        final ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(20);
        threadPoolTaskScheduler.setBeanName("loggingThreadPoolTaskScheduler");
        threadPoolTaskScheduler.setAwaitTerminationSeconds(60);
        threadPoolTaskScheduler.setThreadNamePrefix("logging-thread-");
        return threadPoolTaskScheduler;
    }
}
