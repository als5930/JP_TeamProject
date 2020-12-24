package com.biz.big.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.big.model.IoListVO;
import com.biz.big.model.IpriceVO;

public interface IpriceDao {
	
	@Select(" SELECT * FROM tbl_iolist ")
	public List<IpriceVO> selectAll();
	
	@Select("SELECT MAX(io_dcode) FROM tbl_iolist")
	public String maxICode();

	
	@Select(" SELECT * FROM tbl_iolist WHERE io_seq = #{id} ")
	public IpriceVO findByID(String id);

	public int insert(IpriceVO vo);



}
