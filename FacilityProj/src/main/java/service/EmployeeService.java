package service;

import dto.Employee;

public interface EmployeeService {
	void signUp(Employee emp) throws Exception;
	Employee login(String empNo, String empPw) throws Exception;
}
