package com.biz.big.service;

import java.util.List;

import com.biz.big.model.IoListVO;

public interface IoListService extends GenericService<IoListVO, String> {

	public List<IoListVO> selectAll();
	public IoListVO findByID(String id);
	
	public int insert(IoListVO vo);
	
	public String getICode();
	
	
	
}
