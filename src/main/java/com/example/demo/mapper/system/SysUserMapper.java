package com.example.demo.mapper.system;

import com.example.demo.entity.SysUser;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SysUserMapper extends Mapper<SysUser>, MySqlMapper<SysUser> {
}