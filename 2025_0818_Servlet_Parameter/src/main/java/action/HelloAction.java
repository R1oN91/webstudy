package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class HelloAction
 */
//http://localhost:8080/2025_0818_Servlet_Parameter/Hello.do

@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, // 요청처리객체(client의 정보관리)
			HttpServletResponse response// 응답처리객체(client에게 응답:client정보를 알고있다.)
	) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// ?는query라고 함.
		// 전달인자(parameter 인수인자)
		// /hello.do?natio=kor&time=morning
		// /hello.do?natio=eng&time=morning
		// /hello.do?natio=jpn&time=morning
		// /hello.do?natio=chn&time=morning
		// /hello.do?natio=ger&time=morning
		// /hello.do?natio=fra&time=morning
		// /hello.do

		String nation = request.getParameter("nation");
		String time = request.getParameter("time");

		System.out.println(nation);
		System.out.println(time);
		if (nation == null)
			nation = "kor";

		String nation_name = "미지정";
		String greeting = "뭘까?";

		if (nation.equals("kor")) {

			nation_name = "한국";
			// greeting = "안녕하세요";
			if (time.equals("morning")) {
				// System.out.println("좋은아침입니다");
				greeting = "좋은아침입니다";
			} else if (time.equals("afternoon")) {
				// System.out.println("좋은하루입니다");
				greeting = "좋은하루입니다";
			} else if (time.equals("evening")) {
				// System.out.println("좋은 저녁입니다. ");
				greeting = "좋은저녁입니다";
			}

		} else if (nation.equals("eng")) {
			nation_name = "미국/영국";
			if (time.equals("morning")) {
				greeting = "good morning";
			} else if (time.equals("afternoon")) {
				greeting = "good afternoon";
			} else if (time.equals("evening")) {
				greeting = "good evening";
			}
		
		} else if (nation.equals("jpn")) {
			nation_name = "일본";
			if (time.equals("morning")) {
				greeting = "오하요";
			} else if (time.equals("afternoon")) {
				greeting = "곤니치와";
			} else if (time.equals("evening")) {
				greeting = "곰방와";
			}
		}

		else if (nation.equals("chn")) {

			nation_name = "중국";
			greeting = "니하오";

		} else if (nation.equals("ger")) {

			nation_name = "독일";
			greeting = "구텐탁";

		} else if (nation.equals("fra")) {

			nation_name = "프랑스";
			greeting = "봉주르";
		}

		// 응답처리
		// mime-type : image/jpg image/tiff
		// text/html text /xml
		// application/json
		response.setContentType("text/html; charset=utf-8;");

		PrintWriter out = response.getWriter();// 출력스트림을 얻어온다
		// 서블릿내에서 동적으로 HTML생성->전송한다
		out.print("<html>");
		out.print("<body>");
		out.print(String.format("<h2>[%s] 어 인사말</h2>", nation_name));
		out.print(String.format("<h4>%s</h4>", greeting));
		out.print("<br>");
		out.print("<a href='hello.html'>다시하기</a>");
		out.print("</body>");
		out.print("</html>");

	}

}
