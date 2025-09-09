<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
     //Java Code
     //클라이언트에게 재접속에 대한 정보를 넘겨준다. 
     
     System.out.println("--a.jsp왔다감--");
     
    response.sendRedirect("b.jsp");
    
    
    
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나 a.jsp야!!
</body>
</html>