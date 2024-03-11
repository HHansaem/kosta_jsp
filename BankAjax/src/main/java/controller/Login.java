package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import service.MemberService;
import service.MemberServiceImpl;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String loginJson = request.getParameter("login");
		System.out.println(loginJson);
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jobj = (JSONObject)parser.parse(loginJson);
			String id = (String)jobj.get("id");
			String password = (String)jobj.get("password");
			boolean autologin = (boolean)jobj.get("autologin");
			
			MemberService memberService = new MemberServiceImpl();
			memberService.login(id, password);
			
			//login success시 cookie check & 저장
			Cookie autoLoginCookie = null;
			Cookie idCookie = null;
			Cookie passwordCookie = null;
			
			autoLoginCookie = new Cookie("autologin", String.valueOf(autologin));
			if(autologin) {
				idCookie = new Cookie("id", id);
				passwordCookie = new Cookie("password", password);
			} else {  //체크 안 했으면 id랑 password cookie값 지워주기
				idCookie = new Cookie("id", "");
				passwordCookie = new Cookie("password", "");
			}
			response.addCookie(autoLoginCookie);
			response.addCookie(idCookie);
			response.addCookie(passwordCookie);
			
			//session 저장
			request.getSession().setAttribute("user", id);
			response.getWriter().write("true");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
		}
	}

}
