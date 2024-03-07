package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.Account;

/**
 * Servlet implementation class AllAccountInfo
 */
@WebServlet("/allAccountInfo")
public class AllAccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllAccountInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Account> accs = new ArrayList<>();
		HttpSession session = request.getSession();
		Enumeration<String> names = session.getAttributeNames();  //세션에 담긴 모든 정보 가져오기
		
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			Object obj = session.getAttribute(name);
			if(obj instanceof Account) {
				accs.add((Account)obj);
			}
		}
		request.setAttribute("accs", accs);
		request.getRequestDispatcher("allAccountInfo.jsp").forward(request, response);
	}

}
