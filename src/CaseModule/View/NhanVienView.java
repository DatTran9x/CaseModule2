package CaseModule.View;

import CaseModule.Controller.NhanVienController;
import CaseModule.Model.Admin;
import CaseModule.Model.FullTime;
import CaseModule.Model.NhanVien;
import CaseModule.Model.PartTime;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NhanVienView {
    static NhanVienController controller = new NhanVienController();
    static Scanner scanner = new Scanner(System.in);

    public void logIn() {
        System.out.println("DANG NHAP");
        System.out.println("Vui long nhap ten tai khoan");
        String account = scanner.nextLine();
        System.out.println("Vui long nhap mat khau");
        String password = scanner.nextLine();
        controller.checkLogin(account, password);
    }

    public String getAccountName() {
        System.out.println("vui long nhap ten tai khoan");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.println("Vui long nhap mat khau");
        return scanner.nextLine();
    }

    public String menu() {
        System.out.println("---Menu---");
        System.out.println("1.Them nhan vien");
        System.out.println("2.Tim kiem nhan vien");
        System.out.println("3.Sua thong tin nhan vien");
        System.out.println("4.Xoa nhan vien");
        System.out.println("5.Hien thi danh sach nhan vien");
        System.out.println("6.Kiem tra trang thai nhan vien");
        System.out.println("7.Thay doi trang thai nhan vien");
        System.out.println("8.Thong tin tai khoan");
        System.out.println("9.Dang xuat");
        System.out.println("10.Thoat chuong trinh");
        return scanner.nextLine();
    }

    public String info() {
        System.out.println("1.Lay thong tin tai khoan");
        System.out.println("2.Tao tai khoan");
        System.out.println("3.Thay doi tai khoan");
        System.out.println("4.Xoa tai khoan");
        System.out.println("5.Quay lai Menu");
        return scanner.nextLine();
    }

    public String choose() {
        System.out.println("1.FullTime");
        System.out.println("2.PartTime");
        System.out.println("3.Admin");
        System.out.println("4.Quay lai MENU");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
            case "2":
            case "3":
            case "4":
                return choice;
            default:
                System.out.println("Vui long chon lai");
                return choose();
        }
    }

    public String getName() {
        System.out.println("Vui long nhap ten nhan vien");
        System.out.println("Hoac an QUIT de thoat");
        String name = scanner.nextLine();
        if (name.equalsIgnoreCase("quit")) {
            controller.choice();
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
        System.out.println("Vui long nhap ten nhan vien");
        String name = validateName();
        System.out.println("Vui long nhap tuoi nhan vien");
        int age = validateNumber();
        System.out.println("Vui long nhap gioi tinh cua nhan vien");
        String gender = validateGender();
        System.out.println("Vui long nhap muc luong");
        int salary = validateNumber();
        if (choice.equals("1")) {
            return new PartTime(name, age, gender, salary);
        } else {
            if (choice.equals("2")) {
                System.out.println("Vui long nhap he so luong(100%)");
                double coefficients = validateNumber();
                coefficients /= 100;
                return new FullTime(name, age, gender, salary, coefficients);
            } else return new Admin(name, age, gender, salary);
        }
    }

    public String chooseWhatToEdit() {
        System.out.println("1.Sua thong tin nhan vien");
        System.out.println("2.Sua so gio lam cua nhan vien");
        System.out.println("3.Quay lai MENU");
        return scanner.nextLine();
    }

    public int validateNumber() {
        try {
            String age = scanner.nextLine();
            int tuoi = Integer.parseInt(age);
            if (tuoi < 0) {
                System.err.println("VUI LONG NHAP LAI!");
                return validateNumber();
            }
            return tuoi;
        } catch (Exception e) {
            System.err.println("VUI LONG NHAP SO!");
            return validateNumber();
        }
    }

    public void showListNhanVien(List<NhanVien> nhanViens) {
        for (NhanVien nhanVien : nhanViens) {
            System.out.println(nhanVien);
        }
    }

    public void noAcess() {
        System.err.println("BAN KHONG CO QUYEN TRUY CAP!!! CHI CO ADMIN MOI CO QUYEN TRUY CAP!!!");
    }


    public double getGioLam() {
        System.out.println("Nhap gio lam cua nhan vien");
        return validateGioLam();
    }

    private double validateGioLam() {
        try {
            String timeWork = scanner.nextLine();
            double gioLam = Double.parseDouble(timeWork);
            if (gioLam < 0) {
                System.err.println("VUI LONG NHAP LAI!");
                return validateGioLam();
            }
            return gioLam;
        } catch (Exception e) {
            System.err.println("VUI LONG NHAP SO!");
            return validateGioLam();
        }
    }

    public void backToMenu() {
        System.out.println("Quay tro lai MENU!");
    }

    public String chooseWhatToDoWithNhanVien() {
        System.out.println("1.Sua nhan vien");
        System.out.println("2.Xoa nhan vien");
        System.out.println("3.Quay lai MENU");
        return scanner.nextLine();
    }

    public void error() {
        System.err.println("LOI!");
    }

    public String validateName() {
        String regex = scanner.nextLine();
        if (controller.checkName(regex)) {
            System.err.println("DA TON TAI TEN NAY");
            validateName();
        }
        final String ACCOUNT_REGEX = ("^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶ\"+\n" +
                "\"ẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợ\"+\n" +
                "\"ụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$");
        Pattern pattern = Pattern.compile(ACCOUNT_REGEX);
        Matcher matcher = pattern.matcher(regex);
        if (matcher.matches()) {
            return regex;
        } else {
            System.err.println("VUI LONG NHAP LAI!");
            validateName();
        }
        return null;
    }

    public String validateGender() {
        String gender = scanner.nextLine();
        switch (gender) {
            case "Nam":
            case "Nu":
            case "NAM":
            case "NU":
                return gender;
            default:
                System.err.println("VUI LONG NHAP LAI!");
                validateGender();
        }
        return null;
    }

    public void accountNameExist() {
        System.err.println("TEN TAI KHOAN DA TON TAI!");
    }

    public void accountExist() {
        System.err.println("TAI KHOAN DA TON TAI!");
    }

    public int getIndex() {
        System.out.println("Nhap so thu tu nhan vien ban muon tuong tac");
        return validateNumber();
    }
}
