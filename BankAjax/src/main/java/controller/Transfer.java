package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import dto.Account;
import service.AccountService;
import service.AccountServiceImpl;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("transfer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String transferJson = request.getParameter("transfer");
		System.out.println(transferJson);
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jobj = (JSONObject)parser.parse(transferJson);
			String sid = (String)jobj.get("sid");
			String rid = (String)jobj.get("rid");
			Long money = (Long)jobj.get("money");
			
			AccountService accountService = new AccountServiceImpl();
			accountService.transfer(sid, rid, money.intValue());
			Account acc = accountService.accountInfo(sid);
			response.getWriter().write(String.format("%s 계좌의 잔액은 %d입니다"
										, acc.getId(), acc.getBalance()));
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
	}

}
