package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Account;
import service.AccountService;
import service.AccountServiceImpl;

/**
 * Servlet implementation class MakeAccount
 */
@WebServlet("/makeAccount")
public class MakeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("makeAccount.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int balance = Integer.parseInt(request.getParameter("balance"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");
		
		Account acc = new Account(id, name, balance, type, grade);
		
		RequestDispatcher dispatcher = null;
		try {
			//DB에 저장
			AccountService accountService = new AccountServiceImpl();
			accountService.makeAccount(acc);
			request.setAttribute("acc", acc);
			dispatcher = request.getRequestDispatcher("accountInfo.jsp");
		} catch (Exception e) {
			request.setAttribute("err", e.getMessage());  //계좌번호가 중복됩니다
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		dispatcher.forward(request, response);
	}

}
