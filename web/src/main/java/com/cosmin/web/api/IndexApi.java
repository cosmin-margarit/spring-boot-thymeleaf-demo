package com.cosmin.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class IndexApi {

    @GetMapping
    public ResponseEntity index(@RequestParam(value = "name") String name) {
        if (name.equalsIgnoreCase("Cosmin")) {
            throw new RuntimeException("Iesi afara");
        }
        return ResponseEntity.ok(String.format("Hello %s", name));
    }
}
