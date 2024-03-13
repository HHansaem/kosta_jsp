package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.BFile;
import dto.Board;
import util.MybatisSqlSessionFactory;

public class BoardDAOImpl implements BoardDAO {
	private SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public List<Board> selectBoardList(Integer row) throws Exception {
		//쿼리문의 결과가 여러개(list)일 때는 selectList
		return sqlSession.selectList("mapper.board.selectBoardList", row);
	}

	@Override
	public Integer selectBoardCount() throws Exception {
		//쿼리문의 결과가 하나일 때는 selectOne
		return sqlSession.selectOne("mapper.board.selectBoardCount");
	}

	@Override
	public Board selectBoard(Integer num) throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoard", num);
	}
	
	 @Override
	 public void insertBoard(Board board) throws Exception {
	    sqlSession.insert("mapper.board.insertBoard", board);
	    sqlSession.commit();
	 }
	
	 @Override
	 public void insertFile(BFile file) throws Exception {
	    sqlSession.insert("mapper.board.insertFile", file);
	    sqlSession.commit();
	 }

	@Override
	public void updateBoard(Board board) throws Exception {
		sqlSession.update("mapper.board.updateBoard", board);
		sqlSession.commit();
	}

	@Override
	public void updateBrdViewCnt(Integer num) throws Exception {
		sqlSession.update("mapper.board.updateBrdViewCnt", num);
	    sqlSession.commit();
	}
}
