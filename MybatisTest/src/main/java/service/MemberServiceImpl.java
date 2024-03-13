package service;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDAO;
import dao.MemberDAOImple;
import dto.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO = new MemberDAOImple();
	
	@Override
	public void join(HttpServletRequest request) throws Exception {
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setEmail(request.getParameter("email"));
		member.setAddress(request.getParameter("address"));
		
		memberDAO.insertMember(member);
	}

}
