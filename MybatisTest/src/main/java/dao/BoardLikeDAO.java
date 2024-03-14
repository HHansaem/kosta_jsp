package dao;

import java.util.Map;

public interface BoardLikeDAO {
	void insertBoardLike(String memberId, Integer boardNum) throws Exception;
	void deleteBoardLike(String memberId, Integer boardNum) throws Exception;
	Integer selectBoardLike(String memberId, Integer boardNum) throws Exception;
}
