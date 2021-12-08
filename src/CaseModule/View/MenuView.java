package CaseModule.View;

import CaseModule.Controller.MenuController;
import CaseModule.Controller.NhanVienController;

import java.util.Scanner;

public class MenuView {
    static NhanVienController controller = new NhanVienController();
    static Scanner scanner = new Scanner(System.in);

    public void logInMenu() {
        System.out.println("***************************************");
        System.out.println("*****         DANG NHAP           *****");
        System.out.println("***** Vui long nhap ten tai khoan *****");
        String account = scanner.nextLine();
        System.out.println("*****    Vui long nhap mat khau   *****");
        System.out.println("***************************************");
        String password = scanner.nextLine();
        controller.checkLogin(account, password);
    }

    public String mainMenu() {
        System.out.println("************************************************");
        System.out.println("**********------------Menu------------**********");
        System.out.println("***       1.Them nhan vien                   ***");
        System.out.println("***       2.Tim kiem nhan vien               ***");
        System.out.println("***       3.Sua thong tin nhan vien          ***");
        System.out.println("***       4.Xoa nhan vien                    ***");
        System.out.println("***       5.Hien thi danh sach nhan vien     ***");
        System.out.println("***       6.Kiem tra trang thai nhan vien    ***");
        System.out.println("***       7.Thay doi trang thai nhan vien    ***");
        System.out.println("***       8.Thong tin tai khoan              ***");
        System.out.println("***       9.Dang xuat                        ***");
        System.out.println("***       10.Thoat chuong trinh              ***");
        System.out.println("************************************************");
        return scanner.nextLine();
    }

    public String accountMenu() {
        System.out.println("****************************************");
        System.out.println("***   1.Lay thong tin tai khoan      ***");
        System.out.println("***   2.Tao tai khoan                ***");
        System.out.println("***   3.Thay doi tai khoan           ***");
        System.out.println("***   4.Xoa tai khoan                ***");
        System.out.println("***   5.Quay lai Menu                ***");
        System.out.println("****************************************");
        return scanner.nextLine();
    }

    public String addMenu() {
        System.out.println("****************************************");
        System.out.println("***           1.FullTime             ***");
        System.out.println("***           2.PartTime             ***");
        System.out.println("***           3.Admin                ***");
        System.out.println("***           4.Quay lai MENU        ***");
        System.out.println("****************************************");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
            case "2":
            case "3":
            case "4":
                return choice;
            default:
                System.err.println("Vui long chon lai");
                return addMenu();
        }
    }

    public String editMenu() {
        System.out.println("**********************************************");
        System.out.println("***      1.Sua thong tin nhan vien         ***");
        System.out.println("***      2.Sua so gio lam cua nhan vien    ***");
        System.out.println("***      3.Quay lai MENU                   ***");
        System.out.println("**********************************************");
        return scanner.nextLine();
    }

    public String findMenu() {
        System.out.println("**********************************************");
        System.out.println("***           1.Sua nhan vien              ***");
        System.out.println("***           2.Xoa nhan vien              ***");
        System.out.println("***           3.Quay lai MENU              ***");
        System.out.println("**********************************************");
        return scanner.nextLine();
    }
}
