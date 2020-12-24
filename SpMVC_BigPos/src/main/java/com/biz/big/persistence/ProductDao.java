package com.biz.big.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.big.model.ProductVO;

public interface ProductDao extends GenericDao<ProductVO, String> {
	
	@Select(" SELECT * FROM tbl_product ")
	@Override
	public List<ProductVO> selectAll();
	
	public List<ProductVO> findByTitle(String title);
	
	
	
	@Select(" SELECT MAX(p_code) FROM tbl_product ")
	public String maxPCode();
	
	
	@Select(" SELECT * FROM tbl_product "
			+ " WHERE p_code = RPAD(#{id},6 ,' ')  " )
	@Override
	public ProductVO findByID(String id);
}
