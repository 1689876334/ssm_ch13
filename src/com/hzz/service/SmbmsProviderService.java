package com.hzz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzz.dao.SmbmsProviderDao;
import com.hzz.entity.SmbmsProvider;

public interface SmbmsProviderService {
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
	 *  ���ݹ�Ӧ�̱�������Ƽ����ܼ�¼��
	 * @param proCode Ӧ�̱���
	 * @param proName Ӧ������
	 * @return
	 */
	int getCount(String proCode,String proName);
	
	/**
	 *  ���ݹ�Ӧ�̱�������Ʒ�ҳ
	 * @param proCode Ӧ�̱���
	 * @param proName Ӧ������
	 * @param currentNo ��ǰ�ڼ�ҳ
	 * @param pageSize ��ʾ����������
	 * @return
	 */
	List<SmbmsProvider> getSmbmsProviderList( String proCode,String proName,
			 Integer currentNo,Integer pageSize);
	
	/**
	 * ����id��ѯ��Ϣ
	 * @param id
	 * @return
	 */
	SmbmsProvider getSmbmsProviderById(Long id);
	
}
