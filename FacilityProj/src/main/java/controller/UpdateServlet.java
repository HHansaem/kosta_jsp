package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Facility;
import service.FacilityBiz;

@WebServlet(urlPatterns = { "/facility/update" })
public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		try {
			FacilityBiz biz = new FacilityBiz();
			Facility facility = biz.getFacility(id);
			request.setAttribute("facility", facility);
			request.getRequestDispatcher("/update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "시설물 조회 실패");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer price = Integer.parseInt(request.getParameter("price"));
		String etc = request.getParameter("etc");
		try {
			FacilityBiz biz = new FacilityBiz();
			biz.modifyFacility(id, name, price, etc);
			response.sendRedirect("/facility/list");  //data 실어줄 필요 없으니까 요렇게
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "시설물 수정 실패");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
}