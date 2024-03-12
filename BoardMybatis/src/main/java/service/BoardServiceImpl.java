package service;

import dao.BoardDAO;
import dao.BoardDAOImpl;
import dto.Board;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO;
	public BoardServiceImpl() {
		boardDAO = new BoardDAOImpl();
	}
	
	@Override
	public void boardWrite(Board board) throws Exception {
		boardDAO.insertDAO(board);
	}

}
