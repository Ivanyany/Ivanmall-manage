package com.ivan.mall.mapper.utils;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

/**
 * 用户信息动态条件查询
 * @author Ivan
 *
 */

public class FindInfoBySqlProvider {
	public String selectByParam(Map<String, Object> param) {
		return new SQL(){
			{				
				SELECT("id, username, password, phone, email, created, updated");
				FROM("ivanmall_user");
				if (param.get("username") != null && param.get("username") != "") {
					WHERE("username  = #{username}");
				}
				if (param.get("phone") != null && param.get("phone") != "") {
					WHERE("phone = #{phone}");
				}
				if (param.get("email") != null && param.get("email") != "") {
					WHERE("email = #{email}");
				}
			}			
		}.toString();
	}
}
