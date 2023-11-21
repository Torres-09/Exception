package com.example.Exception.exception.attribute;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomErrorAttributes implements ErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = new HashMap<>();
        errorAttributes.put("timestamp", new Date());
        errorAttributes.put("path", webRequest.getContextPath());
        errorAttributes.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        return errorAttributes;
    }

    @Override
    public Throwable getError(WebRequest webRequest) {
        return null;
    }
}
