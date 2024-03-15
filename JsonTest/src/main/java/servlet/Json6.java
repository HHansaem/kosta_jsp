package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import vo.Person;

/**
 * Servlet implementation class Json6
 */
@WebServlet("/json6")
public class Json6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Json6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Person> pers = new ArrayList<>();
		pers.add(new Person("박지성",40));
		pers.add(new Person("손흥민",30));
		pers.add(new Person("김민재",32));
		
		JSONArray jsonArr = new JSONArray();
		for(Person per : pers) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("name", per.getName());
			jsonObj.put("age", per.getAge());
			System.out.println(jsonObj);
			jsonArr.add(jsonObj);
		}

		response.setCharacterEncoding("utf-8");
		response.getWriter().write(jsonArr.toJSONString());
	}

}
