package admin.java.entities;


public class Product {
	
	public int idproduct;
	public String nameproduct ;
	public long price;
	public String category;
	public String image; 
	public String MoTa;
    
    public Product() {}
    public Product(int idproduct, String nameproduct, long price, String category, String image, String moTa) {
  		this.idproduct = idproduct;
  		this.nameproduct = nameproduct;
  		this.price = price;
  		this.category = category;
  		this.image = image;
  		this.MoTa = moTa;
  	}
    
    public int getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}
	public String getNameproduct() {
		return nameproduct;
	}
	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
    
    
}
