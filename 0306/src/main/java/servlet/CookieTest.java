package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest
 */
@WebServlet("/cookie")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("myproduct", "shortdress");  //(key, value)
		cookie.setMaxAge(600);  //만료시간 (최대 유지시간) 설정 -> 600초 후 쿠키 자동 삭제
		response.addCookie(cookie);  //쿠키를 웹 브라우저(클라이언트)에 전송
		request.getRequestDispatcher("cookieTest.jsp").forward(request, response);  //요청을 해당 페이지로 포워드
	}

}
