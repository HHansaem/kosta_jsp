package controlloer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import service.BoardLikeService;
import service.BoardLikeServiceImpl;

/**
 * Servlet implementation class BoardLike
 */
@WebServlet("/boardlike")
public class BoardLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardLike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsonParam = request.getParameter("like");
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jobj = (JSONObject)parser.parse(jsonParam);
			String memberId = (String)jobj.get("memberId");
			String boardNum = (String)jobj.get("boardNum");
			
			BoardLikeService boardLikeService = new BoardLikeServiceImpl();
			boolean like = boardLikeService.togleBoardLike(memberId, Integer.parseInt(boardNum));
			response.getWriter().write(String.valueOf(like));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
