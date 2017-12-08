package com.hzz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hzz.entity.SmbmsProvider;

public interface SmbmsProviderDao {
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
	 *  计算供应商编码总记录数
	 * @param proCode 
	 * @param proName 
	 * @return
	 */
	int getCount(@Param("proCode") String proCode,@Param("proName") String proName);
	
	/**
	 *  供应商编码和名称分页
	 * @param proCode 
	 * @param proName 
	 * @param currentNo 
	 * @param pageSize 
	 * @return
	 */
	List<SmbmsProvider> getSmbmsProviderList(@Param("proCode") String proCode,@Param("proName") String proName,
			@Param("currentNo") Integer currentNo,@Param("pageSize") Integer pageSize);
	
	/**
	 * 根据id查询信息
	 * @param id
	 * @return
	 */
	SmbmsProvider getSmbmsProviderById(Long id);
}
