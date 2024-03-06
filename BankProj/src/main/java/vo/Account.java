package vo;

public class Account {
	private String id;
	private String name;
	private int balance;
	private String type;
	private String grade;
	
	public Account() {}
	public Account(String id, String name, int balance, String type, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.type = type;
		this.grade = grade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public void deposit(int money) {
		if(money > 0) balance += money;
	}
	
	public void withdraw(int money) {
		if(balance >= money) balance -= money;
	}
	
//	public Account(String id) {
//		this.id = id;
//	}
//	public void transfer(String sendId, String recvId, int money) {
//		Account sendAcc = new Account(sendId);
//		Account recvAcc = new Account(recvId);
//		if(sendAcc.getBalance() >= money) {
//			sendAcc.withdraw(money);
//			recvAcc.deposit(money);
//		}
//	}
	
}
