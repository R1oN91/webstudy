<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
     	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("name","홍길동");
    	map.put("age",30);
    	map.put("gender","남자");
    	map.put("eye_left",1.0);
    	map.put("eye_right",0.8);
    	map.put("married","true");
    	
    	
    	//왜? 	: EL사용하려고
    	pageContext.setAttribute("map", map);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:<%=map.get("name") %><br>
이름:${pageScope.map.name} <br>
<!--dot표기법  -->
나이:${map.age}<br>
<!-- square bracket -->
성별:${map['gender']}<br>
기혼:${map["married"]}<br>

시력:(좌/우) :${map.eye_left }/${map.eye_right }<br>


</body>
</html>