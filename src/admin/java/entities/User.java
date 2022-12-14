package admin.java.entities;

public class User {
	public int id;
	public String uname;
	public String upwd;
	public String uemail;
	public String umobile;
	public String DiaChi;
	public String role; 
	
	public User() {

	}

	public User(int id, String uname, String upwd, String uemail, String umobile, String diaChi, String role) {
		super();
		this.id = id;
		this.uname = uname;
		this.upwd = upwd;
		this.uemail = uemail;
		this.umobile = umobile;
		this.DiaChi = diaChi;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
}
