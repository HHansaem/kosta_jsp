package service;

import dao.BoardLikeDAO;
import dao.BoardLikeDAOImpl;

public class BoardLikeServiceImpl implements BoardLikeService {
	private BoardLikeDAO boardLikeDAO = new BoardLikeDAOImpl();
	
	@Override
	public boolean boardLike(String memberId, Integer boardNum) throws Exception {
		Integer num = boardLikeDAO.selectBoardLike(memberId, boardNum);
		//하트가 눌려져 있지 않으면 false 리턴
		if(num == null) return false;
		return true;
	}

	@Override
	public boolean togleBoardLike(String memberId, Integer boardNum) throws Exception {
		boolean isBoardLike = boardLike(memberId, boardNum);
		if(isBoardLike) {
			boardLikeDAO.deleteBoardLike(memberId, boardNum);
			return false;
		} else {
			boardLikeDAO.insertBoardLike(memberId, boardNum);
			return true;
		}
	}

}
