<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 	
		* ibatis VS mybatis
		1. iBatis는 JDK 1.4이상, myBatis는 JDK 1.5이상 사용이 가능하다. 
		2. 패키지 구조 변경
		 - iBatis : com.ibatis.*
		 - myBatis : org.apache.ibatis.*
		3. 사용 용어 변경
		 - SqlMapConfig -> Cofiguration
		 - sqlMap -> Mapper
		 - resultClass -> resultType
		4. 동적쿼리 지원 **
		 - 쿼리문 작성시 if, choose, trim, foreach 문을 지원함
		5. 자바 어노테이션 지원 
	--> 
	
	<!-- 
	* 환경설정
	 	
 	1. workspace 셋팅 먼저
 	
 	2. jstl, ojdb6 라이브러리 추가
 	
 	3. 마이바티스 사용 위해 mybatis 관련 라이브러리도 추가
 		- 마이바티스 한국 사이트 들어가서 즐겨찾기 추가
 		- 시작하기 -> mybatis-x.x.x.jar 클릭 -> github로 이동 -> 3.4.6 버전 찾기
 		  (https://github.com/mybatis/mybatis-3/releases)
 	
 	4. New - Source Folder 추가 : resources
 	
 	5. resources 폴더 안에 mybatis-config.xml 생성
 	
 	   >> mybatis-config.xml 설정 파일 생성 시 DTD(문서타입정의) 설정 해두면, mybatis 관련 xml 파일 설정할 때 재사용할 수 있음
 	   
 	   * DTD :  XML 문서의 구조 및 해당 문서에서 사용할 수 있는 적법한 요소와 속성을 정의
 	            이 문서가 유효한지 유효성 검사도 됨
 	   
 	   >> DTD 설정하기
 		  1) Window - Preferences - XML - XML Catalog - User Specified Entries - Add
 			- Config
 			  Location : http://mybatis.org/dtd/mybatis-3-config.dtd => System ID로 사용
 			  Key type : Public ID
 			  Key		 : -//mybatis.org//DTD Config 3.0//EN
 			  
 		    - Mapper
 			  Location : http://mybatis.org/dtd/mybatis-3-mapper.dtd => System ID로 사용
 			  Key type : Public ID
 			  Key		 : -//mybatis.org//DTD Mapper 3.0//EN
 			  
 	   >> dtd 파일로 부터 xml 파일 생성
 	   	  1) resources 오른쪽 버튼 - Next - XML File - Next
 	   	  2) Create XML file from a DTD File - Next
 	   	  3) Select XML Catalog entry - 해당 entry 선택 - 생성
	 -->
	 
	<!-- jsp/servlet에서 request.getContextPath()를 작성하게되면 ContextPath(프로젝트명)을 가져올 수 있다. -->
	
	<!-- ContextPath명을 매번 쓰기 귀찮으니 c:set을 이용해서 application객체에 ContextPath경로를 contextPath라는 변수에 담아서 사용하자 -->
	<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application" />
	<%-- <a href="${ contextPath }/WEB-INF/views/main/main.jsp">메인으로</a> --%>
	 
	<!-- 
		WEB-INF 폴더는 WAS서버가 관리하는 폴더이기 때문에 views폴더가 WEB-INF안에 있는 경우 
		Web Server를 거치는 방식인 url창을 통해 접근할 수 없고
		직접 WAS서버에서 경로를 이동하는 방식인 forward를 통해서만 접근할 수 있다.
	 --> 
	<jsp:forward page="WEB-INF/views/main/main.jsp"/>
	 
</body>
</html>