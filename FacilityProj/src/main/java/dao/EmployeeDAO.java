package dao;

import dto.Employee;

public interface EmployeeDAO {
	int insertEmployee(Employee emp) throws Exception;
	Employee selectEmployee(String empNo) throws Exception;
}
