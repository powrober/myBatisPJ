package com.ict.member.model.service;

import com.ict.member.model.vo.Member;

public interface MemberService {
	
	// �������̽��� �����Ǵ� ��� �޼ҵ�� ���� abstract(�߻�)�޼ҵ常 ���縦 �Ѵ�.
	// public abstract�� ������ �����ϴ�.
	
	// ȸ������ ó���� ����
	int insertMember(Member mem);
}
