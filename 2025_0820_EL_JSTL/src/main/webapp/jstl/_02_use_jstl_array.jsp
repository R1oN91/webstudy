<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <!-- JSTL Core -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <%
    	String [] fruit_array = {"사과","참외","수박","딸기","포도"};
    	
    	//EL사용하려고...
    	pageContext.setAttribute("fruit_array", fruit_array);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
		과일목록
	<hr>
	
	<ul>
		<%-- <c:forEach var="fruit" items="${배열 또는 컬렉션}"> --%>
		
		<!-- for(String fruit : fruit_array)와 동일함 -->
		<c:forEach var="fruit" items="${fruit_array }">
		<li>${fruit }</li>
		
		</c:forEach>
	</ul>
</body>
</html>