package com.biz.big.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.big.model.IoListVO;
import com.biz.big.model.IpriceVO;
import com.biz.big.persistence.IpriceDao;
import com.biz.big.service.IpriceService;

@Service("ipServiceV1")
public class IpriceServiceImplV1 implements IpriceService{


	
	@Autowired
	private IpriceDao ipDao;


	@Override
	public List<IpriceVO> selectAll() {
	
		return ipDao.selectAll();
	}

	@Override
	public IpriceVO findByID(String id) {
		
		return ipDao.findByID(id);
	}

	@Override
	public int insert(IpriceVO vo) {
	
		return ipDao.insert(vo);
	}
	
	@Override
	public int update(IpriceVO vo) {
		
		return 0;
	}

	@Override
	public int delete(String id) {
		
		return 0;
	}



}
