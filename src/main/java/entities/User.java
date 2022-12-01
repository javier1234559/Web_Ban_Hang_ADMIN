package main.java.entities;

public class User {
	private String uname;
	private String uemail;
	private int id;
	private String umobile;
	private String DiaChi;
	
	public User() {
		
	}

	public User(String uname, String uemail, int id, String umobile, String diaChi) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.id = id;
		this.umobile = umobile;
		DiaChi = diaChi;
	}
	public User(String uname, String uemail,  String umobile, String diaChi) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		
		this.umobile = umobile;
		DiaChi = diaChi;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUmobile() {
		return umobile;
	}

	public void setUmobile(String umobile) {
		this.umobile = umobile;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	
	
	
}

