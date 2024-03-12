package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import dto.File;
import util.MybatisSqlSessionFactory;

public class BoardDAOImpl implements BoardDAO {
	//SqlSession 생성
	//SqlSessionFactory를 통해 가져옴 얘는 리소스와 매퍼가 필요
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertDAO(Board board) throws Exception {
		sqlSession.insert("mapper.board.insertBoard", board);  //("mapper의 namespcae와 id", 넘겨줄데이터)
		sqlSession.commit();
	}

	@Override
	public void insertFile(File file) throws Exception {
		sqlSession.insert("mapper.board.insertFile", file);
		sqlSession.commit();
	}

	@Override
	public List<Board> selectBoardList(Integer row) throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardList", row);
	}

	@Override
	public Integer selectBoardCount() throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoardCount");
	}

	@Override
	public Board selectBoard(Integer num) throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoard", num);
	}

	@Override
	public void updateBoard(Board board) throws Exception {
		sqlSession.update("mapper.board.updateBoard", board);
		sqlSession.commit();
	}

}
