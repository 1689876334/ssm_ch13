package com.hzz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzz.entity.SmbmsBill;

public interface SmbmsBillService {
	/**
	 * 新增订单
	 * @param smbmsBill
	 * @return
	 */
	int addSmbmsBill(SmbmsBill smbmsBill);
	/**
	 * 根据id删除订单
	 * @param id
	 * @return
	 */
	int deleteSmbmsBillById(int id);
	/**
	 * 更新订单
	 * @param smbmsBill
	 * @return
	 */
	int updateSmbmsBill(SmbmsBill smbmsBill);
	/**
	 * 根据订单名称和编码分页
	 * @param billCode
	 * @param productName
	 * @param currentNo
	 * @param pageSize
	 * @return
	 */
	List<SmbmsBill> getSmbmsBillList(@Param("billCode") String billCode,@Param("productName") String productName,
			@Param("currentNo") Integer currentNo,@Param("pageSize") Integer pageSize);
	/**
	 *  计算订单编码总记录数
	 * @param proCode 
	 * @param proName 
	 * @return
	 */
	int getCount(@Param("billCode") String billCode,@Param("productName") String productName);
	/**
	 *  商品名称模糊查询和供应商id是否付款
	 * @param productName
	 * @param providerId
	 * @param isPayment
	 * @return
	 */
	List<SmbmsBill> getSmbmsBillProductName(@Param("productName")String productName,@Param("providerId")int providerId,@Param("isPayment")int isPayment);
	
}
