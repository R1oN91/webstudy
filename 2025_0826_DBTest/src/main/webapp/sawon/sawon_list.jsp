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
 	<hr>
 	<h2>::사원목록::</h2>
 	<hr>
 	
 	<table border="1" width="500">
 		<tr>
 			<th>사번</th>
 			<th>사원이름</th>
 			<th>성별</th>
 			<th>deptno</th>
 			<th>직책</th>
 			<th>입사날</th>
 			<th>메니저</th>
 			<th>월급</th>
 			<th>입사년도</th>
 			<th>입사월</th>
 			<th>입사계절</th>
 		</tr>
 		<c:forEach var="vo" items="${requestScope.list }">
 			<tr>
 			 	<td>${vo.sabun}</td>
 			 	<td>${vo.saname}</td>
 			 	<td>${vo.sasex}</td>
 			 	<td>${vo.deptno}</td>
 			 	<td>${vo.sajob}</td>
 			 	<td>${vo.sahire}</td>
 			 	<td>${vo.samgr}</td>
 			 	<td>${vo.sapay}</td>
 			 	<td>${vo.hire_year}</td>
 			 	<td>${vo.hire_month}</td>
 			 	<td>${vo.hire_season}</td>
 			</tr>
 		
 		</c:forEach>
 		
 		
 	 </table>
</body>
</html>

