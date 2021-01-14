<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- jsp/servlet에서 request.getContextPath()를 작성하게되면 ContextPath(프로젝트명)을 가져올 수 있다. -->

<!-- ContextPath명을 매번 쓰기 귀찮으니 c:set을 이용하여 application 객체에 ContextPath경로를 contextPath라는 변수에 담아 사용 -->
	<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application"/>
	<%-- <a href="${ contextPath }/WEB-INF/views/main/main.jsp">메인으로</a> --%>

<!-- 
	WEB-INF 폴더는 WAS 서버가 관리하는 폴더이기 때문에 views폴더가 WEB-INF안에 있는 경우
	Web Server를 거치는 방식인 url창을 통해 접근할 수 없고
	직업 WAS서버레서 경로를 이동하는 방식인 forward를 통해서만 접근할 수 있다.
 -->

<jsp:forward page="WEB-INF/views/main/main.jsp"/>


</body>
</html>