package com.hzz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hzz.dao.SmbmsBillDao;
import com.hzz.entity.SmbmsBill;
import com.hzz.service.SmbmsBillService;
@Service
public class SmbmsBillServiceImpl implements SmbmsBillService {
	@Autowired
	private SmbmsBillDao dao;
    
	@Override
	public List<SmbmsBill> getSmbmsBillProductName(String productName,
			int providerId, int isPayment) {
		// TODO Auto-generated method stub
		return dao.getSmbmsBillProductName(productName, providerId, isPayment);
	}

	@Override
	public int addSmbmsBill(SmbmsBill smbmsBill) {
		// TODO Auto-generated method stub
		return dao.addSmbmsBill(smbmsBill);
	}

	@Override
	public int deleteSmbmsBillById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteSmbmsBillById(id);
	}

	@Override
	public int updateSmbmsBill(SmbmsBill smbmsBill) {
		// TODO Auto-generated method stub
		return dao.updateSmbmsBill(smbmsBill);
	}

	@Override
	public List<SmbmsBill> getSmbmsBillList(String billCode, String productName, Integer currentNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return dao.getSmbmsBillList(billCode, productName, currentNo, pageSize);
	}

	@Override
	public int getCount(String billCode, String productName) {
		// TODO Auto-generated method stub
		return dao.getCount(billCode, productName);
	}
	

}
