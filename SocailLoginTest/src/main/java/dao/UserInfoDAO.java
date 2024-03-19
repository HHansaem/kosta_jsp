package dao;

import dto.UserInfo;

public interface UserInfoDAO {
	UserInfo selectUserInfo(String id) throws Exception;
	void insertUserInfo(UserInfo userInfo) throws Exception;
}
