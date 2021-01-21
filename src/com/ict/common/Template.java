package com.ict.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	public static SqlSession getSqlSession() {
		// SqlSession 객체를 반환하기 위해서 변수 선언
		SqlSession session = null;
		
		/*
		 *  [ 기존 ]
		 *  JDBCTemplate에서 public static Connection getConnection()과 같은 메소드
		 *  driver,sql접속 정보가 들어있는 설정정보들을 불러와서 이 메소드 안에서 DBMS와 연결
		 *  [ mybatis ]
		 *  mybatis-config.xml 파일을 통해서 driver,sql접속관련 정보를 미리 작성해서 불러오면
		 *  SqlSession객체 생성이 가능하다.
		 */
		InputStream stream;
		// Resources라는 클래스는 마이바티스 라이브러리에서 제공하는 util성 클래스
		// -> 현재 클래스 패스와 다른 위치에 있는 자원을 로드하는 것을 좀 더 쉽게 해주는 역할
		try {
			stream = Resources.getResourceAsStream("/mybatis-config.xml");
			
			// SqlSession을 만들기 위해서는 SqlSessionFactory에서 openSession을 이용해야한다.
			// SqlSessionFactory는 SqlSessionFactoryBuilder라는 클래스의 build()를통해서 생성을 한다.
			// openSession(false)의 의미는 자동 커밋을 하지 않겠다
			session = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
		
		// commit(),rollback(),close() ...은 생성하지 않아도 된다.
		// Statement, PreparedStatement관련, ResultSet
		// Why? SqlSession클래스 이미 commit,rollback,close 함수를 제공해주고있다.
	}
}









