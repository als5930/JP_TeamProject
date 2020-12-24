package com.biz.big.service;

import java.util.List;

import com.biz.big.model.IoListVO;
import com.biz.big.model.IpriceVO;

public interface IpriceService extends GenericService<IpriceVO, String>{
	public List<IpriceVO> selectAll();
	public IpriceVO findByID(String id);
	
	public int insert(IpriceVO vo);
}
