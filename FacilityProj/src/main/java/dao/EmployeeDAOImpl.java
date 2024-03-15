package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Employee;
import util.MybatisSqlSessionFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	private SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public int insertEmployee(Employee emp) throws Exception {
		int cnt = sqlSession.insert("mapper.employee.insertEmployee", emp);
		sqlSession.commit();
		return cnt;
	}

	@Override
	public Employee selectEmployee(String empNo) throws Exception {
		return sqlSession.selectOne("mapper.employee.selectEmployee", empNo);
	}

}
