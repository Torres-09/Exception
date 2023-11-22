//package com.example.Exception.advice;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ProblemDetail;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionController extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(value = IllegalArgumentException.class)
//    public DefaultErrorAttributes handleIllegalArgument(IllegalArgumentException e) {
//        log.warn("handleIllegalArgument", e);
//        return new DefaultErrorAttributes();
//    }
//
//    @ExceptionHandler(value = IllegalAccessError.class)
//    public ProblemDetail handleException(Exception e) {
//        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, "에러 설명 메시지");
//    }
//}
