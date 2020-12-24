package com.biz.big.service;

import java.util.List;

public interface GenericService<VO, PK> {
	
	public List<VO> selectAll();
	public VO findByID(PK id);
	
	
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK id);
	
	
	

}
