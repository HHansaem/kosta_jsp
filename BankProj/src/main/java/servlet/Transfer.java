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
 * Servlet implementation class Transfer
 */
@WebServlet("/transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String sendId = request.getParameter("sendId");
		String recvId = request.getParameter("recvId");
		int money = Integer.parseInt(request.getParameter("money"));
		
		HttpSession session = request.getSession();
		Account send = (Account)session.getAttribute(sendId);
		Account recv = (Account)session.getAttribute(recvId);
		RequestDispatcher dispatcher = null;
		
		if(send == null || recv == null) {
			request.setAttribute("err", "계좌번호가 틀립니다");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} else {
			send.withdraw(money);
			recv.deposit(money);
			request.setAttribute("send", send);
			request.setAttribute("acc2", recv);
			dispatcher = request.getRequestDispatcher("allAccountInfo.jsp");
		}
		dispatcher.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      req.getRequestDispatcher("transfer.jsp").forward(req, resp);
	   }

}
