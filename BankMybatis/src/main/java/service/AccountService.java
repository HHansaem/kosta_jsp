package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.Account;

public interface AccountService {
	void makeAccount(HttpServletRequest request) throws Exception;
	Account searchAccount(String id) throws Exception;
	List<Account> allAccountList() throws Exception;
	void deposit(HttpServletRequest request) throws Exception;
	void withdraw(HttpServletRequest request) throws Exception;
	void transfer(HttpServletRequest request) throws Exception;
}
