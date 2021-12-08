package CaseModule.View;

import CaseModule.Controller.MenuController;
import CaseModule.Model.Admin;
import CaseModule.Model.FullTime;
import CaseModule.Model.NhanVien;
import CaseModule.Model.PartTime;

import java.util.List;
import java.util.Scanner;

public class NhanVienView {
    static Scanner scanner = new Scanner(System.in);
    static MenuController Menu = new MenuController();
    static Validate validate = new Validate();

    public String getAccountName() {
        System.out.println("vui long nhap ten tai khoan");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.println("Vui long nhap mat khau");
        return scanner.nextLine();
    }

    public String getName() {
        System.out.println("***************************************");
        System.out.println("***   Vui long nhap ten nhan vien   ***");
        System.out.println("***   Hoac an QUIT de thoat         ***");
        System.out.println("***************************************");
        String name = scanner.nextLine();
        if (name.equalsIgnoreCase("quit")) {
            Menu.menu();
        }
        return name;
    }

    public void showInfo(NhanVien nhanVien) {
        System.out.println(nhanVien.getInfo());
    }

    public void showNhanVien(NhanVien nhanVien) {
        System.out.println(nhanVien);
    }

    public void showStatus(String status) {
        System.out.println(status);
    }

    public NhanVien createNhanVien(String choice) {
        System.out.println("**********************************************");
        System.out.println("***  Vui long nhap ten nhan vien           ***");
        String name = validate.validateName();
        System.out.println("***  Vui long nhap tuoi nhan vien          ***");
        int age = validate.validateNumber();
        System.out.println("***  Vui long nhap gioi tinh cua nhan vien ***");
        String gender = validate.validateGender();
        System.out.println("***  Vui long nhap muc luong               ***");
        int salary = validate.validateNumber();
        if (choice.equals("1")) {
            return new PartTime(name, age, gender, salary);
        } else {
            System.out.println("***  Vui long nhap he so luong(100)        ***");
            double coefficients = validate.validateNumber();
            System.out.println("**********************************************");
            coefficients /= 100;
            if (choice.equals("2")) {
                return new FullTime(name, age, gender, salary, coefficients);
            } else return new Admin(name, age, gender, salary,coefficients);
        }
    }

    public void showListNhanVien(List<NhanVien> nhanViens) {
        for (NhanVien nhanVien : nhanViens) {
            System.out.println(nhanVien);
        }
        System.out.println();
    }

    public void noAcess() {
        System.err.println("BAN KHONG CO QUYEN TRUY CAP!!! CHI CO ADMIN MOI CO QUYEN TRUY CAP!!!");
    }


    public double getGioLam() {
        System.out.println("***     Nhap gio lam cua nhan vien             ***");
        return validate.validateGioLam();
    }


    public void backToMenu() {
        System.out.println("Quay tro lai MENU!");
    }

    public void error() {
        System.err.println("LOI!");
    }


    public void accountNameExist() {
        System.err.println("TEN TAI KHOAN DA TON TAI!");
    }

    public void accountExist() {
        System.err.println("TAI KHOAN DA TON TAI!");
    }

    public void deleteSuccess() {
        System.out.println("DA XOA THANH CONG!+");
    }
}
