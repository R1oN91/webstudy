<%@page import="java.util.ArrayList"%>
<%@page import="vo.PersonVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
    
    <%
    	List<PersonVo> p_list = new ArrayList<PersonVo>();
    	p_list.add(new PersonVo("일길동",21,"서울시 관악구 봉천1동"));
    	p_list.add(new PersonVo("이길동",22,"서울시 관악구 봉천3동"));
    	p_list.add(new PersonVo("삼길동",23,"서울시 관악구 봉천2동"));
    	p_list.add(new PersonVo("사길동",26,"서울시 관악구 봉천4동"));
    	p_list.add(new PersonVo("오길동",25,"서울시 관악구 봉천5동"));
  
    	pageContext.setAttribute("p_list", p_list);
    	%>
 
 
 <table width="600" border="1">
 	<!-- title  -->
	  <tr>
	  	<th>순번</th>
	  	<th>이름</th>
	  	<th>나이</th>
	  	<th>주소</th>
	  </tr>
	  
	  <!-- data -->
	  <!-- for(PersonVo p : p_list)동일 -->
	  <c:forEach var="p" items="${p_list }" varStatus="i">
	   	<tr>
	   		<td>${i.count }</td>
	   		<td>${p.name }</td><!-- dot표기법 -->
	   		<td>${p.age } (${p['age'] })</td> <!-- square bracket -->
	   		<td>${p.addr }(${p.getAddr() })</td>	<!-- getter call -->
	   	
	   	</tr>
	  
	  
	  
	  
	  
	  
	  </c:forEach>
	  
  
</table>


    