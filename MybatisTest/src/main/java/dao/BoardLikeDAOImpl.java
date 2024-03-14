package dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisSqlSessionFactory;

public class BoardLikeDAOImpl implements BoardLikeDAO {
	private SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertBoardLike(String memberId, Integer boardNum) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("memberId", memberId);
		param.put("boardNum", boardNum);
		sqlSession.insert("mapper.boardlike.insertBoardLike", param);
		sqlSession.commit();
	}

	@Override
	public void deleteBoardLike(String memberId, Integer boardNum) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("memberId", memberId);
		param.put("boardNum", boardNum);
		sqlSession.delete("mapper.boardlike.deleteBoardLike", param);
		sqlSession.commit();
	}

	@Override
	public Integer selectBoardLike(String memberId, Integer boardNum) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("memberId", memberId);
		param.put("boardNum", boardNum);
		return sqlSession.selectOne("mapper.boardlike.selectBoardLike", param);
	}

}
