package comd;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.LocationService;
import service.LocationServiceImpl;
import vo.Location;

/**
 * Servlet implementation class MapsInfo
 */
@WebServlet("/maps")
public class MapsInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MapsInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int page = 1;
		String pageStr = request.getParameter("page");
		if(pageStr != null) {
			page = Integer.parseInt(pageStr);
		}
		
		try {
			LocationService locService = new LocationServiceImpl();
			List<Location> locs = locService.getLocationList(page);
			if(locs == null) throw new Exception("위치 데이터가 없습니다.");

			Gson gson = new Gson();
			String jsonArrayString = gson.toJson(locs);
			request.setAttribute("locs", jsonArrayString);
//			System.out.println(jsonArrayString);
			
			Integer maxPage = locService.getLocationMaxPage();
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("page", page);
			request.getRequestDispatcher("AddressSearchMapAPI.jsp").forward(request, response);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", e.getMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
