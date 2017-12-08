package com.hzz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzz.entity.SmbmsBill;

public interface SmbmsBillService {
	/**
	 * ��������
	 * @param smbmsBill
	 * @return
	 */
	int addSmbmsBill(SmbmsBill smbmsBill);
	/**
	 * ����idɾ������
	 * @param id
	 * @return
	 */
	int deleteSmbmsBillById(int id);
	/**
	 * ���¶���
	 * @param smbmsBill
	 * @return
	 */
	int updateSmbmsBill(SmbmsBill smbmsBill);
	/**
	 * ���ݶ������ƺͱ����ҳ
	 * @param billCode
	 * @param productName
	 * @param currentNo
	 * @param pageSize
	 * @return
	 */
	List<SmbmsBill> getSmbmsBillList(@Param("billCode") String billCode,@Param("productName") String productName,
			@Param("currentNo") Integer currentNo,@Param("pageSize") Integer pageSize);
	/**
	 *  ���㶩�������ܼ�¼��
	 * @param proCode 
	 * @param proName 
	 * @return
	 */
	int getCount(@Param("billCode") String billCode,@Param("productName") String productName);
	/**
	 *  ��Ʒ����ģ����ѯ�͹�Ӧ��id�Ƿ񸶿�
	 * @param productName
	 * @param providerId
	 * @param isPayment
	 * @return
	 */
	List<SmbmsBill> getSmbmsBillProductName(@Param("productName")String productName,@Param("providerId")int providerId,@Param("isPayment")int isPayment);
	
}
