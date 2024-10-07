package com.sjala.spring.kafka.cabbookdriver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjala.spring.kafka.cabbookdriver.service.CabLocationService;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    //Business Logic

    @GetMapping
    public ResponseEntity<Map<String, String>> serviceStatus() {
    	return new ResponseEntity<>(Map.of("message", "cabbookdriver healthy")
    	        , HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Map<String, String>> updateLocation() throws InterruptedException {

        int range = 100;
        while (range > 0) {
            cabLocationService.updateLocation(Math.random() + " , " + Math.random());
            Thread.sleep(1000);
            range --;
        }

        return new ResponseEntity<>(Map.of("message", "Location Updated")
        , HttpStatus.OK);
    }
}
