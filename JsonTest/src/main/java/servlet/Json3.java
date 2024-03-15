package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class Json3
 */
@WebServlet("/json3")
public class Json3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Json3() {
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
			JSONObject jsonObj = (JSONObject)parser.parse(interest);
			JSONArray interestArr = (JSONArray)jsonObj.get("interest");  //interest이름을 가진 객체의 값을 get
			for(int i=0; i<interestArr.size(); i++) {
				System.out.println((String)interestArr.get(i));
			}
			
			JSONObject resJsonObj = new JSONObject();
			resJsonObj.put("res", "전송 성공");
			response.getWriter().write(resJsonObj.toJSONString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
