package service;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;
	public EmployeeServiceImpl() {
		this.employeeDAO = new EmployeeDAOImpl();
	}
	
	@Override
	public void signUp(Employee emp) throws Exception {
		int cnt = employeeDAO.insertEmployee(emp);
		if(cnt <= 0) throw new Exception("회원가입 오류");
	}

	@Override
	public Employee login(String empNo, String empPw) throws Exception {
		Employee emp = employeeDAO.selectEmployee(empNo);
		if(emp == null) throw new Exception("사번이 존재하지 않습니다");
		if(!empPw.equals(emp.getPw())) throw new Exception("비밀번호가 일치하지 않습니다");
		return emp;
	}

}
