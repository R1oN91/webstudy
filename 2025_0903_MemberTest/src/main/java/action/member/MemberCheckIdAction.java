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
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// /member/check_id.do?mem_id=one
		
		//0.수신인코딩 설정
		request.setCharacterEncoding("utf-8");	
		
		//1.parameter 받기
		String mem_id = request.getParameter("mem_id");
		
		//2.mem_id를 이용해서 vo를 추출 한다.
		MemberVo vo = MemberDao.getInstance().selectOne(mem_id);
		
		//3.결과
		boolean bResult = (vo==null); //->vo에 같은 아이디가없으니 써도 되는 아이디다 라는 뜻. 
		
		
		//위에 한줄 짜리를 풀어서 길게 쓴거임. 같은거. 
		//boolean bResult = false;
		//if(vo==null)//아이디가 없으면 true
			//bResult=true;
		
		//4.결과 JSON생성
		//{"result":true} or {"resultl":false}
		String json = String.format("{\"result\":%b}", bResult);
		
		//5.응답처리
		response.setContentType("application/json; charset=utf-8;");
		response.getWriter().print(json);
		
	
	}

}