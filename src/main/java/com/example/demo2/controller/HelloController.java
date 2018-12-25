package com.example.demo2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Misaki
 * @date 2018/12/19/019 17:58
 **/

@RestController
@RequestMapping("test")
public class HelloController {
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
