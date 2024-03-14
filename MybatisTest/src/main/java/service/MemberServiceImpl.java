package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dao.MemberDAOImple;
import dto.Member;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO = new MemberDAOImple();
	
	@Override
	public void join(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		Member smember = memberDAO.selectMember(id);
		if(smember != null) throw new Exception("아이디가 중복됩니다");
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		Member member = new Member(id, name, password, email, address);
		memberDAO.insertMember(member);
	}

	@Override
	public void login(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member member = memberDAO.selectMember(id);
		if(member == null) throw new Exception("아이디가 존재하지 않습니다");
		if(!member.getPassword().equals(password)) throw new Exception("비밀번호가 틀립니다");
		
		//로그인 정상
		HttpSession session = request.getSession();
		member.setPassword("");  //비밀번호는 빼고 세션에 저장 (비번은 중요하니까..)
		session.setAttribute("user", member);
		
	}

	@Override
	public boolean memberIdCheck(String id) throws Exception {
		Member member = memberDAO.selectMember(id);
		if(member == null) return false;
		return true;
	}

}
