package com.example.sun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RestfulResult;
import com.example.demo.utils.CommUtils;
import com.example.sun.entity.ServiceInfo;

@RestController // 重要，如果用Controller会404
@RequestMapping(value = "service")
public class ServiceController {
	@RequestMapping(value = "hello")
    public void login(HttpServletRequest request, HttpServletResponse response,
                      @RequestBody ServiceInfo serviceInfo) {
 
        RestfulResult restfulResult = new RestfulResult();
 
        try {
            restfulResult.setData("Service2:Welcome " + serviceInfo.getName() + "!");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        CommUtils.printDataJason(response, restfulResult);
    }
 
    @RequestMapping(value = "rest")
    public String rest(@RequestBody ServiceInfo serviceInfo){
 
        return "Service2:Welcome " + serviceInfo.getName() + " !";
    }
}
