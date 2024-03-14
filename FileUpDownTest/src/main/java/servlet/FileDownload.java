package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDown
 */
@WebServlet("/fileDown")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String fname = request.getParameter("file");
		String downloadPath = request.getServletContext().getRealPath("doc");
		
		FileInputStream fis = new FileInputStream(new File(downloadPath, fname));
		
		String mimeType = request.getServletContext().getMimeType(downloadPath+"\\"+fname);  //파일 형식을 얻어옴
		if(mimeType == null) {
			mimeType = "application/octet-stream";  //octet-stream: 8비트로 된 일련의 데이터를 뜻함. 지정되지 않은 파일 타입을 의미
		}
		
		response.setContentType(mimeType);
		String encoding = new String(fname.getBytes("utf-8"),"8859_1");  //한글 파일명 깨짐 방지
		response.setHeader("content-Disposition", "attachment; filename= " + encoding);
		
		OutputStream out = response.getOutputStream();
		byte[] buff = new byte[4096];
		int len;
		while((len = fis.read(buff)) > 0) {
			out.write(buff, 0, len);
		}
		fis.close();
	}

}
