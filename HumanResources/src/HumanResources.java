/*Khai bao cac lop co trong goi Java.util*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/* class HumanResources: class chinh de thuc thi chuong trinh*/
public class HumanResources {

	static Scanner input = new Scanner(System.in);
	
	private ArrayList<Staff> dsStaff = new ArrayList<Staff>();
	private ArrayList<Department> dsDepartment = new ArrayList<Department>();
	
	
	//IN DANH SACH STAFF >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public void inDsStaff() {
		int i = 1;
		System.out.println("________DANH SACH NHAN VIEN________");
		for (Staff staff : dsStaff) {
			System.out.println(i + ". " + staff.displayInformation());
			i++;
		}
	}
	
	//IN DANH SACH DEPARTMENT
	int soLuongNVofBP;
	public void inDsDepartment() {
		System.out.println("________DANH SACH BO PHAN________");
		for (Department department : dsDepartment) {
			soLuongNVofBP = 0;
			for (Staff staff : dsStaff) {
				if(staff.getBoPhanLamViec().toString().equals(department.toString())) {
					soLuongNVofBP++;
				}
			}
			System.out.println(department + " - So Luong Nhan Vien: " + soLuongNVofBP);
		}
	}
	
	
	
	// IN CAC NHAN VIEN TRONG TUNG BO PHAN
	public void inNVTheoBP() {
		int i = 1;
		for (Department department : dsDepartment) {
			System.out.println(i + ". " + department.toString());
			i++;
			int j = 1;
			for (Staff staff : dsStaff) {
				if(staff.getBoPhanLamViec().toString().equals(department.toString())) {
					System.out.println("	" + j + ". " + staff.displayInformation());
					j++;
				}
			}
		}
	}
	
	// THEM NHAN VIEN MOI
	public void themStaff(Staff staff) {
		dsStaff.add(staff);
	}
	
	// TIM THEO TEN
	public void timTheoTenNV(String ten) {
		ArrayList<String> arrList = new ArrayList<String>();
		for (Staff s : dsStaff) {
			if (s.getTenNV().equals(ten)) {
				System.out.println(s.displayInformation());
				arrList.add(s.getTenNV());
			}
		}
		if (arrList.size() < 1) {
			System.out.println("Khong Tim Thay");
		}
	}
		
	
	//TIM THEO MA NHAN VIEN
	public void timTheoMaNV(String maNV) {
		ArrayList<String> arrList = new ArrayList<String>();
		for (Staff staff : dsStaff) {
			if (staff.getMaNV().equals(maNV)) {
				System.out.println(staff.displayInformation());
				arrList.add(staff.getMaNV());
			} 
		}
		if (arrList.size() < 1) {
			System.out.println("khong Tim Thay");
		}
	}
	
	
	// HIEN THI BANG LUONG TANG DAN
	public void sapXepTang() {
			Collections.sort(dsStaff, new Comparator<Staff>() {

				@Override
				public int compare(Staff o1, Staff o2) {
					if (((ICalculator)o1).tinhLuong() > ((ICalculator)o2).tinhLuong()) {
						return 1;
					} else if (((ICalculator)o1).tinhLuong() < ((ICalculator)o2).tinhLuong()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			System.out.println("_____BANG LUONG NHAN VIEN THU TU TANG DAN_____");
			int i = 1;
			for (Staff staff : dsStaff) {
				double salary = 0;
				if (staff instanceof Employee) {
					salary = ((Employee)staff).tinhLuong();
				} else if (staff instanceof Manager) {
					salary = ((Manager)staff).tinhLuong();
				}
				System.out.println(i + ". " + staff.displayInformation() + " - Luong: " + salary);
				i++;
			}
	}
		
	// SAP XEP BANG LUONG GIAM DAN
	public void sapXepGiam() {
		Collections.sort(dsStaff, new Comparator<Staff>() {
			
			@Override
			public int compare(Staff o1, Staff o2) {
				if (((ICalculator)o1).tinhLuong() > ((ICalculator)o2).tinhLuong()) {
					return -1;
				} else if (((ICalculator)o1).tinhLuong() < ((ICalculator)o2).tinhLuong()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		
		System.out.println("_____BANG LUONG NHAN VIEN THU TU GIAM DAN_____");
		int i = 1;
		for (Staff staff : dsStaff) {
			double salary = 0;
			if (staff instanceof Employee) {
				salary = ((Employee)staff).tinhLuong();
			} else if (staff instanceof Manager) {
				salary = ((Manager)staff).tinhLuong();
			}
			System.out.println(i + ". " + staff.displayInformation() + " - Luong: " + salary);
			i++;
		}
	}
			
	// HAM main XU LY CHUONG TRINH
	public static void main(String[] args) {
		HumanResources hrs = new HumanResources();
		
		// Vi du Ktra
		//___________________________________________________________________________________________________
		//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//		Department bp1 = new Department("BP 01", "Bo Phan 01");
//		Department bp2 = new Department("BP 02", "Bo Phan 02");
//		Department bp3 = new Department("BP 03", "Bo Phan 03");
//		
//		Staff st1 = new Employee("Ma01", "Ten 1", 23, 2.3, "01/03/2019", bp1, 10, 1.2);
//		Staff st2 = new Employee("Ma02", "Ten 1", 23, 2.7, "08/02/2010", bp2, 10, 1.5);
//		Staff st3 = new Employee("Ma03", "Ten 3", 23, 2.6, "07/12/2019", bp1, 10, 1.4);
//		Staff st4 = new Employee("Ma04", "Ten 4", 23, 2.3, "15/08/20121", bp1, 10, 1);
//		Staff st5 = new Manager("Ma05", "Ten 5", 36, 5.7, "14/03/2019", bp1, 16, "Business Leader");
//		Staff st6 = new Employee("Ma09", "Ten 9", 23, 2.7, "22/03/2015", bp3, 10, 3.2);
//		Staff st7 = new Employee("Ma06", "Ten 6", 23, 2.1, "15/03/2019", bp2, 10, 2.2);
//		Staff st8 = new Employee("Ma07", "Ten 7", 23, 2.0, "09/07/2017", bp1, 10, 1.2);
//		Staff st9 = new Manager("Ma08", "Ten 8", 36, 5.1, "01/02/2019", bp2, 16, "Project Leader");
		//:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::	
	//____________________________________________________________________________________________________		
		
		
		//________________________________________________________________________________________________
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
//		hrs.dsDepartment.add(bp1);
//		hrs.dsDepartment.add(bp2);
//		hrs.dsDepartment.add(bp3);
//		
//		hrs.dsStaff.add(st1);
//		hrs.dsStaff.add(st2);
//		hrs.dsStaff.add(st3);
//		hrs.dsStaff.add(st4);
//		hrs.dsStaff.add(st5);
//		hrs.dsStaff.add(st6);
//		hrs.dsStaff.add(st7);
//		hrs.dsStaff.add(st8);
//		hrs.dsStaff.add(st9);
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
		//__________________________________________________________________________________________________
		
		int luachon = 0;
		/* Vong lap do..while hien thi Menu chuong trinh, chap nhan cac lua chon cua nguoi dung nhap */
		do {
			System.out.println();
			System.out.println("________MENU________");
			System.out.println("1 - Hien Thi Nhan Vien hien co trong Cong ty.");
			System.out.println("2 - Hien Thi cac Bo phan trong Cong ty.");
			System.out.println("3 - Hien Thi cac Nhan Vien theo tung bo phan.");
			System.out.println("4 - Them Nhan Vien moi vao Cong ty.");
			System.out.println("5 - Tim Kiem thong tin Nhan Vien theo Ten Nhan Vien.");
			System.out.println("6 - Tim kiem thong tin Nhan Vien theo Ma Nhan Vien.");
			System.out.println("7 - Hien Thi bang luong cua Nhan Vien theo thu tu GIAM dan.");
			System.out.println("8 - Hien thi Bang luong cua Nhan Vien theo thu tu TANG dan.");
			System.out.println("0 - THOAT");
			
			System.out.println("Nhap So Tuong ung voi cac chuc nang:"); luachon = input.nextInt();
			//1 - Hien Thi Nhan Vien hien co trong Cong ty.
			if (luachon == 1) {
				hrs.inDsStaff();
			
			//2 - Hien Thi cac Bo phan trong Cong ty.
			} else if (luachon == 2) {
				hrs.inDsDepartment();
			
			//3 - Hien Thi cac Nhan Vien theo tung bo phan.
			} else if (luachon == 3) {
				hrs.inNVTheoBP();
			
			//4 - Them Nhan Vien moi vao Cong ty.
			} else if (luachon == 4) {
				int answer = 0;
				// 2 Lua chon de them Nhan Vien la them Employee va Them Manager
				System.out.println("Phim 1. Them Employee          Phim 2. Them Manager"); answer = input.nextInt();
				if (answer == 1) {
					input.nextLine();
					System.out.print("Nhap Ma NV: "); String maNV = input.nextLine();
					System.out.print("Nhap Ten NV: ");	String tenNV = input.nextLine();
					System.out.print("Nhap Tuoi NV: "); int tuoiNV = input.nextInt();
					System.out.print("Nhap He So Luong: "); double hslNV = input.nextDouble();
					input.nextLine();
					System.out.print("Ngay Vao Lam: "); String ngayVaoLam = input.nextLine();
					System.out.println("Nhap Bo Phan Lam Viec:");
					
					System.out.print("Nhap Ma Bo Phan: "); String maBPh = input.nextLine();
					System.out.print("Nhap Ten Bo Phan: "); String tenBP = input.nextLine();
					System.out.print("So Ngay Nghi Phep: "); int soNgayNghiPhep = input.nextInt();
					System.out.print("So Gio Lam Them: "); double soGioLamThem = input.nextInt();
					
					//Tao doi tuong tu gia tri nguoi dung nhap
					Department bp = new Department(maBPh, tenBP);
					Employee emp = new Employee(maNV, tenNV, tuoiNV, hslNV, ngayVaoLam, bp, soNgayNghiPhep, soGioLamThem);
					
					// ktra neu Department nguoi dung nhap chua co trong dsDepartment thi add vao dsDepartment
					boolean b = false;
					for (Department d : hrs.dsDepartment) {
						if(d.toString().equals(bp.toString())) {
							b = true;
						}
					}
					if(b==false) {
						hrs.dsDepartment.add(bp);
					}
					
					//them Staff tu nguoi dung nhap vao dsStaff
					hrs.dsStaff.add(emp);
					
					System.out.println("Da Nhap:\n" + emp.displayInformation());
					
				} else if (answer == 2) {
					input.nextLine();
					System.out.print("Nhap Ma NV: "); String maNV = input.nextLine();
					System.out.print("Nhap Ten NV: ");	String tenNV = input.nextLine();
					System.out.print("Nhap Tuoi NV: "); int tuoiNV = input.nextInt();
					System.out.print("Nhap He So Luong: "); double hslNV = input.nextDouble();
					input.nextLine();
					System.out.print("Ngay Vao Lam: "); String ngayVaoLam = input.nextLine();
					System.out.println("Nhap Bo Phan Lam Viec:");
					System.out.print("Nhap Ma Bo Phan: "); String maBPh = input.nextLine();
					System.out.print("Nhap Ten Bo Phan: "); String tenBP = input.nextLine();
					System.out.print("So Ngay Nghi Phep: "); int soNgayNghiPhep = input.nextInt();
					
					System.out.println("Chon Chuc Danh: ");
					System.out.println("1. Business Leader");
					System.out.println("2. Project Leader");
					System.out.println("3. Technical Leader");
					//lua chon cac chuc danh tu nguoi dung nhap
					int i = input.nextInt();
					String chucDanh = "";
					if (i == 1) {
						chucDanh = "Business Leader";
					} else if (i == 2) {
						chucDanh = "Project Leader";
					} else if (i == 3) {
						chucDanh = "Technical Leader";
					}
					
					Department bp = new Department(maBPh, tenBP);
					Manager mnger = new Manager(maNV, tenNV, tuoiNV, hslNV, ngayVaoLam, bp, soNgayNghiPhep, chucDanh);
					
					boolean b = false;
					for (Department d : hrs.dsDepartment) {
						if(d.toString().equals(bp.toString())) {
							b = true;
						}
					}
					if(b==false) {
						hrs.dsDepartment.add(bp);
					}
					hrs.dsStaff.add(mnger);
					
					System.out.println("Da Nhap:\n" + mnger.displayInformation());
				}
				
			// 5 - Tim Kiem thong tin Nhan Vien theo Ten Nhan Vien.
			} else if (luachon == 5) {
				input.nextLine();
				System.out.println("Nhap Ten Can Tim: "); String ten = input.nextLine();
				hrs.timTheoTenNV(ten);
			
			//6 - Tim kiem thong tin Nhan Vien theo Ma Nhan Vien.
			} else if (luachon == 6) {
				input.nextLine();
				System.out.println("Nhap Ma NV Can Tim: "); String maNV = input.nextLine();
				hrs.timTheoMaNV(maNV);
			
			//7 - Hien Thi bang luong cua Nhan Vien theo thu tu GIAM dan.
			} else if (luachon == 7) {
				hrs.sapXepGiam();
				
			//8 - Hien thi Bang luong cua Nhan Vien theo thu tu TANG dan.
			} else if (luachon == 8) {
				hrs.sapXepTang();
			} 
		// 0 Thoat chuong trinh
		} while (luachon != 0);
		
	}

}
