package com.stories.ws.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@RestController
public class ErrorHandler implements ErrorController {

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    ApiError handleError(WebRequest webRequest){
        Map<String,Object> attiributes  = this.errorAttributes.getErrorAttributes(webRequest, true);
        String message = (String) attiributes.get("message");
        String path = (String) attiributes.get("path");
        int status = (int) attiributes.get("status");

        return new ApiError(status,message,path);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
