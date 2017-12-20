package com.juliette.api.controller;

import com.juliette.api.operation.ConnectionServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShellRestController {

    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "hello world";
    }
}
