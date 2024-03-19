package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import service.LoginService;
import service.LoginServiceImpl;

/**
 * Servlet implementation class NaverLogin
 */
@WebServlet("/naver")
public class NaverLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NaverLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		
		try {
			LoginService loginService = new LoginServiceImpl();
 			UserInfo userInfo = loginService.naverLogin(code, state);
 			request.getSession().setAttribute("userInfo", userInfo);
 			request.getRequestDispatcher("index.jsp").forward(request, response);
 			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "네이버 로그인 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
