package com.oss.springsesssion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(HttpServletRequest request, HttpServletResponse response){
        Object testAttrValue = request.getSession().getAttribute("testAttrName");
        if(null == testAttrValue){
            request.getSession().setAttribute("testAttrName", "testAttrValue");
        }
        System.out.println("80: " + testAttrValue);
        return "testAttrValue="+testAttrValue;
    }

    @GetMapping("/set")
    public void test(HttpServletRequest request){
        request.getSession().setAttribute("message",request.getQueryString());
    }


    @GetMapping("/get")
    public Map<String,Object> two(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("sessionId",request.getSession().getId());
        map.put("message",request.getSession().getAttribute("message"));
        return map;
    }


}
