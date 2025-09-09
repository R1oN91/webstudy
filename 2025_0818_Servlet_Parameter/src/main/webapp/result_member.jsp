<%@page import="java.io.PrintWriter"%>
<%@page import="javax.script.ScriptContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //Script Let (Java Code를 작성할 수 있다)
    // 수신인코딩 설정
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		// System.out.println(name);
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String blood = request.getParameter("blood");
		String intro = request.getParameter("intro");

		// parameter가 동일한 이름으로 여러개 있는경우 배열로 받는다.
		String[] hobby_array = request.getParameterValues("hobby");
		String[] friend_array = request.getParameterValues("friend");

		String hobby_list = "취미없음";
		// member_register.do?name=홍길동&hobby=독서&hobby=영화
		// String[]hobby_array = {"독서","영화"};
		if (hobby_array != null) {
		StringBuffer sb1 = new StringBuffer();
			for (String hobby : hobby_array) {
				sb1.append("[");
				sb1.append(hobby);
				sb1.append("]");
			}//[독서][영화]
			
			hobby_list = sb1.toString();
		}
		
		//member_register.do?friend=&friend=&friend=&blood=A
		//String[]friend_array = {"","",""};
		StringBuffer sb2 = new StringBuffer();
		for(String friend : friend_array) {
			sb2.append("[");
			sb2.append(friend);
			sb2.append("]");
			
		}//"    "

		String friend_list = sb2.toString().trim();//""
		if(friend_list.isEmpty()) // if(friend_list.equals(""))
			friend_list = "친구없음";
		//=====================[↑Business Logic     (Data 관리하는 로직)↑]=========================== 
		
		//model1
		
		//=====================[↓Presentation Logic (화면에 보이는 로직 )↑]===========================
		// 응답
		/* response.setContentType("text/html; charset=utf-8;");

		PrintWriter out1 = response.getWriter();

		// Html생성 -> StringBuffer에 누적

		StringBuffer sb = new StringBuffer();

		sb.append("<html>");
		sb.append("<body>");
		sb.append("<table width='400' border='1'>");
		sb.append("<caption>::::회원 정보::::</caption>");
		sb.append(String.format("<tr><th>이름</th><td>%s</td></tr>", name));
		sb.append(String.format("<tr><th>ID</th><td>%s</td></tr>", id));
		sb.append(String.format("<tr><th>PW</th><td>%s</td></tr>", pwd));
		sb.append(String.format("<tr><th>이메일</th><td>%s</td></tr>", email));
		sb.append(String.format("<tr><th>성별</th><td>%s</td></tr>", gender));
		sb.append(String.format("<tr><th>혈액형</th><td>%s</td></tr>", blood));
		sb.append(String.format("<tr><th>취미</th><td>%s</td></tr>", hobby_list));
		sb.append(String.format("<tr><th>친구</th><td>%s</td></tr>", friend_list));
		sb.append(String.format("<tr><th>자기소개</th><td>%s</td></tr>", intro));
		sb.append("<tr><td colspan='2' align='center'><a href='input_member.html'>다시하기</a></td></tr>");
		sb.append("</body>");
		sb.append("</html>");

		// 응답(전송)
		out1.print(sb.toString());

     */
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width = "400" border="1">
		<caption>:::회원정보:::</caption>
		
		<tr>
			<th>이름</th>
			<td><%= name %></td>
		</tr>
<!---------------------  -->
		<tr>
			<th>아이디</th>
			<td><%= id %></td>
		</tr>
<!---------------------  -->		
		<tr>
			<th>비밀번호</th>
			<td><%= pwd %></td>
		</tr>
		
<!---------------------  -->		
		<tr>
			<th>이메일</th>
			<td><%= email %></td>
		</tr>
		
<!---------------------  -->		
		<tr>
			<th>성별</th>
			<td><%= gender %></td>
		</tr>
		
		
<!---------------------  -->
		<tr>
			<th>혈액형</th>
			<td><%= blood %></td>
		</tr>
		
		
<!---------------------  -->
		<tr>
			<th>취미</th>
			<td><%= hobby_list %></td>
		</tr>
		
		
<!---------------------  -->
		<tr>
			<th>친구</th>
			<td><%= friend_list %></td>
		</tr>
		
		
<!---------------------  -->
		<tr>
			<th>자기소개</th>
			<td><%= intro %></td>
		</tr>
		
		
		
<!---------------------  -->
		<tr>
			<td colspan= "2" align="center"><a href='input_member.html'>다시하기</a></td>
		</tr>
<!---------------------  -->	
	</table>

</body>
</html>