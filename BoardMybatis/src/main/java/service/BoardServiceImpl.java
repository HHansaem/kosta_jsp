package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import dao.BoardDAO;
import dao.BoardDAOImpl;
import dto.Board;
import dto.File;
import util.PageInfo;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;
	public BoardServiceImpl() {
		boardDAO = new BoardDAOImpl();
	}
	
	@Override
	public void boardWrite(HttpServletRequest request) throws Exception {
		Board board = new Board();
		
		//업로드경로 & 파일크기
		String uploadPath = request.getServletContext().getRealPath("upload");
		int size = 10*1024*1024;  //업로드할 최대 파일 크기 지정
		//파일 업로드를 위한 jar파일 (cos.jar) 추가 후 아래 코드 작성 
//		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", 
//				new FileRenamePolicy() {  //파일명을 바꿔주는 역할
//					@Override
//					public java.io.File rename(java.io.File file) {  //java.io의 File
//						File uploadFile = new File();  //dto의 File
//						try {
//							uploadFile.setName(file.getName());
//							uploadFile.setDirectory(uploadPath);
//							uploadFile.setSize(file.length());
//							boardDAO.insertFile(uploadFile);
//							board.setFilenum(uploadFile.getNum());
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//						//file.getParent() : 파일경로를 위해 적어줘야 함 (uploadPath도 가능)
//						java.io.File f = new java.io.File(file.getParent(), uploadFile.getNum()+"");  //java.io의 File
//						return f;
//					}
//				} );
		
		//multi : file 정보를 포함한 request
		//파일업로드
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		//파일 정보 테이블에 저장
		File uploadFile = new File();
		uploadFile.setName(multi.getOriginalFileName("file"));
		uploadFile.setDirectory(uploadPath);
		uploadFile.setContenttype(multi.getContentType("file"));
		uploadFile.setSize(multi.getFile("file").length());
		boardDAO.insertFile(uploadFile);
		
		//파일번호로 업로드한 파일명 변경
		java.io.File file = new java.io.File(uploadPath, multi.getFilesystemName("file"));
		file.renameTo(new java.io.File(file.getParent(), uploadFile.getNum()+""));
		
		//게시글 테이블에 저장
		board.setFilenum(uploadFile.getNum());
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		board.setWriter(multi.getParameter("writer"));
		boardDAO.insertDAO(board);
	}

	@Override
	public void boardListByPage(HttpServletRequest request) throws Exception {
		String paramPage = request.getParameter("page");
		Integer page = 1;
		if(paramPage != null) {
			page = Integer.parseInt(paramPage);
		}
		
		int boardCount = boardDAO.selectBoardCount();
		int maxPage = (int)Math.ceil((double)boardCount/10);  //Math.ceil : 올림해주는 함수
		int startPage = (page-1)/10*10+1;
		int endPage = startPage+10-1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCurPage(page);
		pageInfo.setAllPage(maxPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		int row = (page-1)*10;
		List<Board> boardList = boardDAO.selectBoardList(row);
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageInfo", pageInfo);
	}

	@Override
	public Board boardDetail(Integer num) throws Exception {
		return boardDAO.selectBoard(num);
	}

	@Override
	public void boardModify(HttpServletRequest request) throws Exception {
		Board board = new Board();
		
		//업로드경로 & 파일크기
		String uploadPath = request.getServletContext().getRealPath("upload");
		int size = 10*1024*1024;  //업로드할 최대 파일 크기 지정
		
		//파일 업로드
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "utf-8", new DefaultFileRenamePolicy());
		
		//파일이 있으면 정보 테이블에 저장
		if(multi.getFile("file") != null) {
			File uploadFile = new File();
			uploadFile.setName(multi.getOriginalFileName("file"));
			uploadFile.setDirectory(uploadPath);
			uploadFile.setContenttype(multi.getContentType("file"));
			uploadFile.setSize(multi.getFile("file").length());
			boardDAO.insertFile(uploadFile);
			
			//파일번호로 업로드한 파일명 변경
			java.io.File file = new java.io.File(uploadPath, multi.getFilesystemName("file"));
			file.renameTo(new java.io.File(file.getParent(), uploadFile.getNum()+""));
			board.setFilenum(uploadFile.getNum());
		}
		
		//게시글 테이블에서 수정
		board.setNum(Integer.parseInt(multi.getParameter("num")));
		board.setSubject(multi.getParameter("subject"));
		board.setContent(multi.getParameter("content"));
		
		boardDAO.updateBoard(board);
	}

}
