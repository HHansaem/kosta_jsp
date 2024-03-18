package controlloer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.UserInfo;
import service.KakaoLoginService;
import service.KakaoLoginServiceImpl;

/**
 * Servlet implementation class Oauth
 */
@WebServlet("/kakao")
public class KakaoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String code = request.getParameter("code");
		System.out.println(code);
		try {
			KakaoLoginService kakao = new KakaoLoginServiceImpl();
			UserInfo userInfo = kakao.KakaoLogin(code);
			HttpSession session = request.getSession();
			session.setAttribute("nickname", userInfo.getNickname());
			session.setAttribute("thumbnail", userInfo.getThumbnail_image());
			response.sendRedirect("main");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
