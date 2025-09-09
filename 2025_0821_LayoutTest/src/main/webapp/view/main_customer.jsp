<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/mainmenu.css">
    <link rel="stylesheet" href="../css/submenu.css">
</head>
<body>
    <div id="main-box">
        <div id="header">
        	<%@include file="header/header.jsp" %>
        </div>
        
        <!-- 고객센터소개+ 서브메뉴 -->
        <div id="aside-left">
        	<%@include file="menu/submenu_customer.jsp" %>
        </div>
        
        <div id="content">
       
        <c:if test="${(empty param.menu)  or	(param.menu eq'infor') }">
        <%@include file="content/customer/infor.jsp" %>
        </c:if>
        
        <c:if test="${		(param.menu eq'qa') }">
        <%@include file="content/customer/qa.jsp" %>
        </c:if>
        
        <c:if test="${ 	(param.menu eq'reference') }">
        <%@include file="content/customer/reference.jsp" %>
        </c:if>
       
       
        
       
        
        
      
        </div>
        <div id="footer">
        <%@include file="footer/footer.jsp"%>
        </div>
    </div>
</body>
</html>
