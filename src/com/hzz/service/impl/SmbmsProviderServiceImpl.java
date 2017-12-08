package com.hzz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzz.dao.SmbmsProviderDao;
import com.hzz.entity.SmbmsProvider;
import com.hzz.service.SmbmsProviderService;
@Service
public class SmbmsProviderServiceImpl implements SmbmsProviderService {
	@Autowired
	private SmbmsProviderDao dao;
	@Override
	public int addSmbmsProvider(SmbmsProvider provider) {
		// TODO Auto-generated method stub
		return dao.addSmbmsProvider(provider);
	}
	@Override
	public int updateSmbmsProvider(SmbmsProvider provider) {
		// TODO Auto-generated method stub
		return dao.updateSmbmsProvider(provider);
	}
	@Override
	public int deleteSmbmsProvider(int id) {
		// TODO Auto-generated method stub
		return dao.deleteSmbmsProvider(id);
	}
	@Override
	public int getCount(String proCode, String proName) {
		// TODO Auto-generated method stub
		return dao.getCount(proCode, proName);
	}
	@Override
	public List<SmbmsProvider> getSmbmsProviderList(String proCode,
			String proName, Integer currentNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return dao.getSmbmsProviderList(proCode, proName, (currentNo-1)*pageSize, pageSize);
	}
	@Override
	public SmbmsProvider getSmbmsProviderById(Long id) {
		// TODO Auto-generated method stub
		return dao.getSmbmsProviderById(id);
	}

}
