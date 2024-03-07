package service;

import dto.Member;

public interface MemberService {
	void join(Member mem) throws Exception;
	Member login(String id) throws Exception;
}
