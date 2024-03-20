package vo;

public class Location {
	private String address;
	private String title;
	
	public Location() {}
	
	public Location(String address, String title) {
		super();
		this.address = address;
		this.title = title;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
