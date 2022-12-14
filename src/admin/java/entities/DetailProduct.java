package admin.java.entities;

public class DetailProduct {
	public int idproduct;
	public int idimage ;
	public int soluong;
	public String image;
	public String color;
	
	public DetailProduct() {}
	
	public DetailProduct(int idproduct, int idimage, int soluong, String image, String color) {
		super();
		this.idproduct = idproduct;
		this.idimage = idimage;
		this.soluong = soluong;
		this.image = image;
		this.color = color;
	}

	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public int getIdimage() {
		return idimage;
	}

	public void setIdimage(int idimage) {
		this.idimage = idimage;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	} 

	
}
