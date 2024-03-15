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
 * Servlet implementation class Json7
 */
@WebServlet("/json7")
public class Json7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Json7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String jsonStr = request.getParameter("data");
		
		JSONParser parser = new JSONParser();
		try {
			JSONObject jsonObj = (JSONObject)parser.parse(jsonStr);
			
			//included의 attributes 가져오기
			JSONArray included = (JSONArray)jsonObj.get("included");
			JSONObject included_0 = (JSONObject)included.get(0);
			JSONObject attributes = (JSONObject)included_0.get("attributes");
			String name = (String)attributes.get("name");
			Long age = (Long)attributes.get("age");
			String gender = (String)attributes.get("gender");
			System.out.println(name);
			System.out.println(age);
			System.out.println(gender);
			
			//data의 relationships의 author의 data 가져오기
			JSONArray data = (JSONArray)jsonObj.get("data");
			JSONObject data_0 = (JSONObject)data.get(0);
			JSONObject relationships = (JSONObject)data_0.get("relationships");
			JSONObject author = (JSONObject)relationships.get("author");
			JSONObject author_data = (JSONObject)author.get("data");
			String id = (String)author_data.get("id");
			String type = (String)author_data.get("type");
			System.out.println(id);
			System.out.println(type);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
