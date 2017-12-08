package com.hzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzz.entity.SmbmsProvider;

public interface SmbmsProviderDao {
	/**
	 * ��ӹ�Ӧ��
	 * @param provider
	 * @return provider
	 */
	int addSmbmsProvider(SmbmsProvider provider);
	/**
	 * �޸Ĺ�Ӧ��
	 * @param provider
	 * @return
	 */
	int updateSmbmsProvider(SmbmsProvider provider);
	/**
	 * ����idɾ����Ӧ����Ϣ
	 * @param id
	 * @return
	 */
	int deleteSmbmsProvider(int id);
	
	/**
	 *  ���㹩Ӧ�̱����ܼ�¼��
	 * @param proCode 
	 * @param proName 
	 * @return
	 */
	int getCount(@Param("proCode") String proCode,@Param("proName") String proName);
	
	/**
	 *  ��Ӧ�̱�������Ʒ�ҳ
	 * @param proCode 
	 * @param proName 
	 * @param currentNo 
	 * @param pageSize 
	 * @return
	 */
	List<SmbmsProvider> getSmbmsProviderList(@Param("proCode") String proCode,@Param("proName") String proName,
			@Param("currentNo") Integer currentNo,@Param("pageSize") Integer pageSize);
	
	/**
	 * ����id��ѯ��Ϣ
	 * @param id
	 * @return
	 */
	SmbmsProvider getSmbmsProviderById(Long id);
}
