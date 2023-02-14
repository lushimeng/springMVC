package com.itheima.controller;

import com.itheima.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @Author Mr.Lu
 * @Date 2022/12/15 18:25
 * @ClassName UserController
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 普通参数传递 + GET/POST方式
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/commonParam")
    @ResponseBody
    public String commonParam(String name, int age){
        System.out.println("普通参数传递 name: = " + name + ", age = " + age);
        return "{'module':'commonParam'}";
    }


    @RequestMapping("/commonParamDifferenceName")
    @ResponseBody
    // 形参与地址参数名不一致解决方式,其中name必不可少
    public String commonParamDifferenceName(@RequestParam("name") String userName, int age){
        System.out.println("普通参数userName ==> " + userName);
        System.out.println("普通参数age ==> " + age);
        return "{'module':'common param different name'}";
    }


    /**
     * pojo数据类型测试
     * @param user
     * @return
     */
    @RequestMapping("/pojoParam")
    @ResponseBody
    public String pojoParam(User user){
        System.out.println("pojo参数传递 user==>" + user);
        return "{'module':'pojo param'}";
    }

    /**
     * 镶嵌pojo类型参数
     * @param user
     * @return
     */
    @RequestMapping("/pojoParamInner")
    @ResponseBody
    public String pojoParamInner(User user){
        System.out.println("pojo参数传递 user==>" + user);
        return "{'module':'pojo param'}";
    }


    /**
     * 数组类型参数
     * @param likes
     * @return
     */
    @RequestMapping("/arrayParam")
    @ResponseBody
    public String arrayParam(String[] likes){
        System.out.println("数组参数传递 likes ==>" + Arrays.toString(likes));
        return "{'module':'array param'}";
    }


    /**
     * 集合类型参数
     * @param likes
     * @return
     */
    @RequestMapping("/listParam")
    @ResponseBody
    public String listParam(@RequestParam List<String> likes){
        System.out.println("集合参数传递 likes ==>" + likes);
        return "{'module':'list param'}";
    }
}
