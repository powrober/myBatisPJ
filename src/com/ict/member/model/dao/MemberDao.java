package com.ict.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.ict.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession session, Member mem) {
		int result = session.insert("memberMapper.insertMember", mem);
		return result;
	}

}
