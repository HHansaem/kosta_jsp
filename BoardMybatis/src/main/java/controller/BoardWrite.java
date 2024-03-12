package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dto.Board;
import service.BoardService;
import service.BoardServiceImpl;

/**
 * Servlet implementation class BoardWrite
 */
@WebServlet("/boardwrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWrite() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("writeform.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//파일업로드 시작
		String uploadPath = request.getServletContext().getRealPath("upload");
		int size = 10*1024*1024;  //업로드할 최대 파일 크기 지정
		//파일 업로드를 위한 jar파일 (cos.jar) 추가 후 아래 코드 작성
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		//파일 업로드 끝
		
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String fileUrl = multi.getOriginalFileName("file");
		String writer = multi.getParameter("writer");
		
		Board board = new Board();
		board.setSubject(subject);
		board.setContent(content);
		board.setFileurl(fileUrl);
		board.setWriter(writer);
		
		try {
			BoardService boardService = new BoardServiceImpl();
			boardService.boardWrite(board);
			request.getRequestDispatcher("writeform.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("err", "글쓰기 실패");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}
