package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Account;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public void insertAccount(Account acc) throws Exception {
		String sql = "insert into account value(?,?,?,?,?)";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, acc.getId());
			pstmt.setString(2, acc.getName());
			pstmt.setInt(3, acc.getBalance());
			pstmt.setString(4, acc.getType());
			pstmt.setString(5, acc.getGrade());
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
	public Account selectAccount(String id) throws Exception {
		String sql = "select * from account where id=?";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account acc = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs != null && rs.next()) {
				String sid = rs.getString("id");
				String sname = rs.getString("name");
				int sbalance = rs.getInt("balance");
				String stype = rs.getString("type");
				String sgrade = rs.getString("grade");
				acc = new Account(sid, sname, sbalance, stype, sgrade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return acc;
	}

	@Override
	public void updateAccountBalance(String id, int balance) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql = "update account set balance=? where id=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			JdbcUtil.commit(conn);
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
		} finally {
			pstmt.close();
			conn.close();
		}
	}

	@Override
	public boolean updateAccountBalanceTransaction(Connection conn, String id, int balance) throws Exception {
		String sql = "update account set balance=? where id=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, balance);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			JdbcUtil.rollback(conn);
			return false;
		} finally {
			pstmt.close();
		}
	}

	@Override
	public List<Account> selectAccountList() throws Exception {
		List<Account> accountList = new ArrayList<>();
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from account";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {
					String id = rs.getString(1);
					String name = rs.getString(2);
					int balance = rs.getInt(3);
					String type = rs.getString(4);
					String grade = rs.getString(5);
					accountList.add(new Account(id, name, balance, type, grade));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
		return accountList;
	}
	
}