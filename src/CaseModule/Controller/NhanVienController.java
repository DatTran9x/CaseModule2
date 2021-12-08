package CaseModule.Controller;

import CaseModule.Model.Admin;
import CaseModule.Service.NhanVienService;
import CaseModule.View.MenuView;
import CaseModule.View.NhanVienView;

public class NhanVienController {
    static NhanVienService service = new NhanVienService();
    static NhanVienView view = new NhanVienView();
    static MenuView menu = new MenuView();
    static boolean isAdmin;

    public void checkLogin(String account, String password) {
        boolean check = service.logIn(account, password);
        if (check) {
            int index = service.getIndexAccount(account);
            isAdmin = service.getList().get(index) instanceof Admin;
            new MenuController().menu();
        } else {
            logOut();
        }
    }

    protected void logOut() {
        menu.logInMenu();
    }

    protected void checkWorkingOrNot() {
        view.showStatus(service.checkStatusNhanVien(getIndex()));
    }

    protected void showListNhanVien() {
        view.showListNhanVien(service.getList());
    }

    protected void addNhanVien() {
        if (isAdmin) {
            String choose = menu.addMenu();
            if (choose.equals("4")) return;
            service.addNhanVien(view.createNhanVien(choose));
        } else view.noAcess();
    }

    protected void setStatusNhanVien() {
        if (isAdmin) {
            int tempIndex = getIndex();
            service.setStatusNhanVien(tempIndex);
            view.showStatus(service.checkStatusNhanVien(tempIndex));
        } else view.noAcess();
    }

    protected void deleteNhanVien() {
        if (isAdmin) {
            service.deleteNhanVien(getIndex());
            view.deleteSuccess();
        } else view.noAcess();
    }

    protected void findNhanVien() {
        int tempIndex = getIndex();
        view.showNhanVien(service.getList().get(tempIndex));
        if (isAdmin) {
            switch (menu.findMenu()) {
                case "1":
                    edit(tempIndex);
                    break;
                case "2":
                    service.deleteNhanVien(tempIndex);
                    break;
                case "3":
                    view.backToMenu();
                    break;
                default:
                    findNhanVien();
            }
        }
    }

    protected void edit(int tempIndex) {
        if (!isAdmin) {
            view.noAcess();
            return;
        }
        if (tempIndex == -1) {
            editNhanVien(getIndex());
        } else {
            editNhanVien(tempIndex);
        }
    }

    private void editNhanVien(int index) {
        switch (menu.editMenu()) {
            case "1":
                service.editNhanVien(index, view.createNhanVien(menu.addMenu()));
                break;
            case "2":
                service.editGioLam(index, view.getGioLam());
                break;
            case "3":
                view.backToMenu();
                break;
            default:
                view.error();
                edit(-1);
        }
    }

    protected void getInfo() {
        switch (menu.accountMenu()) {
            case "1":
                showInfo();
                break;
            case "2":
                createAccount();
                break;
            case "3":
                editAccount();
                break;
            case "4":
                deleteAccount();
                break;
            case "5":
                break;
            default:
                System.err.println("VUI LONG CHON LAI!");
                getInfo();
                break;
        }
    }

    private void deleteAccount() {
        if (isAdmin) {
            int tempindex = getIndex();
            if (service.checkAccountExist(tempindex))
                service.signIn(tempindex, null, null);
            else view.error();
        } else view.noAcess();
    }

    private void editAccount() {
        if (isAdmin) {
            int tempindex = getIndex();
            String accountName = view.getAccountName();
            String password = view.getPassword();
            if (service.checkACccountNameDupplicate(accountName)) {
                service.signIn(tempindex, accountName, password);
            } else {
                view.accountNameExist();
            }
        } else view.noAcess();
    }

    private void createAccount() {
        if (isAdmin) {
            int tempindex = getIndex();
            if (service.checkAccountExist(tempindex)) {
                String accountName = view.getAccountName();
                String password = view.getPassword();
                if (service.checkACccountNameDupplicate(accountName)) {
                    service.signIn(tempindex, accountName, password);
                } else {
                    view.accountNameExist();
                }
            } else view.accountExist();
        } else view.noAcess();
    }

    private void showInfo() {
        view.showInfo(service.getList().get(getIndex()));
    }

    private int getIndex() {
        int tempIndex = service.findNhanVien(view.getName());
        if (tempIndex == -1) return getIndex();
        return tempIndex;
    }

    public boolean checkName(String name) {
        return service.isNameValid(name);
    }
}