package com.biz.big.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.big.model.DeptVO;
import com.biz.big.persistence.DeptDao;
import com.biz.big.service.DeptService;


@Service("deptServiceV1")
public class DeptServiceImplV1 implements DeptService{
	
	@Autowired
	private DeptDao deptDao;

	@Override
	public List<DeptVO> selectAll() {
		
		return deptDao.selectAll();
	}

	@Override
	public DeptVO findByID(String id) {
		
		return deptDao.findByID(id);
	}

	@Override
	public int insert(DeptVO vo) {
		// TODO Auto-generated method stub
		return deptDao.insert(vo);
	}

	@Override
	public int update(DeptVO vo) {
		int ret = deptDao.update(vo);
				
				
		
		return ret;
	}

	@Override
	public int delete(String id) {
		int ret = deptDao.delete(id);
		return ret;
	}

	@Override
	public String getDCode() {
		
		String retDCode = "D001";
		try {
			
			String maxCode = deptDao.maxDCode();
			String preCode = maxCode.substring(0,1);
			int dcode = Integer.valueOf(maxCode.substring(1)) +1;
			retDCode = String.format("%s%03d", preCode, dcode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return retDCode;
	}
	

}
