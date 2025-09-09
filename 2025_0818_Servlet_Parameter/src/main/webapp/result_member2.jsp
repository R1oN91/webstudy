<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table width="400" border="1">
     <caption>::::회원정보::::</caption>
     
     <tr>
        <th>이름</th>
        <td>${map.name }</td>
     </tr>
     <tr>
        <th>아이디</th>
        <td>${ map.id }</td>
     </tr>
     <tr>
        <th>비밀번호</th>
        <td>${ map.pwd }</td>
     </tr>
     <tr>
        <th>성별</th>
        <td>${ map.gender }</td>
     </tr>
     <tr>
        <th>혈액형</th>
        <td>${ map.blood }</td>
     </tr>
     <tr>
        <th>이메일</th>
        <td>${ map.email }</td>
     </tr>
     <tr>
        <th>취미</th>
        <td>${ map.hobby_list }</td>
     </tr>
     <tr>
        <th>친구</th>
        <td>${ map.friend_list }</td>
     </tr>
     <tr>
        <th>자기소개</th>
        <td>${ map.intro }</td>
     </tr>
     
     
     
     <tr>
        <td colspan="2" align="center"><a href='input_member.html'>다시하기</a></td>
     </tr>
     
  </table>


</body>
</html>






