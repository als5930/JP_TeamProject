package com.biz.big.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.big.model.IoListVO;

public interface IoListDao extends GenericDao<IoListVO, String> {

	@Select(" SELECT * FROM tbl_iolist ")
	@Override
	public List<IoListVO> selectAll();
	
	@Select("SELECT MAX(io_dcode) FROM tbl_iolist")
	public String maxICode();

	
	@Select(" SELECT * FROM tbl_iolist WHERE io_seq = #{id} ")
	@Override
	public IoListVO findByID(String id);


	

}
