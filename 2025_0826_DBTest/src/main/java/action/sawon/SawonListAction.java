package action.sawon;

import java.io.IOException;
import java.util.List;

import dao.SawonDao;
import db.vo.SawonViewVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SawonListAction
 */
@WebServlet("/sawon/list.do")
public class SawonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//사원 목록 가져오기
		List<SawonViewVo> list  = SawonDao.getInstance().selectList();

		//request binding
		request.setAttribute("list", list);
		
		//dispatcher(forward)
		String forward_page = "sawon_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
