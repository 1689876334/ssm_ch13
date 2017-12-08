package com.hzz.service;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzz.entity.SmbmsUser;

public interface SmbmsUserService {
	/**
	 * �û���¼
	 * @param user
	 * @return user
	 */
	SmbmsUser login(SmbmsUser user);
	
	/**
	 * ��ѯ�����û��б�
	 * @return
	 */
	List<SmbmsUser> getSmbmsUsersList();
	
	/**
	 * �����û����Ʋ�ѯ�û��б�
	 * @param userName
	 * @return userName
	 */
	SmbmsUser getSmbmsUserByUserName(String userName);
	
	/**
	 * �����û����ͽ�ɫ��ѯ
	 * @param user
	 * @return
	 */
	SmbmsUser getSmbmsUserByUserNameAndUserRole(SmbmsUser user);
	/**
	 * ����û���
	 * @param user
	 * @return
	 */
	int addSmbmsUser(SmbmsUser user);
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 * @return user
	 */
	int updateSmbmsUser(SmbmsUser user);
	
	/**
	 * ɾ���û�
	 * @param id
	 * @return id
	 */
	int deleteUserById(Long id);
	/**
	 * ��������ѯ�ܼ�¼��
	 * @param userName
	 * @param userRole
	 * @return
	 */
	int getCount(@Param("userName") String userName,@Param("userRole") Integer userRole);
	/**
	 * �����û������û���ɫ��ҳ
	 * @param userName �û���
	 * @param userRole �û�
	 * @param currentNo 
	 * @param pageSize
	 * @return
	 */
	List<SmbmsUser> getSmbmsUserPage(@Param("userName") String userName,@Param("userRole") Integer userRole,@Param("currentNo")int currentNo,@Param("pageSize")int pageSize);
	/**
	 * ����id��ѯ��Ϣ
	 * @param id
	 * @return
	 */
	SmbmsUser getUsers(Serializable id);
}
