package action.member;

import java.io.IOException;

import dao.MemberDao;
import db.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberInsertAction
 */
@WebServlet("/member/insert.do")
public class MemberInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		//0.수신 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.parameter받기
		String mem_name		=	request.getParameter("mem_name");
		String mem_id		=	request.getParameter("mem_id");
		String mem_pwd		=	request.getParameter("mem_pwd");
		String mem_email	=	request.getParameter("mem_email");
		String mem_zipcode	=	request.getParameter("mem_zipcode");
		String mem_addr		=	request.getParameter("mem_addr");
		
		//2. ip받기
		String mem_ip		= 	request.getRemoteAddr();
		
		//3. MemberVo 포장
		MemberVo vo = new MemberVo(mem_name,mem_id,mem_pwd,mem_email,mem_zipcode,mem_addr,mem_ip,"일반");
		
		//4. DB insert(도아주는 얘는 Dao)
		int res	=	MemberDao.getInstance().insert(vo);
		
		//5. 메인페이지(목록)이동
		response.sendRedirect("list.do");
		
		


	}

}