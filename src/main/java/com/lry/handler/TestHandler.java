package com.lry.handler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liurenyi
 * @create 2019--12--28--14:43
 */
@RestController
public class TestHandler {
    @RequestMapping("/")
    public String test(){
        System.out.println("666");
        return "Hello SpringBoot";
    }
}
