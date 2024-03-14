package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dto.Account;
import util.MybatisSqlSessionFactory;

public class AccountDAOImpl implements AccountDAO {
	private SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertAccount(Account account) throws Exception {
		sqlSession.insert("mapper.account.insertAccount", account);
		sqlSession.commit();
	}

	@Override
	public Account selectAccount(String id) throws Exception {
		return sqlSession.selectOne("mapper.account.selectAccount", id);
	}

	@Override
	public List<Account> selectAccountList() throws Exception {
		return sqlSession.selectList("mapper.account.selectAccountList");
	}

	@Override
	public void updateAccountBalance(Account account) throws Exception {
		sqlSession.update("mapper.account.updateAccountBalance", account);
		sqlSession.commit();
	}

}
