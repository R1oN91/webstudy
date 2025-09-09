package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberRegisterAction
 */
@WebServlet("/member_register2.do")
public class MemberRegister2Action extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request,  //요청처리객체 
			HttpServletResponse response  //응답처리객체
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /member_register.do?name=홍길동&id=hong&pwd=1234&email=hong@naver.com&
		//                     gender=남자&hobby=독서&
		//                     friend=내친구1&friend=&friend=&blood=A&intro=나는 누구?
		
		//수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		String name		=	request.getParameter("name");
		//System.out.println(name);
		String id		=	request.getParameter("id");
		String pwd		=	request.getParameter("pwd");
		String email	=	request.getParameter("email");
		String gender	=	request.getParameter("gender");
		String blood	=	request.getParameter("blood");
		String intro	=	request.getParameter("intro");
		
		//parameter가 동일한 이름으로  여러개 있는경우->배열로 받는다
		String [] hobby_array  = request.getParameterValues("hobby");
		String [] friend_array = request.getParameterValues("friend");
		
		String hobby_list = "취미없음";
		//   member_register.do?name=홍길동&hobby=독서&hobby=영화
		//String []  hobby_array = {"독서","영화"};
		if(hobby_array != null){
			
			StringBuffer sb1 = new StringBuffer();
			for(String hobby : hobby_array) {
				sb1.append("[");
			   sb1.append(hobby);
			   sb1.append("]");
			} // [독서][영화]
			hobby_list = sb1.toString();
		}
		
	    //   member_register.do?friend=&friend=&friend=&blood=A
		//String [] friend_array ={"","",""};
		StringBuffer sb2 = new StringBuffer();
		for(String friend : friend_array) {
			sb2.append(friend);
			sb2.append(" ");
		} // "   "
		
		String friend_list = sb2.toString().trim(); // ""
		if(friend_list.isEmpty())// if(friend_list.equals(""))
			 friend_list = "친구없음";
		
//----[↑] : Business Logic ( Data 관리 로직 ) 		
	
		
		
//----[↓] : Presentation Logic ( 화면 로직 ) 
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		map.put("email", email);
		map.put("gender", gender);
		map.put("blood", blood);
		map.put("hobby_list", hobby_list);
		map.put("friend_list", friend_list);
		
		//request binding
		request.setAttribute("map", map);
		
	
		//출력은 result_member2.jsp 하라고 호출
	    RequestDispatcher disp = request.getRequestDispatcher("result_member2.jsp");
	    disp.forward(request, response);
		
		
		
		
	}

}
