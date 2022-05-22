/* abstract class Staff co 2 class con Employee va Manager 
 * abstract class Staff gom cac thuoc tinh: maNV, tenNV, tuoiNV, heSoLuong, ngayVaoLam, boPhanLamViec(tao tu doi tuong Department), soNgayNghiPhep
 * 							va Phuong thuc abstract displayInformation
 * Tao cac contrustor va cac phuong thuc getter, setter*/
public abstract class Staff {
	private String maNV;
	private String tenNV;
	private int tuoiNV;
	private double heSoLuong;
	private String ngayVaoLam;
	private Department boPhanLamViec;
	private int soNgayNghiPhep;
	
	public Staff() {
		
	}
	
	public Staff(String maNV, String tenNV, int tuoiNV, double heSoLuong, String ngayVaoLam, Department boPhanLamViec,
			int soNgayNghiPhep) {
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.tuoiNV = tuoiNV;
		this.heSoLuong = heSoLuong;
		this.ngayVaoLam = ngayVaoLam;
		this.boPhanLamViec = boPhanLamViec;
		this.soNgayNghiPhep = soNgayNghiPhep;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public int getTuoiNV() {
		return tuoiNV;
	}

	public void setTuoiNV(int tuoiNV) {
		this.tuoiNV = tuoiNV;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public String getNgayVaoLam() {
		return ngayVaoLam;
	}

	public void setNgayVaoLam(String ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}

	public Department getBoPhanLamViec() {
		return boPhanLamViec;
	}

	public void setBoPhanLamViec(Department boPhanLamViec) {
		this.boPhanLamViec = boPhanLamViec;
	}

	public int getSoNgayNghiPhep() {
		return soNgayNghiPhep;
	}

	public void setSoNgayNghiPhep(int soNgayNghiPhep) {
		this.soNgayNghiPhep = soNgayNghiPhep;
	}
	
	
	public abstract String displayInformation();

}
