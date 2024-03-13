package controlloer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import service.BoardServiceImpl;

/**
 * Servlet implementation class BoardDetail
 */
@WebServlet("/boarddetail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			Integer num = Integer.parseInt(request.getParameter("num"));
			
			//서비스에서 Board를 받아서 request에 담아 boarddetail.jsp로 포워드한다
			BoardService boardService = new BoardServiceImpl();
			Board board = boardService.boardDetail(num);
			request.setAttribute("board", board);
			request.getRequestDispatcher("boarddetail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "게시글 상세조회 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
