package service;

import dto.Member;

public interface MemberService {
	void join(Member mem) throws Exception;
	void login(String id, String password) throws Exception;
	boolean checkDoubleId(String id) throws Exception;
}
