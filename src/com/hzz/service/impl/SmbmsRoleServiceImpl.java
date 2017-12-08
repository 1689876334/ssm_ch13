package com.hzz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzz.dao.SmbmsRoleDao;
import com.hzz.entity.SmbmsRole;
import com.hzz.service.SmbmsRoleService;
@Service
public class SmbmsRoleServiceImpl implements SmbmsRoleService {
	@Autowired
	private SmbmsRoleDao dao;
	@Override
	public List<SmbmsRole> getSmbmsRoleList() {
		// TODO Auto-generated method stub
		return dao.getSmbmsRoleList();
	}

}
