package com.example.Exception.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/exception")
public class ExceptionHandlerExceptionResolverController {

    @GetMapping("/test1")
    public void test1() throws IOException {
        throw new IOException();
    }

    @GetMapping("/test2")
    public void test2() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    @ExceptionHandler
    public ResponseEntity<String> totalHandle(IOException e) {
        return ResponseEntity.ok("IOException");
    }

    @ExceptionHandler(value = FileNotFoundException.class)
    public ResponseEntity<String> handle(IOException e) {
        return ResponseEntity.ok("fileNotFound");
    }
}
