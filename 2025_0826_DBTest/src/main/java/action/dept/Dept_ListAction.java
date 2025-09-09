package action.dept;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.DeptDao;
import db.vo.DeptVo;

/**
 * Servlet implementation class Dept_ListAction
 */
@WebServlet("/dept/list.do")
public class Dept_ListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 부서목록 가져오기
		List<DeptVo> list = DeptDao.getInstance().selectList();

		// request binding
		request.setAttribute("list", list);

		// dispatcher(forward) 프레젠테이션 로직.
		String forward_page = "dept_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}
