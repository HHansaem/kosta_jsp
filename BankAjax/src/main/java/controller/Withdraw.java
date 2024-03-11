package controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String withdrawJson = request.getParameter("withdraw");
		System.out.println(withdrawJson);
		
		//json-simple을 통해 parse하기
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject  jobj = (JSONObject)parser.parse(withdrawJson);
			String id = (String)jobj.get("id");
			Long money = (Long)jobj.get("money");  //Long타입은 int도 포함
			
			AccountService accountService = new AccountServiceImpl();
			accountService.withdraw(id, money.intValue());
			Account acc = accountService.accountInfo(id);
			response.getWriter().write(String.format("%s 계좌 잔액은 %d입니다"
					, acc.getId(), acc.getBalance()));
		} catch (Exception e) {
			response.getWriter().write(e.getMessage());
		}
	}

}
