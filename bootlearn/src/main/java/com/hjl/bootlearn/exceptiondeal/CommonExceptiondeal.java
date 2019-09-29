package com.hjl.bootlearn.exceptiondeal;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * User: hjl
 * Date: 19-9-29
 * Time: 上午10:56
 * Description:
 */
@ControllerAdvice
public class CommonExceptiondeal implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return "exception";
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception ex){
        System.out.println("*****************");
        return new ResponseEntity<Object>("hello"+ex.getMessage(), HttpStatus.OK);
    }

}
