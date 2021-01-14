package com.ict.member.model.service;

import com.ict.member.model.dao.MemberDao;
import com.ict.member.model.vo.Member;
import static com.ict.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

public class MemberServiceImpl implements MemberService {
	// MemberService를 실체화(implements)하게되면
	// MemberService인터페이스에 있는 추상메소드를 여기서 전부 구현시켜주어야한다.
	
	// MemberDao메소드 호출하기위해서 참조변수 선언 및 생성
	private MemberDao mDao = new MemberDao();
	
	@Override
	public int insertMember(Member mem) {
		
		// Connection객체를 우선 만들어 줘야하는데, 마이바티스에서는 Connection객체 대신에 SqlSession객체를 생성한다.
		
		SqlSession session = getSqlSession();
		
		int result = mDao.insertMember(session,mem);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		
		return result;
	}

}
