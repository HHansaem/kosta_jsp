package service;

import dto.Employee;

public interface EmployeeService {
	void signUp(Employee emp) throws Exception;
	void login(String empNo, String empPw) throws Exception;
}
