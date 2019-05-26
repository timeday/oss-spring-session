package com.oss.springsesssion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 6000) //主类首先开启EnableRedisHttpSession注解
public class OssSpringSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(OssSpringSessionApplication.class, args);
    }


    /**
     * 用于清除数据库中过期的session
     * @return
     */
    @Bean
    public TaskScheduler taskScheduler(){

        return new ThreadPoolTaskScheduler();

    }

}
