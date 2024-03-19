package dto;

public class UserInfo {
   private String id;
   private String password;
   private String name;
   private String nickname;
   private String email;
   private String address;
   private String profileImg;
   private String thumbnailImg;
   
   public UserInfo() {}
   
   public UserInfo(String id, String name, String nickname, String profileImg, String email) {
      super();
         this.id = id;
         this.name = name;
         this.nickname = nickname;
         this.email = email;
         this.profileImg = profileImg;
   }
   
   public UserInfo(String id, String password, String name, String nickname, String email, String address,
         String profileImg, String thumbnailImg) {
      super();
      this.id = id;
      this.password = password;
      this.name = name;
      this.nickname = nickname;
      this.email = email;
      this.address = address;
      this.profileImg = profileImg;
      this.thumbnailImg = thumbnailImg;
   }
   
   public UserInfo(String id, String nickname, String profileImg, String thumbnailImg) {
      super();
         this.id = id;
         this.nickname = nickname;
         this.profileImg = profileImg;
         this.thumbnailImg = thumbnailImg;
   }
   
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPassword() {
      return password;
   }
   public void setPassword(String password) {
      this.password = password;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getNickname() {
      return nickname;
   }
   public void setNickname(String nickname) {
      this.nickname = nickname;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getProfileImg() {
      return profileImg;
   }
   public void setProfileImg(String profileImg) {
      this.profileImg = profileImg;
   }
   public String getThumbnailImg() {
      return thumbnailImg;
   }
   public void setThumbnailImg(String thumbnailImg) {
      this.thumbnailImg = thumbnailImg;
   }
   
   
}
