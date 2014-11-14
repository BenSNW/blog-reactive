package se.callista.springmvc.asynch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import se.callista.springmvc.asynch.config.MyEmbeddedServletContainerCustomizer;

@ComponentScan()
@EnableAutoConfiguration
public class Application {

    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletCustomizer(){
        return new MyEmbeddedServletContainerCustomizer();
    }

    @Value("${threadPool.db.max_size}")
    private int THREAD_POOL_DB_MAX_SIZE;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}