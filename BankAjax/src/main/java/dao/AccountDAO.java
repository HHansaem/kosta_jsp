package dao;

import java.sql.Connection;
import java.util.List;

import dto.Account;

public interface AccountDAO {  //DB관련
	void insertAccount(Account acc) throws Exception;
	Account selectAccount(String id) throws Exception;
	void updateAccountBalance(String id, int balance) throws Exception;
	
	//(보낸계좌의 잔액, 받는계좌의) update가 총 두 번 이루어지기 때문에 connection 을 파라미터로 빼준 것
	boolean updateAccountBalanceTransaction(Connection conn, String id, int balance) throws Exception;
	List<Account> selectAccountList() throws Exception;
}
