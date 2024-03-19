package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import dao.UserInfoDAO;
import dao.UserInfoDAOImpl;
import dto.UserInfo;

public class LoginServiceImpl implements LoginService {
	
	private UserInfoDAO userInfoDao;
	public LoginServiceImpl() {
		userInfoDao = new UserInfoDAOImpl();
	}
	
	@Override
	public UserInfo kakaoLogin(String code) throws Exception {
		String token = getKakaoToken(code);
		
		UserInfo userInfo = getKakaoUserInfo(token);
		
		//Database 처리
		UserInfo dbUserInfo = userInfoDao.selectUserInfo(userInfo.getId());
		if(dbUserInfo == null) {
			userInfoDao.insertUserInfo(userInfo);
		}
		
		return userInfo;
	}
	
	String getKakaoToken(String code) throws Exception {
		String urlStr = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);  //출력스트림 활성화 (파라미터 body 영역에 넣기 위해)
		
		//파라미터 생성
		StringBuilder param = new StringBuilder();
		param.append("grant_type=authorization_code");
		param.append("&client_id=64a71bf8086477eb48501855a911415f");
		param.append("&redirect_uri=http://localhost:8080/social/kakao");
		param.append("&code="+code);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
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
	
	UserInfo getKakaoUserInfo(String token) throws Exception {
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
		
		UserInfo userInfo = new UserInfo(id+"", nickname, profile_image, thumbnail_image);
		return userInfo;
	}

	@Override
	   public UserInfo naverLogin(String code, String state) throws Exception {
	      String token = getNaverToken(code, state);
	      UserInfo userInfo = getNaverUserInfo(token);
	      
	      // DB 처리
	      UserInfo dbUserInfo = userInfoDao.selectUserInfo(userInfo.getId());
	      if(dbUserInfo==null) {
	    	  userInfoDao.insertUserInfo(userInfo);
	      }
	      
	      return userInfo;
	   }

	   String getNaverToken(String code, String state) throws Exception {
	      String clientId = "9WuvA_UwnYXoFM0MJimD";
	      String clientSecret = "jwljknlVU7";
	      String redirectURI = URLEncoder.encode("http://localhost/social/naver", "utf-8");
	      StringBuilder apiURL = new StringBuilder("https://nid.naver.com/oauth2.0/token?");
	      apiURL.append("grant_type=authorization_code");
	      apiURL.append("&client_id="+clientId);
	      apiURL.append("&client_secret="+clientSecret);
	      apiURL.append("&redirect_uri="+redirectURI);
	      apiURL.append("&code="+code);
	      apiURL.append("&state="+state);
	      
	      URL url =  new URL(apiURL.toString());
	      HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	      conn.setRequestMethod("GET");
	      
	      int responseCode = conn.getResponseCode();
	      BufferedReader br;
	      if(responseCode==200) { // 정상
	         br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      } else { // error
	         br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	      }
	      
	      StringBuilder res = new StringBuilder();
	      String line; 
	      while((line=br.readLine())!=null) {
	         res.append(line);
	      }
	      br.close();
	      conn.disconnect();
	      System.out.println(res.toString());
	      
	      JSONParser parser = new JSONParser();
	      JSONObject jsonObj = (JSONObject) parser.parse(res.toString());
	      String token = (String) jsonObj.get("access_token");
	      
	      return token;
	   }

	   UserInfo getNaverUserInfo(String token) throws Exception {
	      URL url = new URL("https://openapi.naver.com/v1/nid/me");
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      conn.setRequestProperty("Authorization", "Bearer "+token);
	      
	      BufferedReader br;
	      int resultCode = conn.getResponseCode();
	      
	      if(resultCode>=200 && resultCode<=300) { // 정상
	         br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      } else { // error
	         br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	      }
	      
	      StringBuilder resBuilder = new StringBuilder();
	      String line;
	      while((line=br.readLine())!=null) {
	         resBuilder.append(line);
	      }
	      
	      br.close();
	      conn.disconnect();
	      
	      System.out.println(resBuilder.toString());
	      
	      JSONParser parser = new JSONParser();
	      JSONObject jsonObj = (JSONObject) parser.parse(resBuilder.toString());
	       JSONObject response = (JSONObject) jsonObj.get("response");
	       String id = (String) response.get("id");
	       String nickname = (String) response.get("nickname");
	       String profile_image = (String) response.get("profile_image");
	       String email = (String) response.get("email");
	       String name = (String) response.get("name");
	       
	       UserInfo userInfo = new UserInfo(id, name, nickname, profile_image, email);
	      
	      return userInfo;
	   }

}
