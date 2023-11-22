package com.example.Exception.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<String> illegalHandle() {
        return ResponseEntity.ok("IllegalArgumentException");
    }

    @ExceptionHandler(value = FileNotFoundException.class)
    public ResponseEntity<String> handle(IOException e) {
        return ResponseEntity.ok("fileNotFound 우선순위 테스트");
    }
}
