package com.hzz.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzz.dao.SmbmsProviderDao;
import com.hzz.entity.SmbmsProvider;

public interface SmbmsProviderService {
	/**
	 * 添加供应商
	 * @param provider
	 * @return provider
	 */
	int addSmbmsProvider(SmbmsProvider provider);
	
	/**
	 * 修改供应商
	 * @param provider
	 * @return
	 */
	int updateSmbmsProvider(SmbmsProvider provider);
	
	/**
	 * 根据id删除供应商信息
	 * @param id
	 * @return
	 */
	int deleteSmbmsProvider(int id);
	
	/**
	 *  根据供应商编码和名称计算总记录数
	 * @param proCode 应商编码
	 * @param proName 应商名称
	 * @return
	 */
	int getCount(String proCode,String proName);
	
	/**
	 *  根据供应商编码和名称分页
	 * @param proCode 应商编码
	 * @param proName 应商名称
	 * @param currentNo 当前第几页
	 * @param pageSize 显示多少条数据
	 * @return
	 */
	List<SmbmsProvider> getSmbmsProviderList( String proCode,String proName,
			 Integer currentNo,Integer pageSize);
	
	/**
	 * 根据id查询信息
	 * @param id
	 * @return
	 */
	SmbmsProvider getSmbmsProviderById(Long id);
	
}
