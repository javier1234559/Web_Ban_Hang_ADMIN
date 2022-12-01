package main.java.entities;

import java.sql.Timestamp;
public class Bill {
	private int idBill;
	private Timestamp ngay;
	private int totalprice;
	private String idDiscount;
	private String DiaChiNhanHang;
	private int tennguoinhan;
	private int SDTNguoiNhan;
	public Bill() {}
	public Bill(int idBill, Timestamp ngay, int totalprice, String idDiscount, String diaChiNhanHang, int tennguoinhan,
			int sDTNguoiNhan) {
		super();
		this.idBill = idBill;
		this.ngay = ngay;
		this.totalprice = totalprice;
		this.idDiscount = idDiscount;
		DiaChiNhanHang = diaChiNhanHang;
		this.tennguoinhan = tennguoinhan;
		SDTNguoiNhan = sDTNguoiNhan;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public Timestamp getNgay() {
		return ngay;
	}
	public void setNgay(Timestamp ngay) {
		this.ngay = ngay;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getIdDiscount() {
		return idDiscount;
	}
	public void setIdDiscount(String idDiscount) {
		this.idDiscount = idDiscount;
	}
	public String getDiaChiNhanHang() {
		return DiaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		DiaChiNhanHang = diaChiNhanHang;
	}
	public int getTennguoinhan() {
		return tennguoinhan;
	}
	public void setTennguoinhan(int tennguoinhan) {
		this.tennguoinhan = tennguoinhan;
	}
	public int getSDTNguoiNhan() {
		return SDTNguoiNhan;
	}
	public void setSDTNguoiNhan(int sDTNguoiNhan) {
		SDTNguoiNhan = sDTNguoiNhan;
	}
	
}
