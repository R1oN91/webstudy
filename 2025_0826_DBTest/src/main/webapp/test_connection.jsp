<%@page import="org.apache.commons.collections.bag.SynchronizedSortedBag"%>
<%@page import="java.sql.Connection"%>
<%@page import="service.DBService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
    <%!int count = 0;%>
   
    <%
       // DBServive dbService = new DBServive();
           DBService dbService =  DBService.getInstance();
           
           
           Connection conn = dbService.getConnection();
           
           count++;
          
           System.out.printf("---[%d] success connection---\n",count);
           
           conn.close();
       %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>