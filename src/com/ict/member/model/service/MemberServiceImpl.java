package com.ict.member.model.service;

import com.ict.member.model.dao.MemberDao;
import com.ict.member.model.vo.Member;
import static com.ict.common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

public class MemberServiceImpl implements MemberService {
	// MemberService�� ��üȭ(implements)�ϰԵǸ�
	// MemberService�������̽��� �ִ� �߻�޼ҵ带 ���⼭ ���� ���������־���Ѵ�.
	
	// MemberDao�޼ҵ� ȣ���ϱ����ؼ� �������� ���� �� ����
	private MemberDao mDao = new MemberDao();
	
	@Override
	public int insertMember(Member mem) {
		
		// Connection��ü�� �켱 ����� ����ϴµ�, ���̹�Ƽ�������� Connection��ü ��ſ� SqlSession��ü�� �����Ѵ�.
		
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
