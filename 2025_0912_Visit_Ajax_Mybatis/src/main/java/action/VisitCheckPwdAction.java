package action;

import java.io.IOException;

import dao.VisitDao;
import db.vo.VisitVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VisitCheckPwdAction
 */
@WebServlet("/visit/check_pwd.do")
public class VisitCheckPwdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /visit/check_pwd.do?idx=5&c_pwd=1234
		
		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		//1.파라메터 받기
		int idx			= Integer.parseInt(request.getParameter("idx"));
		String c_pwd 	= request.getParameter("c_pwd");
		
		//2.idx에 해당되는 게시물 1건 정보 가져오기
		VisitVo vo 		= VisitDao.getInstance().selectOne(idx);
		
		//3.비밀번호 비교
		boolean bResult = vo.getPwd().equals(c_pwd);
		
		//JSON형식  :  {"result":true} or {"result":false}
		
		String json = String.format("{\"result\":%b}",bResult);
		
		//응답처리
		response.setContentType("application/json; charset=utf-8;");
		response.getWriter().print(json);
		
		
	
		
		
		
		
		
		
		
	 
		

	}

}