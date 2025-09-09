<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   /* 
      EL : 조회용 표현언어
      JSP 내장객체 : pageContext, request, session, application
   */
   //               bindingAPI(data 연결)
   pageContext.setAttribute("msg", "pageScope 영역");
   request.setAttribute("msg", "requestScope 영역");
   session.setAttribute("msg", "sessionScope 영역");
   application.setAttribute("msg", "applicationScope 영역");
   application.setAttribute("msg", "applicationScope 영역");
   
   String name = "홍길동";
   //					key   , value <-map 형식
   request.setAttribute("name", name);
   
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

이름 : ${name}<br>
                  <!--${ 영역명.변수명 }  -->
pageContext 영역 내의 Data : ${ pageScope.msg } <br>
requestContext 영역 내의 Data : ${ requestScope.msg } <br>
sessionContext 영역 내의 Data : ${ sessionScope.msg } <br>
applicationContext 영역 내의 Data : ${ applicationScope.msg } <br>
 
<!-- EL에서 영역명을 생략하면 어떤 영역에  
	참조순서 : pageScope -> requestScope -> sessionScope->applicationScope--> 
 ???Scope : ${ msg } <br>

</body>
</html>