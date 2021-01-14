package com.ict.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	public static SqlSession getSqlSession() {
		// SqlSession ��ü�� ��ȯ�ϱ� ���ؼ� ���� ����
		SqlSession session = null;
		
		/*
		 *  [ ���� ]
		 *  JDBCTemplate���� public static Connection getConnection()�� ���� �޼ҵ�
		 *  driver,sql���� ������ ����ִ� ������������ �ҷ��ͼ� �� �޼ҵ� �ȿ��� DBMS�� ����
		 *  [ mybatis ]
		 *  mybatis-config.xml ������ ���ؼ� driver,sql���Ӱ��� ������ �̸� �ۼ��ؼ� �ҷ�����
		 *  SqlSession��ü ������ �����ϴ�.
		 */
		
		InputStream stream;
		// Resources��� Ŭ������ ���̹�Ƽ�� ���̺귯������ �����ϴ� util�� Ŭ����
		// -> ���� Ŭ���� �н��� �ٸ� ��ġ�� �ִ� �ڿ��� �ε��ϴ� ���� �� �� ���� ���ִ� ����
		try {
			stream = Resources.getResourceAsStream("/mybatis-config.xml");
			
			// SqlSession�� ����� ���ؼ��� SqlSessionFactory���� openSession�� �̿��ؾ��Ѵ�.
			// SqlSessionFactory�� SqlSessionFactoryBuilder��� Ŭ������ build()�����ؼ� ������ �Ѵ�.
			// openSession(false)�� �ǹ̴� �ڵ� Ŀ���� ���� �ʰڴ�
			session = new SqlSessionFactoryBuilder().build(stream).openSession(false);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
		
		// commit(), rollback(), close() ...�� �������� �ʾƵ� �ȴ�.
		// Statement, PreparedStatement����, ResultSet 
		// why? SqlSession Ŭ���� �̹� commit, rollback, close �Լ��� �������ְ� �ִ�.
	}
}









