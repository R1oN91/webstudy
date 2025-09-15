package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TestController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String msg = request.getParameter("msg");
		//������� �̵��� �� �̸��� ModelAndView ��ü�� ���
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/jsp/test.jsp");//���̸�
		mv.addObject("msg",msg);
		return mv;
	}

}
