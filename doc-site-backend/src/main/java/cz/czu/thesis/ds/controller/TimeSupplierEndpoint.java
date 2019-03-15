package cz.czu.thesis.ds.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
//@RequestMapping(path = "/public", produces = MediaType.APPLICATION_JSON_VALUE)
public class TimeSupplierEndpoint {

    private RestTemplate restTemplate;

    @Autowired
    public TimeSupplierEndpoint(RestTemplate rt) {
        this.restTemplate = rt;
    }

    @GetMapping(path = "/public/time", produces = APPLICATION_JSON_VALUE)
    public ZonedDateTime currentTime(){
        return ZonedDateTime.now();
    }

    @GetMapping(path = "/private/secretTime", produces = APPLICATION_JSON_VALUE)
    public ZonedDateTime currentSecretTime(){
        return ZonedDateTime.now(ZoneId.of("UTC"));
    }

    @GetMapping("/book/{isbn}")
    String lookupBookByIsbn(@PathVariable String isbn){
        ResponseEntity<String> exchange = restTemplate.exchange("https://googleapis.com/books/v1/volumes?q=isbn:" + isbn, HttpMethod.GET, null,
                String.class);

        return exchange.getBody();
    }

}
