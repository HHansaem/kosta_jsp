package service;

import javax.servlet.http.HttpServletRequest;

import dto.Member;

public interface MemberService {
	void join(HttpServletRequest request) throws Exception;
}
