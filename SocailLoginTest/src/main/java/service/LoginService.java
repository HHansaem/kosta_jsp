package service;

import dto.UserInfo;

public interface LoginService {
	UserInfo kakaoLogin(String code) throws Exception;
	UserInfo naverLogin(String code, String state) throws Exception;
}
