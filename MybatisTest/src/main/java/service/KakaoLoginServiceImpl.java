package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import dto.UserInfo;

public class KakaoLoginServiceImpl implements KakaoLoginService {

	@Override
	public UserInfo KakaoLogin(String code) throws Exception {
		//1. code 값으로 accessToken 가져오기
		String token = getAccessToken(code);
		System.out.println(token);
		
		//2. token 값으로 카카오에서 사용자 정보 가져오기
		UserInfo userInfo = getMemberInfo(token);
		
		return userInfo;
	}
	
	public String getAccessToken(String code) throws Exception {
		String urlStr = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);  //출력스트림 활성화 (파라미터 body 영역에 넣기 위해)
		
		//파라미터 생성
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		StringBuilder param = new StringBuilder();
		param.append("grant_type=authorization_code");
		param.append("&client_id=64a71bf8086477eb48501855a911415f");
		param.append("&redirect_uri=http://localhost:8080/test/kakao");
		param.append("&code="+code);
		
		bw.write(param.toString());
		bw.flush();
		
		//응답
		BufferedReader br;
		int resultCode = conn.getResponseCode();
		if(resultCode >= 200 && resultCode <= 300) {  //정상
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {  //error
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder resBuilder = new StringBuilder();
		String line;
		while((line=br.readLine()) != null) {
			resBuilder.append(line);
		}
		br.close();
		conn.disconnect();
		
		System.out.println(resBuilder.toString());
		
		JSONParser parser = new JSONParser();
		JSONObject tokenObj = (JSONObject)parser.parse(resBuilder.toString());
		String token = (String)tokenObj.get("access_token");
		return token;
	}
	
	public UserInfo getMemberInfo(String token) throws Exception {
		String urlStr = "https://kapi.kakao.com/v2/user/me";
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization", "Bearer "+token);
		
		BufferedReader br; 
		int resultCode = conn.getResponseCode();
		System.out.println(resultCode);
		if(resultCode>=200 && resultCode<=300) {  //정상
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {  //error
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		
		StringBuilder resBuilder = new StringBuilder();
		String line;
		while((line=br.readLine()) != null) {
			resBuilder.append(line);
		}
		
		br.close();
		conn.disconnect();
		
		System.out.println(resBuilder.toString());
		JSONParser parser = new JSONParser();
		
		JSONObject userObj = (JSONObject)parser.parse(resBuilder.toString());
		Long id = (Long)userObj.get("id");
		JSONObject properties = (JSONObject)userObj.get("properties");
		String nickname = (String)properties.get("nickname");
		String profile_image = (String)properties.get("profile_image");
		String thumbnail_image = (String)properties.get("thumbnail_image");
		
		UserInfo userInfo = new UserInfo(id, nickname, profile_image, thumbnail_image);
		return userInfo;
	}

}
