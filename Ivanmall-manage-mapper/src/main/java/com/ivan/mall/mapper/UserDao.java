package com.ivan.mall.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.ivan.mall.mapper.utils.FindInfoBySqlProvider;
import com.ivan.mall.pojo.User;

/**
 * 用户Mapper接口
 * @author Ivan
 *
 */

public interface UserDao {

	//校验数据--1,2,3分别对应username,phone,email:动态条件查询
	@SelectProvider(type=FindInfoBySqlProvider.class,method="selectByParam")
	List<User> findInfo(Map<String, Object> param);

	//用户注册
	@Insert("insert into ivanmall_user(username, password, phone, email, created, updated) values(#{username}, #{password}, #{phone}, #{email}, #{created}, #{updated})")
	void insertUser(User user);

	//用户登录
	@Select("select id, password, phone, email, created, updated from ivanmall_user where username = #{username}")
	List<User> selectUser(String username);
	
}
