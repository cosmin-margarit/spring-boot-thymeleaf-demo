package com.cosmin.web;

import com.cosmin.repository.RepositoryModule;
import com.cosmin.service.ServiceModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({RepositoryModule.class, ServiceModule.class})
public class ThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }
}
