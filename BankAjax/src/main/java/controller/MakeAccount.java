package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");  //JSON 형식으로 보낼 때는 response(응답)에도 인코딩
		
		String accJson = request.getParameter("acc");
		System.out.println(accJson);
		Gson gson = new Gson();  //JSON으로 받은 데이터를 객체로 만들어주기 위해 선언
		Account acc = gson.fromJson(accJson, Account.class);  //class타입에 맞게 Account객체로 만들어줌
		
		try {
			AccountService accountService = new AccountServiceImpl();
			accountService.makeAccount(acc);
			response.getWriter().write("계좌가 개설되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("계좌가 개설되지 않았습니다");
		}
	}

}
