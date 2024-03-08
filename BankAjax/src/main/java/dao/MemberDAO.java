package dao;

import dto.Member;

public interface MemberDAO {
	void insertMember(Member mem) throws Exception;
	Member selectMember(String id) throws Exception;
}
