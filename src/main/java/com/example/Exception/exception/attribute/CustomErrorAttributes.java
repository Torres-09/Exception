//package com.example.Exception.exception.attribute;
//
//import org.springframework.boot.web.error.ErrorAttributeOptions;
//import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.WebRequest;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class CustomErrorAttributes extends DefaultErrorAttributes {
//
//    @Override
//    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
//        Map<String, Object> errorAttributes = new HashMap<>();
//        errorAttributes.put("timestamp", new Date());
//        errorAttributes.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
//        return errorAttributes;
//    }
//}
