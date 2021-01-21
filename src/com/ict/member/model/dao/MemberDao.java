package com.ict.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.ict.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession session, Member mem) {
		int result = session.insert("memberMapper.insertMember", mem);
		return result;
	}

	public Member selectMember(SqlSession session, Member mem) {
		Member loginUser = session.selectOne("memberMapper.loginMember",mem);
		return loginUser;
	}

	public int updateMember(SqlSession session, Member mem) {
		int result = session.update("memberMapper.updateMember", mem);
		return result;
	}

	public int deleteMember(SqlSession session, Member mem) {
		int result = session.delete("memberMapper.deleteMember",mem);
		return result;
	}

	
}
