package service;

import dto.UserInfo;

public interface KakaoLoginService {
	UserInfo KakaoLogin(String code) throws Exception; 
}
