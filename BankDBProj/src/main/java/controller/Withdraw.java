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
 * Servlet implementation class Withdraw
 */
@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Withdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("withdraw.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. request 인코딩 지정
		request.setCharacterEncoding("utf-8");
		//2. 파라미터 가져오기
		String id = request.getParameter("id");
		int money = Integer.parseInt(request.getParameter("money"));
		RequestDispatcher dispatcher = null;
		try {
			//3. 서비스의 출금 호출하기 (예외처리)
			AccountService accountService = new AccountServiceImpl();
			accountService.withdraw(id, money);
			Account acc = accountService.accountInfo(id);
			request.setAttribute("acc", acc);
			dispatcher = request.getRequestDispatcher("accountInfo.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", e.getMessage());
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		//4. 계좌조회 포워딩하기
		dispatcher.forward(request, response);
	}

}
