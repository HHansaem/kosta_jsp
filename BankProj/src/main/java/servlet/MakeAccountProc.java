package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Account;

/**
 * Servlet implementation class MakeAccountProc
 */
@WebServlet("/makeaccount")
public class MakeAccountProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccountProc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int balance = Integer.parseInt(request.getParameter("balance"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");
		
		Account acc = new Account(id, name, balance, type, grade);
		HttpSession session = request.getSession();
		session.setAttribute(id, acc);  //다른 페이지에서 사용하기 위해 담기 (여러 정보 공유)
		
		request.setAttribute("acc", acc);  //다른 페이지에서 사용할 값 request에 담기 (단일요청 정보)
		//서블릿에서 forward 하는 방법! (request 데이터 해당 페이지로 보내기)
		//dispatcher : 이 페이지로 위임한다 (앞에서 받은 request, response 그대로 넘겨줌) 
		RequestDispatcher dispatcher = request.getRequestDispatcher("accountInfo.jsp");
		dispatcher.forward(request, response);  //데이터 공유하기 (request값 공유)
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      req.getRequestDispatcher("makeAccount.jsp").forward(req, resp);
	   }

}
