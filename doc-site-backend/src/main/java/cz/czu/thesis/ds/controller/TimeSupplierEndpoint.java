package cz.czu.thesis.ds.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class TimeSupplierEndpoint {

    @GetMapping(path = "/time", produces = APPLICATION_JSON_VALUE)
    public ZonedDateTime currentTime(){
        return ZonedDateTime.now();
    }

    @GetMapping(path = "/secretTime", produces = APPLICATION_JSON_VALUE)
    public ZonedDateTime currentSecretTime(){
        return ZonedDateTime.now(ZoneId.of("UTC"));
    }

}
