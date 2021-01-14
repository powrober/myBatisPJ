package com.ict.member.model.service;

import com.ict.member.model.vo.Member;

public interface MemberService {
	
	// 인터페이스에 생성되는 모든 메소드는 전부 abstract(추상)메소드만 존재를 한다.
	// public abstract는 생략이 가능하다.
	
	// 회원가입 처리용 서비스
	int insertMember(Member mem);
}
