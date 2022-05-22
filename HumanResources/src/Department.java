
/* class Department gom thuoc tinh maBoPhan, tenBoPhan, soLuongNVHienTai
 * 						va 1 phuong thuc toString() 
 * 
 * 	Tao cac ham contrustor va cac phuong thuc getter va setter
 * */
public class Department {
	private String maBoPhan;
	private String tenBoPhan;
	private int soLuongNVHienTai;
	public Department() {
		
	}
	
	public Department(String maBoPhan, String tenBoPhan) {
		this.maBoPhan = maBoPhan;
		this.tenBoPhan = tenBoPhan;
	}

	// Ham contrustor tao doi tuong Bo Phan co 3 tham so
	public Department(String maBoPhan, String tenBoPhan, int soLuongNVHienTai) {
		this.maBoPhan = maBoPhan;
		this.tenBoPhan = tenBoPhan;
		this.soLuongNVHienTai = soLuongNVHienTai;
	}

	public String getMaBoPhan() {
		return maBoPhan;
	}

	public void setMaBoPhan(String maBoPhan) {
		this.maBoPhan = maBoPhan;
	}

	public String getTenBoPhan() {
		return tenBoPhan;
	}

	public void setTenBoPhan(String tenBoPhan) {
		this.tenBoPhan = tenBoPhan;
	}

	public int getSoLuongNVHienTai() {
		return soLuongNVHienTai;
	}

	public void setSoLuongNVHienTai(int soLuongNVHienTai) {
		this.soLuongNVHienTai = soLuongNVHienTai;
	}
	@Override
	public String toString() {
		
		return "Ma BP: " + getMaBoPhan() + " - Ten BP: " + getTenBoPhan();
	}
}
