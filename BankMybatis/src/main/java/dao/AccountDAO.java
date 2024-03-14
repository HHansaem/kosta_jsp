package dao;

import java.util.List;

import dto.Account;

public interface AccountDAO {
	void insertAccount(Account account) throws Exception;
	Account selectAccount(String id) throws Exception;
	List<Account> selectAccountList() throws Exception;
	void updateAccountBalance(Account account) throws Exception;
}
