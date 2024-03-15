package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class Json4
 */
@WebServlet("/json4")
public class Json4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Json4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String interest = request.getParameter("interest");
		System.out.println(interest);
		
		JSONParser parser = new JSONParser();
		try {
			JSONArray jsonArry = (JSONArray)parser.parse(interest);
			for(int i=0; i<jsonArry.size(); i++) {
				System.out.println((String)jsonArry.get(i));
			}
			response.getWriter().write("전송 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
