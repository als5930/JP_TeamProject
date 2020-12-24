package com.biz.big.service;

import com.biz.big.model.IoListVO;
import com.biz.big.model.MemberVO;

public interface MemberService extends GenericService<MemberVO, String> {
	
	public MemberVO login(MemberVO loginVO);

}
