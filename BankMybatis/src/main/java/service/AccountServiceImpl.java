package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import dto.Account;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO = new AccountDAOImpl();
	
	@Override
	public void makeAccount(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Integer balance = Integer.parseInt(request.getParameter("balance"));
		String type = request.getParameter("type");
		String grade = request.getParameter("grade");
		
		Account acc = new Account(id, name, balance, type, grade);
		request.setAttribute("acc", acc);
		
		accountDAO.insertAccount(acc);
	}

	@Override
	public Account searchAccount(String id) throws Exception {
		return accountDAO.selectAccount(id);
	}

	@Override
	public List<Account> allAccountList() throws Exception {
		return accountDAO.selectAccountList();
	}

	@Override
	public void deposit(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		Integer money = Integer.parseInt(request.getParameter("money"));
		
		Account acc = accountDAO.selectAccount(id);
		acc.deposit(money);
		request.setAttribute("acc", acc);
		
		accountDAO.updateAccountBalance(acc);
	}

	@Override
	public void withdraw(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		Integer money = Integer.parseInt(request.getParameter("money"));
		
		Account acc = accountDAO.selectAccount(id);
		acc.withdraw(money);
		request.setAttribute("acc", acc);
		
		accountDAO.updateAccountBalance(acc);
	}

	@Override
	public void transfer(HttpServletRequest request) throws Exception {
		String sid = request.getParameter("sid");
		String rid = request.getParameter("rid");
		Integer money = Integer.parseInt(request.getParameter("money"));
		
		Account sendAcc = accountDAO.selectAccount(sid);
		sendAcc.withdraw(money);
		Account reciveAcc = accountDAO.selectAccount(rid);
		reciveAcc.deposit(money);
		
		request.setAttribute("acc", sendAcc);
		
		accountDAO.updateAccountBalance(sendAcc);
		accountDAO.updateAccountBalance(reciveAcc);
	}

}
