package action.member;

import java.io.IOException;

import dao.MemberDao;
import db.vo.MemberVo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member/modify.do")
public class MemberModifyAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        // 1. 수신 인코딩 설정
        request.setCharacterEncoding("utf-8");

        // 2. parameter 받기
        int mem_idx 		= Integer.parseInt(request.getParameter("mem_idx"));
        String mem_name 	= request.getParameter("mem_name");
        String mem_id 		= request.getParameter("mem_id");
        String mem_pwd 		= request.getParameter("mem_pwd");
        String mem_email 	= request.getParameter("mem_email");
        String mem_zipcode 	= request.getParameter("mem_zipcode");
        String mem_addr 	= request.getParameter("mem_addr");
        String mem_grade 	= request.getParameter("mem_grade");

        // 3. ip받기
        String mem_ip = request.getRemoteAddr();

        // 4. MemberVo로 포장
        MemberVo vo = new MemberVo(mem_idx, mem_name, mem_id, mem_pwd, mem_email, mem_zipcode, mem_addr, mem_ip, mem_grade);

        // 5. DB update
        int res = MemberDao.getInstance().update(vo);

        // 6. 메인화면(목록보기) 이동
        response.sendRedirect("list.do");
    }
}
