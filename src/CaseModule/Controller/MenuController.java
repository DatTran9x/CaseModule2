package CaseModule.Controller;

import CaseModule.View.MenuView;
import CaseModule.View.NhanVienView;

public class MenuController {
    MenuView menu = new MenuView();
    NhanVienController controller = new NhanVienController();
    NhanVienView view = new NhanVienView();

    public void menu() {
        try {
            while (true) {
                switch (menu.mainMenu()) {
                    case "1":
                        controller.addNhanVien();
                        break;
                    case "2":
                        controller.findNhanVien();
                        break;
                    case "3":
                        controller.edit(-1);
                        break;
                    case "4":
                        controller.deleteNhanVien();
                        break;
                    case "5":
                        controller.showListNhanVien();
                        break;
                    case "6":
                        controller.checkWorkingOrNot();
                        break;
                    case "7":
                        controller.setStatusNhanVien();
                        break;
                    case "8":
                        controller.getInfo();
                        break;
                    case "9":
                        controller.logOut();
                        break;
                    case "10":
                        System.exit(10);
                    default:
                        view.error();
                }
            }
        } catch (Exception e) {
            view.error();
            e.printStackTrace();
            menu();
        }
    }
}
