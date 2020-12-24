package com.biz.big.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.big.model.IoListVO;
import com.biz.big.persistence.IoListDao;
import com.biz.big.service.IoListService;

@Service("ioServiceV1")
public class IoListServiceImlV1  implements IoListService{

	
	@Autowired
	private IoListDao ioDao;



	@Override
	public List<IoListVO> selectAll() {
		return ioDao.selectAll();
	}

	@Override
	public IoListVO findByID(String id) {
		// TODO Auto-generated method stub
		return ioDao.findByID(id);
	}

	@Override
	public int insert(IoListVO vo) {
		// TODO Auto-generated method stub
		return ioDao.insert(vo);
	}
	@Override
	public int update(IoListVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getICode() {

			String retICode = "D001";
			try {
				
				String maxCode = ioDao.maxICode();
				String preCode = maxCode.substring(0,1);
				int icode = Integer.valueOf(maxCode.substring(1)) +1;
				retICode = String.format("%s%03d", preCode, icode);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			return retICode;
	}

}
