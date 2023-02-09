package com.example.superkassa;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1")
public class MyController {
    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MyJson> getById(@RequestBody RequestDTO request) {
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        MyJson myJson = service.changeCurrent(request.getId(), request.getAdd());
        if (myJson == null) {
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(myJson, HttpStatus.OK);
    }

}
