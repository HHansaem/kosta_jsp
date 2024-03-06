package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Member;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		RequestDispatcher dispatcher = null;
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(id);
		
		if(member == null) {  //id error
			request.setAttribute("err", "존재하지 않는 아이디 입니다");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} else if(member.getPassword().equals(password) == false) {  //password error
			request.setAttribute("err", "비밀번호가 틀립니다");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} else {  //success : session에 사용자 정보 저장
			session.setAttribute("user", member.getId());
			
			//자동로그인 체크하여 쿠키로 내려보내기
			String autologin = request.getParameter("autologin");
			System.out.println(autologin);
			Cookie autoLogin = new Cookie("autologin", autologin);
			autoLogin.setMaxAge(600);
			response.addCookie(autoLogin);
			
			if(autologin.equals("true")) {
				Cookie userId = new Cookie("id", id);
				userId.setMaxAge(600);
				Cookie userPassword = new Cookie("password", password);
				userPassword.setMaxAge(600);
				response.addCookie(userId);
				response.addCookie(userPassword);
			}
			
			dispatcher = request.getRequestDispatcher("makeAccount.jsp");
		}
		dispatcher.forward(request, response);
	}
}
