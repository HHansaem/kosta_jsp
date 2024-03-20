package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import util.MybatisSqlSessionFactory;
import vo.Location;

public class LocationDAOImpl implements LocationDAO {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public List<Location> selectLocationList(Integer row) throws Exception {
		return sqlSession.selectList("mapper.location.selectLocationList", row);
	}

	@Override
	public Integer selectLocationCnt() throws Exception {
		return sqlSession.selectOne("mapper.location.selectLocationCnt");
	}

}
