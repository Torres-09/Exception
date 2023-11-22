package com.example.Exception.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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

    @GetMapping("/test3")
    public void test3() {
        throw new IllegalAccessError();
    }

    @GetMapping("/test4")
    public void test4() throws IOException {
        throw new IOException();
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(IOException e) {
        return ResponseEntity.ok(e.toString());
    }
}
