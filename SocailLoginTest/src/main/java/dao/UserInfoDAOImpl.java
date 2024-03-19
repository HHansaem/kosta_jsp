package dao;

import org.apache.ibatis.session.SqlSession;

import dto.UserInfo;
import util.MybatisSqlSessionFactory;

public class UserInfoDAOImpl implements UserInfoDAO {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public UserInfo selectUserInfo(String id) throws Exception {
		return sqlSession.selectOne("mapper.userInfo.selectUserInfo", id);
	}

	@Override
	public void insertUserInfo(UserInfo userInfo) throws Exception {
		sqlSession.insert("mapper.userInfo.insertUserInfo", userInfo);
		sqlSession.commit();
	}

}
