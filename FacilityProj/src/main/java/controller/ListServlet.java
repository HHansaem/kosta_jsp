package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FacilityBiz;
import service.TeamBiz;

@WebServlet(urlPatterns = { "/facility/list" })
public class ListServlet extends HttpServlet {

	// TODO
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			TeamBiz teamBiz = new TeamBiz();
			FacilityBiz facilityBiz = new FacilityBiz();
			request.setAttribute("facilityList", facilityBiz.getFacilityList());
			request.setAttribute("teamBudget", teamBiz.selectTeamBudget());
			request.getRequestDispatcher("/list.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "시설목록 조회 오류");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
}