package action.member;

import java.io.IOException;

import dao.MemberDao;
import db.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do")
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// /member/login.do?mem_id=hong&mem_pwd=123456
		
		
		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.Parameter 받기
		String mem_id	=	request.getParameter("mem_id");
		String mem_pwd	=	request.getParameter("mem_pwd");
		
		//2.mem_id 이용 selectOne 객체정보 얻어오기
		MemberVo user	=	MemberDao.getInstance().selectOne(mem_id);
		
		//아이디가 틀린경우
		if(user==null) {
			
			response.sendRedirect("login_form.do?reason=fail_id");
			
		    return;
		}
		
		//비밀번호가 틀린경우
		System.out.println("----------------------------");
		System.out.println(user.getMem_pwd());
		System.out.println(mem_pwd);
		System.out.println(user.getMem_pwd().equals(mem_pwd));
		System.out.println("----------------------------");
		
		if(user.getMem_pwd().equals(mem_pwd)==false) {
			
			response.sendRedirect("login_form.do?reason=fail_pwd&mem_id=" + mem_id);
			
		    return;
		}
		
		//정상적인 로그인 처리. 
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		//메인화면으로 가라
		response.sendRedirect("list.do");
		
			
	}

}