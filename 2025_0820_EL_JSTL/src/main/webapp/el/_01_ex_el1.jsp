<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

/*
	EL(Expression Language):표현언어
		1. 문자/숫자/boolean/null/연산자 표현한다. 
		2. 각 scope내에 또는 parameter(전달파라미터)에 저장된 값만 표현 할 수 있다. 
		3. 형식
		   	${ 표현식 }
		
*/
%>

<!-- HTML주석 
	 	EL형식 : \${ }
	-->
	
<%-- JSP주석 : JSP->JSP서블릿(JAVA) 변환시 안 넘어간다 --%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
	<h4>EL연산자(산술연산자)</h4>
<hr>
	\${3+1} => ${3+1} <br>
	\${3-1} => ${3-1} <br>
	\${3*2} => ${3*2} <br>
	\${10/3}  or <%--or ${10 div 3 }--%> => ${10/3}<br>
	\${ 10%3 } => ${ 10%3 } <br> ${10 mod 3} <br>

<hr>
	<h4>EL연산자(관계)</h4>
<hr>
<!--gr : greater than  -->
	\${3>2}	=> ${3>2} or ${ 3 gt 2 }<br>
	<!--ge : greater equal -->
	\${3>=2} => ${3>=2} or ${ 3 ge 2 }<br>
	<!--lt : less than  -->
	\${3<2} => ${3<2} or ${3 lt 2 }<br>
	<!-- le : less equal -->
	\${3<=2} => ${3<=2} or ${3 le 2 }<br>
	<!-- eq : equal -->
	\${3==2} => ${3==2} or ${3 eq 2 }<br>
	<!-- ne : not equal -->
	\${3!=2} => ${3!=2} or <%-- ${3 ne 2 } --%><br>
	
<hr>
<h4>EL연산자(3항연산자 및 empty)</h4>
<hr> 
\${3>=0 ? '양수':'음수'} => ${(3>=0)?'양수':'음수'} <br>

<!-- el1. jsp?msg=안녕  -->
전달 메세지 : ${ (empty param.msg) ? '전달 메세지 없음' : param.msg } <br>
 	



</body>
</html>