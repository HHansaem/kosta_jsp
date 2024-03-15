package dto;

public class Employee {
	private String empNo;
	private String pw;
	private String empNm;
	
	public Employee() {}
	
	public Employee(String empNo, String pw, String empNm) {
		super();
		this.empNo = empNo;
		this.pw = pw;
		this.empNm = empNm;
	}

	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmpNm() {
		return empNm;
	}
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}
	
}
