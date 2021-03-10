package dev.qwett;

import dev.qwett.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebAppSpringApplication {

    private static final Logger logger = LoggerFactory.getLogger(StoreService.class);

    public static void main(String[] args) {
        SpringApplication.run(WebAppSpringApplication.class, args);
        logger.info("Application has started");
    }

}
