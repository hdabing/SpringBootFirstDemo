package com.example.demo.SpringBootDemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.system.UserInfoMapper;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import tk.mybatis.mapper.entity.Example;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
    private UserInfoMapper userInfoMapper;
	
	@Test
    public void getUserInfoById(){
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey("1");
        StringBuilder sb=new StringBuilder().append("用户名:").append(userInfo.getUsername());
        System.out.println(sb.toString());
        List<UserInfo> UserInfoList=userInfoMapper.selectAll();
        for (int i = 0; i < UserInfoList.size(); i++) {
        	UserInfo userInfo2=UserInfoList.get(i);
        	System.out.println("序号："+userInfo2.getId()+" 用户名："+userInfo2.getUsername()+" 密码："+userInfo2.getPassword());
		}
    }
	@Test
    public void exampleTest(){
        Example example =new Example(UserInfo.class);
        //这里给出查询为id=100
        example.createCriteria().andEqualTo("id",1);
        //以某字段升序排序
        example.setOrderByClause("Id ASC"); 
        //去除重复，boolean型，true为选择不重复的记录
        example.setDistinct(false);
        List<UserInfo> userInfoListserInfoList = userInfoMapper.selectByExample(example);
        for (int i = 0; i < userInfoListserInfoList.size(); i++) {
        	UserInfo userInfo=userInfoListserInfoList.get(i);
        	System.out.println("序号："+userInfo.getId()+" 用户名："+userInfo.getUsername()+" 密码："+userInfo.getPassword());
		}
    }
}
