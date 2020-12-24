package com.biz.big.persistence;

import org.apache.ibatis.annotations.Select;

import com.biz.big.model.MemberVO;

public interface MemberDao extends GenericDao<MemberVO, String> {

	@Select(" SELECT COUNT(*) FROM tbl_member ")
	public int memberCount();



}
