package org.example.chemelementsdictionary.api.controller;

import org.example.chemelementsdictionary.api.message.ApiMessages;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class RootController {
    @GetMapping("")
    public ApiMessages.StringMessage root() {
        return new ApiMessages.StringMessage("server is running");
    }

    @GetMapping("ping")
    public ApiMessages.StringMessage ping() {
        return new ApiMessages.StringMessage("pong");
    }
}

