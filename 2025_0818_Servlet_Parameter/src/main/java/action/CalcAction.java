package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CalcAction
 */
@WebServlet("/calc.do")
public class CalcAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest request,//Client -> Server 넘어온정보처리 객체
			HttpServletResponse response//Server ->Client응답처리하는 객체
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//calc.do?su1=11&su2=6
		
		//parameter(su1,su2)받기 :  모든 파라메터는 String으로 받는다. 
		//							(파일업로드제외)

		String str_su1 =  request.getParameter("su1");
		String str_su2 =  request.getParameter("su2");
		
		//문자열 ->정수변환
		int su1 = Integer.parseInt(str_su1);
		int su2 = Integer.parseInt(str_su2);
		
		//응답처리					 mime-type; 문자셋
		response.setContentType("text/html;"); 
		PrintWriter out = response.getWriter();
		//
		//Server -> Client로 내용 전송(응답)
		out.print("<html>");
		out.print("<body>");
		out.print("<h3>:::계산결과:::</h3>");
		
		out.printf("%d + %d= %d<br>",su1,su2,(su1+su2));
		out.printf("%d - %d= %d<br>",su1,su2,(su1-su2));
		out.printf("%d * %d= %d<br>",su1,su2,(su1*su2));
		
		if(su2==0) {
			out.print("<font color='red'>0으로는 나눌수가 없습니다<br></font>");
		}else {
			
			out.printf("%d / %d = %d<br>", su1,su2,(su1/su2));
			out.printf("%d %% %d = %d<br>", su1,su2,(su1%su2));
		
			
		}
		
		
		
		out.print("<a href='calc.html'>다시하기</a>");
		out.print("</body>");
		out.print("</html>");
		
         }
		
	}


