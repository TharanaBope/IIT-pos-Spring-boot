package com.iitposs.pos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // this is a rest conrtrooler to sya to the spring boot
@CrossOrigin // for security purupose
@RequestMapping("api/v1/test") // the mapping
public class TestController {

    @GetMapping(path="/get-text")
    public String getMyText() {
        return "Hello World";
    }

    @GetMapping(path="/get-name")
    public String getMyName(){
        return "My name is Tharana";
    }

}
