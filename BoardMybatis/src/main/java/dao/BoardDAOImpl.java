package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import util.MybatisSqlSessionFactory;

public class BoardDAOImpl implements BoardDAO {
	//SqlSessionFactory를 통해 가져옴 얘는 리소스와 매퍼가 필요
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertDAO(Board board) throws Exception {
		sqlSession.insert("mapper.board.insertBoard", board);  //(mapper의 namespcae와 id)
		sqlSession.commit();
	}

}
