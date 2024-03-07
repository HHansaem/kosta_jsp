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
      String pw = request.getParameter("password");
      RequestDispatcher dispatcher = null;
      
      HttpSession session = request.getSession();
      Member mem = (Member) session.getAttribute(id);
      
      if (mem==null) { // id error
         request.setAttribute("err", "아이디가 틀립니다.");
         dispatcher = request.getRequestDispatcher("error.jsp");
      } else if (mem.getPassword().equals(pw)==false){ // pw error
            request.setAttribute("err", "비밀번호가 틀립니다! 다시 입력해주십시오.");
            dispatcher = request.getRequestDispatcher("error.jsp");
      } else { // success : session에 사용자 정보 저장
         session.setAttribute("user", mem.getId());
         
         // 자동 로그인 체크하여 쿠키로 내려보내기
         String autologin = request.getParameter("autologin");
         if(autologin==null) autologin="false";
         Cookie autoLogin = new Cookie("autologin", autologin);
         autoLogin.setMaxAge(600);
         response.addCookie(autoLogin);
         
         if(autologin!=null && autologin.equals("true")) {
            Cookie userId = new Cookie("id", id);
            userId.setMaxAge(600);
            Cookie userPw = new Cookie("password", pw);
            userPw.setMaxAge(600);
            response.addCookie(userId);
            response.addCookie(userPw);
         }
         dispatcher = request.getRequestDispatcher("makeAccount.jsp");
      }
      dispatcher.forward(request, response);
   }
   
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("login.jsp").forward(req, resp);
   }
}