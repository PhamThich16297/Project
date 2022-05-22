/* class Manager la class con cua abstract class Staff va implements interface ICalculator
 * 	class Manager thua huong cac thuoc tinh va phuong thuc cua class Staff, them thuoc tinh chucDanh
 * Tao cac contructor va getter, setter*/
public class Manager extends Staff implements ICalculator {
	private String chucDanh;
	
	public Manager() {}
	
	public Manager(String maNV, String tenNV, int tuoiNV, double heSoLuong, String ngayVaoLam, Department boPhanLamViec,
			int soNgayNghiPhep, String chucDanh) {
		super(maNV, tenNV, tuoiNV, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
		this.chucDanh = chucDanh;
	}

	
	public String getChucDanh() {
		return chucDanh;
	}


	public void setChucDanh(String chucDanh) {
		this.chucDanh = chucDanh;
	}

	/* phuong thuc displayInformation duoc ghi de va viet lai ham phuong thuc abstract tu class Cha(Staff)*/
	@Override
	public String displayInformation() {
		return getChucDanh() + " - " +getTenNV() + " - " + "Ma NV: " + getMaNV()+ " - " + getTuoiNV() + " Tuoi - HSL: " + getHeSoLuong() + " - " + getNgayVaoLam() + " - Bo Phan: " + getBoPhanLamViec().toString() + " - " + getSoNgayNghiPhep() + " ngay Phep";
		
	}
	/* Phuong thuc tinhLuong() dc ghi de va ghi lai cong thuc tinh luong cho class Manager*/
	@Override
	public double tinhLuong() {
		double result = 0;
		if (chucDanh == "Business Leader") {
			result = getHeSoLuong() * 5000000 + 8000000;
		} else if (chucDanh == "Project Leader") {
			result = getHeSoLuong() * 5000000 + 5000000;
		} else if (chucDanh == "Technical Leader") {
			result = getHeSoLuong() * 5000000 + 6000000;
		}
		return result;
		
	}
	
}
