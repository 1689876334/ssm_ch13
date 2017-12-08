package com.hzz.service;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzz.entity.SmbmsUser;

public interface SmbmsUserService {
	/**
	 * 用户登录
	 * @param user
	 * @return user
	 */
	SmbmsUser login(SmbmsUser user);
	
	/**
	 * 查询所有用户列表
	 * @return
	 */
	List<SmbmsUser> getSmbmsUsersList();
	
	/**
	 * 根据用户名称查询用户列表
	 * @param userName
	 * @return userName
	 */
	SmbmsUser getSmbmsUserByUserName(String userName);
	
	/**
	 * 根据用户名和角色查询
	 * @param user
	 * @return
	 */
	SmbmsUser getSmbmsUserByUserNameAndUserRole(SmbmsUser user);
	/**
	 * 添加用户名
	 * @param user
	 * @return
	 */
	int addSmbmsUser(SmbmsUser user);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return user
	 */
	int updateSmbmsUser(SmbmsUser user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return id
	 */
	int deleteUserById(Long id);
	/**
	 * 按条件查询总记录数
	 * @param userName
	 * @param userRole
	 * @return
	 */
	int getCount(@Param("userName") String userName,@Param("userRole") Integer userRole);
	/**
	 * 根据用户名字用户角色分页
	 * @param userName 用户名
	 * @param userRole 用户
	 * @param currentNo 
	 * @param pageSize
	 * @return
	 */
	List<SmbmsUser> getSmbmsUserPage(@Param("userName") String userName,@Param("userRole") Integer userRole,@Param("currentNo")int currentNo,@Param("pageSize")int pageSize);
	/**
	 * 根据id查询信息
	 * @param id
	 * @return
	 */
	SmbmsUser getUsers(Serializable id);
}
