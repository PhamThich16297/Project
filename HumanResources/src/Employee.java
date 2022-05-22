/* class Employee la 1 class con cua class Staff va implements interface ICalculator
 * Vi la lop con cua class Staff nen se thua huong cac thuoc tinh va phuong thuc cua class Staff, them thuoc tinh soGioLamThem
 * Tao cac ham contructor va getter, setter*/
public class Employee extends Staff implements ICalculator {
	private double soGioLamThem;
	
	public Employee() {
		
	}

	public Employee(String maNV, String tenNV, int tuoiNV, double heSoLuong, String ngayVaoLam, Department boPhanLamViec,
			int soNgayNghiPhep, double soGioLamThem) {
		super(maNV, tenNV, tuoiNV, heSoLuong, ngayVaoLam, boPhanLamViec, soNgayNghiPhep);
		this.soGioLamThem = soGioLamThem;
	}
	
	
	public double getSoGioLamThem() {
		return soGioLamThem;
	}

	public void setSoGioLamThem(double soGioLamThem) {
		this.soGioLamThem = soGioLamThem;
	}
	
	/* phuong thuc displayInformation duoc ghi de va viet lai ham phuong thuc abstract tu class Cha(Staff)*/
	@Override
	public String displayInformation() {
		return "Nhan Vien: " + getTenNV() + " - " + "Ma NV: " + getMaNV() + " - "+ getTuoiNV() + " Tuoi - HSL: " + getHeSoLuong() + " - " + getNgayVaoLam() + " - Bo Phan: " + getBoPhanLamViec().toString() + " - " + getSoNgayNghiPhep() + " ngay Phep" + " - " + getSoGioLamThem() + " Gio lam Them";
		
	}
	/* Phuong thuc rieng caculateSalary cua class Employee de tra gia tri Luong*/
	public double calculateSalary() {
		return getHeSoLuong() * 3000000 + soGioLamThem * 200000;
	}
	/* phuong thuc tinhLuong() dc ghi de phuong thuc trong interface ICalculor, tra ve ket qua cua phuong thuc calculateSalary()*/
	@Override
	public double tinhLuong() {
		
		return calculateSalary();
	}
}
