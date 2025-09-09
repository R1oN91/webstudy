package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register.do")
public class MemberRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// member_register.do?name=123&id=123&pwd=123&email=123%40123&
		// gender=남자&friend=&friend=&friend=&blood=A&
		// intro=asdf
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
		response.setContentType("text/html; charset=utf-8;");

		PrintWriter out = response.getWriter();

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
		out.print(sb.toString());

	}

}
