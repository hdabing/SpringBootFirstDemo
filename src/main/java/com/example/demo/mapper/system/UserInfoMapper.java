package com.example.demo.mapper.system;

import com.example.demo.entity.UserInfo;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface UserInfoMapper extends Mapper<UserInfo>, MySqlMapper<UserInfo> {
}