package cz.czu.thesis.ds;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"cz.czu"})
public class DsApplication{

    public static void main(String[] args) {
        SpringApplication.run(DsApplication.class, args);
    }

    @Bean
    public Hibernate5Module hibernate4Module()
    {
        Hibernate5Module hibernate5Module = new Hibernate5Module();
        hibernate5Module.configure(Hibernate5Module.Feature.FORCE_LAZY_LOADING, true);
        return hibernate5Module;
    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}