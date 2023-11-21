package com.example.Exception.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    @GetMapping("/test1")
    public void test1() {
        throw new IllegalArgumentException();
    }

    @GetMapping("/test2")
    public void test2() {
        throw new IllegalStateException();
    }
}
