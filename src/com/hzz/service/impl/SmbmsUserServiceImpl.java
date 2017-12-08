package com.hzz.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hzz.dao.SmbmsUserDao;
import com.hzz.entity.SmbmsUser;
import com.hzz.service.SmbmsUserService;
@Service
public class SmbmsUserServiceImpl implements SmbmsUserService {
	@Autowired
	private SmbmsUserDao dao;
	
	@Override
	public SmbmsUser login(SmbmsUser user) {
		// TODO Auto-generated method stub
		return dao.login(user);
	}

	@Override
	public List<SmbmsUser> getSmbmsUsersList() {
		// TODO Auto-generated method stub
		return dao.getSmbmsUsersList();
	}

	@Override
	public SmbmsUser getSmbmsUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return dao.getSmbmsUserByUserName(userName);
	}

	@Override
	public SmbmsUser getSmbmsUserByUserNameAndUserRole(SmbmsUser user) {
		// TODO Auto-generated method stub
		return dao.getSmbmsUserByUserNameAndUserRole(user);
	}

	@Override
	public int addSmbmsUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		return dao.addSmbmsUser(user);
	}

	@Override
	public int updateSmbmsUser(SmbmsUser user) {
		// TODO Auto-generated method stub
		return dao.updateSmbmsUser(user);
	}

	@Override
	public int deleteUserById(Long id) {
		// TODO Auto-generated method stub
		return dao.deleteUserById(id);
	}


	@Override
	public List<SmbmsUser> getSmbmsUserPage(String userName, Integer userRole,
			int currentNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getSmbmsUserPage(userName, userRole, (currentNo-1)*pageSize, pageSize);
	}

	@Override
	public int getCount(String userName, Integer userRole) {
		// TODO Auto-generated method stub
		return dao.getCount(userName, userRole);
	}

	public SmbmsUserDao getDao() {
		return dao;
	}

	public void setDao(SmbmsUserDao dao) {
		this.dao = dao;
	}

	@Override
	public SmbmsUser getUsers(Serializable id) {
		// TODO Auto-generated method stub
		SmbmsUser user=new SmbmsUser();
		user.setId((Long)id);
		List<SmbmsUser> users=dao.getUsers(user);
		return users.size()>0?users.get(0):null;
	}
	
	
	

	

}
