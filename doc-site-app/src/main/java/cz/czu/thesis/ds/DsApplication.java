package cz.czu.thesis.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cz.czu"})
public class DsApplication{

    public static void main(String[] args) {
        SpringApplication.run(DsApplication.class, args);
    }
}