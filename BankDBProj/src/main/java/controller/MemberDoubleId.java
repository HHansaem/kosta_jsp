package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.MemberServiceImpl;

/**
 * Servlet implementation class MemberDoubleId
 */
@WebServlet("/memberDoubleId")
public class MemberDoubleId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDoubleId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		try {
			MemberService memberService = new MemberServiceImpl();
			boolean doubleId = memberService.checkDoubleId(id);
			response.getWriter().write(String.valueOf(doubleId));  //문자열로 받아서 응답 (ajax의 success의 result로 감)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
