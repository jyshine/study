package com.shine;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
//@EnableJpaRepositories(basePackages = "study.datajpa.repository")
//jpa repository 위치를 잡아줘야한다. 안잡아 줄 경우 Application.class 위치 기준으로 하위 패키지로 스켄
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
