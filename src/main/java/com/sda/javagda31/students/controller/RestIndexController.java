package com.sda.javagda31.students.controller;

import com.sda.javagda31.students.model.APIResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestIndexController {

    @GetMapping("/")
    public APIResponse index() {
        return new APIResponse("Helloł łorld!");
    }

    // Request param
    // Path variable

    // localhost:8080/api/welcome?imieTwe=...
    // http://localhost:8080/api/welcome?imieTwe=pawel
    @GetMapping("/welcome")
    public APIResponse welcome(@RequestParam(name = "imieTwe") String imie) {
        return new APIResponse("Welcome " + imie + "!");
    }
}
