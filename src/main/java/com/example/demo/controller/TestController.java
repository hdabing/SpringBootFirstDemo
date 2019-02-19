package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.system.UserInfoMapper;

/*@RestController等价于@Controller+@ResponseBody的结合，
 * 使用这个注解的类里面的方法都以json格式输出；
 * */
@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
    private UserInfoMapper userInfoMapper;
	
    @GetMapping("/hello")
    public String hello(){
        return "hello SpringBoot！Come on！";
    }
    @RequestMapping("/mybatis")
    public String mybatis(){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey("1");
        return new StringBuilder().append("用户名:").append(userInfo.getUsername()).toString();
    }
}