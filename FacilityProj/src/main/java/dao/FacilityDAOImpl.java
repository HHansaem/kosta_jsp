package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Facility;
import util.MybatisSqlSessionFactory;

public class FacilityDAOImpl implements FacilityDAO {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public List<Facility> selectFacilityList() throws Exception {
		return sqlSession.selectList("mapper.facility.selectFacilityList");
	}

	@Override
	public Facility selectFacility(String id) throws Exception {
		return sqlSession.selectOne("mapper.facility.selectFacility", id);
	}

	@Override
	public void updateFacility(String id, String name, Integer price, String etc) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("name", name);
		params.put("price", price);
		params.put("etc", etc);
		sqlSession.update("mapper.facility.updateFacility", params);
		sqlSession.commit();
	}
}
