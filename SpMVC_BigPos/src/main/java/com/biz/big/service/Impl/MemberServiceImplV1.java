package com.biz.big.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.big.model.MemberVO;
import com.biz.big.persistence.MemberDao;
import com.biz.big.service.MemberService;

@Service(value = "memServiceV1")
public class MemberServiceImplV1 implements MemberService {

	@Autowired
	private MemberDao memDao;

	@Override
	public List<MemberVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO findByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int insert(MemberVO memVO) {

		
		int count = memDao.memberCount();

		
		if (count > 0) {
			memVO.setM_roll("USER");
		} else {
			memVO.setM_roll("ADMIN");
		}
		int ret = memDao.insert(memVO);
		return ret;
	}

	@Override
	public int update(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public MemberVO login(MemberVO loginVO) {

		MemberVO memVO = memDao.findByID(loginVO.getM_userid());
		if (memVO != null) {
			if (!loginVO.getM_password().equals(memVO.getM_password())) {
				memVO.setM_roll("P_FAIL");
				memVO.setM_userid("P_FAIL");
			}
		}
		return memVO;
	}

}
