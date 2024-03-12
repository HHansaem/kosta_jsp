package controller;

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
 * Servlet implementation class Image
 */
@WebServlet("/image")
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Image() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String path = request.getServletContext().getRealPath("upload");
		FileInputStream fis = new FileInputStream(new File(path, num+""));
		OutputStream out = response.getOutputStream();
		byte[] buff = new byte[4096];
		int len = 0;
		while((len = fis.read(buff)) > 0) {
			out.write(buff, 0, len);
		}
		fis.close();
	}

}
