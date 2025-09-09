package action;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.PersonVo;

/**
 * Servlet implementation class PersonListAction
 */
@WebServlet("/person/list.do")
public class PersonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String webPath = "/";
		ServletContext application = request.getServletContext(); 
		// 웹경로를 이용해서 절대경로 구하기
		String absPath = application.getRealPath(webPath);
		//System.out.println(absPath);
		
		FileReader fr = null;
		List<PersonVo> list = new ArrayList<PersonVo>();
		
		try {
			fr = new FileReader(absPath + "person.xml");
			//XML Parsing(해석)
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(fr);
			
			Element root = doc.getRootElement();
			
			List<Element> person_list = root.getChildren("person");
			
			
			for(Element person : person_list) {
				
				String name		= person.getChildText("name");
				Element nameElement = person.getChild("name");
				//name 요소의 nickname속성값 얻어오기
				String nickname	= nameElement.getAttributeValue("nickname");
				
				int age			= 0;
				
				 try {
					age= Integer.parseInt(person.getChildText("age"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				 
				 String tel = person.getChildText("tel");
				 String hometel = person.getChild("tel").getAttributeValue("hometel");
			
				 PersonVo vo = new PersonVo(name, nickname, age, tel, hometel);
				 list.add(vo);
			
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			if(fr!=null) fr.close();
			
		}
		
		//request binding
		request.setAttribute("list", list);
		
		

		//dispatcher(forward)
		String forward_page = "person_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}