<%@page import="javax.print.DocFlavor.STRING"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%!
    //!붙이면 JSP선언부가 됨.. 잘 사용하지는 않음
    //JSP에 쓸 변수 또는 메서드를 사용한다. 
    
    //변수를 선언함
	int n;
	
	//메소드 선언
	void info() {
		System.out.println("정보출력");
	}
     
    %>
    
    <%
    
   //Script Let
   //_jspService(HttpServletRequest request2. HttpServletResponse response)내의 영역
   int x=10;
    
    String ip = request.getRemoteAddr();
    
    System.out.println(application.getRealPath("/"));
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
나 JSP야!
<!--  JSP표현식-->
x=<%=x %>

</body>
</html>