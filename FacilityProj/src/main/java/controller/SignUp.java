package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Employee;
import service.EmployeeService;
import service.EmployeeServiceImpl;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/member/signUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//그냥 "signUp.jsp"를 쓰면 member 밑에서 찾음. 근데 jsp가 지금 webapp 바로 아래 있으니까 '/'를 명시적으로 지정)
		// '/'는 root를 의미
		// './'는 현재 경로를 의미
		request.getRequestDispatcher("/signUp.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String empNo = request.getParameter("empNo");
		String empPw = request.getParameter("empPw");
		String empNm = request.getParameter("empNm");
		
		Employee emp = new Employee(empNo, empPw, empNm);
		try {
			EmployeeService empService = new EmployeeServiceImpl();
			empService.signUp(emp);
			response.sendRedirect("/");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
