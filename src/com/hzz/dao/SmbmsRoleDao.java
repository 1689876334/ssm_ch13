package com.hzz.dao;

import java.util.List;

import com.hzz.entity.SmbmsRole;

public interface SmbmsRoleDao {
	/**
	 * 查询所有角色
	 * @return
	 */
	List<SmbmsRole> getSmbmsRoleList();
}
