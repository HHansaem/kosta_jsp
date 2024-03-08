package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public void insertMember(Member mem) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "insert into member value(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setString(4, mem.getEmail());
			pstmt.setString(5, mem.getAddress());
			pstmt.executeUpdate();
			JdbcUtil.commit(conn);
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}

	@Override
	public Member selectMember(String id) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from member where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member mem = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				mem = new Member(rs.getString(1)
								, rs.getString(2)
								, rs.getString(3)
								, rs.getString(4)
								, rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return mem;
	}

}
