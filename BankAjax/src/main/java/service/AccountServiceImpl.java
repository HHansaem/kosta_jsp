package service;

import java.sql.Connection;
import java.util.List;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import dao.JdbcUtil;
import dto.Account;

public class AccountServiceImpl implements AccountService {
	
	private AccountDAO accountDAO = new AccountDAOImpl();

	@Override
	public void makeAccount(Account acc) throws Exception {
		Account sacc = accountDAO.selectAccount(acc.getId());
		if(sacc != null) throw new Exception("계좌번호가 중복됩니다");
		accountDAO.insertAccount(acc);
	}

	@Override
	public Account accountInfo(String id) throws Exception {
		Account acc = accountDAO.selectAccount(id);
		if(acc == null) throw new Exception("계좌번호가 존재하지 않습니다");
		return acc;
	}

	@Override
	public void deposit(String id, int money) throws Exception {
		Account acc = accountDAO.selectAccount(id);
		if(acc == null) throw new Exception("계좌번호가 존재하지 않습니다");
		acc.deposit(money);
		accountDAO.updateAccountBalance(id, acc.getBalance());
	}

	@Override
	public void withdraw(String id, int money) throws Exception {
		Account acc = accountDAO.selectAccount(id);
		if(acc == null) throw new Exception("계좌번호가 존재하지 않습니다");
		acc.withdraw(money);
		accountDAO.updateAccountBalance(id, acc.getBalance());
	}

	@Override
	public void transfer(String sid, String rid, int money) throws Exception {
		Account sacc = accountDAO.selectAccount(sid);
		if(sacc == null) throw new Exception("보내는 계좌번호가 존재하지 않습니다");
		sacc.withdraw(money);
		Account racc = accountDAO.selectAccount(rid);
		if(racc == null) throw new Exception("받는 계좌번호가 존재하지 않습니다");
		racc.deposit(money);
		
		Connection conn = JdbcUtil.getConnection();
		boolean send = accountDAO.updateAccountBalanceTransaction(conn, sid, sacc.getBalance());
		boolean receive = accountDAO.updateAccountBalanceTransaction(conn, rid, racc.getBalance());
		if(send && receive) {
			JdbcUtil.commit(conn);
		} else {
			JdbcUtil.rollback(conn);
		}
	}

	@Override
	public List<Account> allAccountInfo() throws Exception {
		List<Account> accountList = accountDAO.selectAccountList();
		if(accountList.size() == 0) throw new Exception("개설된 계좌가 없습니다");
		return accountList;
	}

	@Override
	public boolean checkDoubleId(String id) throws Exception {
		Account acc = accountDAO.selectAccount(id);
		if(acc == null) return false;
		return true;
	}

}
