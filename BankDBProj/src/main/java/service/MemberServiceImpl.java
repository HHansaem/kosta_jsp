package service;

import dao.MemberDAO;
import dao.MemberDAOImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService {

	MemberDAO memberDAO = new MemberDAOImpl();
	
	@Override
	public void join(Member mem) throws Exception {
		Member smem = memberDAO.selectMember(mem.getId());
		if(smem != null) throw new Exception("아이디가 중복됩니다");
		memberDAO.insertMember(mem);
	}

	@Override
	public Member login(String id) throws Exception {
		Member mem = memberDAO.selectMember(id);
		if(mem == null) throw new Exception("아이디가 존재하지 않습니다");
		return mem;
	}
}
