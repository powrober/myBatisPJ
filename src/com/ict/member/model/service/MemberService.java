package com.ict.member.model.service;

import com.ict.member.model.vo.Member;

public interface MemberService {
	
	// 인터페이스에 생성되는 모든 메소드는 전부 abstract(추상)메소드만 존재를 한다.
	// public abstract는 생략이 가능하다.
	
	/**
	 * 회원조회
	 * @author 유승제 
	 * @param mem 멤버객체
	 * @return
	 */
	Member selectMember(Member mem);
	
	// 회원가입 처리용 서비스
	int insertMember(Member mem);
	
	/**
	 * 회원정보수정
	 * @param mem(비밀번호, 이메일, 전화번호, 주소)
	 * @return
	 */
	int updateMember(Member mem);
	
	/**
	 * 회원정보삭제
	 * @param mem
	 * @return
	 */
	int deleteMember(Member mem);
	
}
