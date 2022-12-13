package admin.java.entities;

public class User {
	public String id;
	public String uname;
	public String upwd;
	public String uemail;
	public String umobile;
	public String DiaChi;

	public User() {

	}

	public User(String id, String uname, String upwd, String uemail, String umobile, String diaChi) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.uemail = uemail;
		this.umobile = umobile;
		DiaChi = diaChi;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
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
