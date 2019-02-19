package com.example.demo.SpringBootDemo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Person;
import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.system.UserInfoMapper;

import tk.mybatis.mapper.entity.Example;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTests {

	// slf4j记录器
	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	Person person;

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Test
	public void contextLoads() {

		// System.out.println("打印日志信息...");
		// 日志的级别；
		// 由低到高 trace<debug<info<warn<error
		// 可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
		logger.trace("这是trace日志...");
		logger.debug("这是debug日志...");
		// SpringBoot默认给我们使用的是info级别或更低级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
		logger.info("这是info日志...");
		logger.warn("这是warn日志...");
		logger.error("这是error日志...");
	}

	@Test
	public void getUserInfoById() {
		UserInfo userInfo = userInfoMapper.selectByPrimaryKey("1");
		StringBuilder sb = new StringBuilder().append("用户名:").append(userInfo.getUsername());
		System.out.println(sb.toString());
		List<UserInfo> UserInfoList = userInfoMapper.selectAll();
		for (int i = 0; i < UserInfoList.size(); i++) {
			UserInfo userInfo2 = UserInfoList.get(i);
			System.out.println(
					"序号：" + userInfo2.getId() + " 用户名：" + userInfo2.getUsername() + " 密码：" + userInfo2.getPassword());
		}
	}

	@Test
	public void exampleTest() {
		Example example = new Example(UserInfo.class);
		// 这里给出查询为id=100
		example.createCriteria().andEqualTo("id", 1);
		// 以某字段升序排序
		example.setOrderByClause("Id ASC");
		// 去除重复，boolean型，true为选择不重复的记录
		example.setDistinct(false);
		List<UserInfo> userInfoListserInfoList = userInfoMapper.selectByExample(example);
		for (int i = 0; i < userInfoListserInfoList.size(); i++) {
			UserInfo userInfo = userInfoListserInfoList.get(i);
			System.out.println(
					"序号：" + userInfo.getId() + " 用户名：" + userInfo.getUsername() + " 密码：" + userInfo.getPassword());
		}
	}

	@Test
	/*
	 * 测试@ConfigurationProperties获取配置文件的信息
	 */
	public void testPersonConfigurationProperties() {
		System.out.println(person);
	}
}
