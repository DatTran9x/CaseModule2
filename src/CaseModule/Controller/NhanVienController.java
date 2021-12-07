package CaseModule.Controller;

import CaseModule.Model.Admin;
import CaseModule.Service.NhanVienService;
import CaseModule.View.NhanVienView;

public class NhanVienController {
    static NhanVienService service = new NhanVienService();
    static NhanVienView view = new NhanVienView();
    boolean isAdmin;

    public void checkLogin(String account, String password) {
        boolean check = service.logIn(account, password);
        if (check) {
            int index = service.getIndexAccount(account);
            isAdmin = service.getList().get(index) instanceof Admin;
            choice();
        } else {
            logOut();
        }
    }

    public void choice() {
        try {
            while (true) {
                switch (view.menu()) {
                    case "1":
                        addNhanVien();
                        break;
                    case "2":
                        findNhanVien();
                        break;
                    case "3":
                        edit(-1);
                        break;
                    case "4":
                        deleteNhanVien();
                        break;
                    case "5":
                        showListNhanVien();
                        break;
                    case "6":
                        checkWorkingOrNot();
                        break;
                    case "7":
                        setStatusNhanVien();
                        break;
                    case "8":
                        getInfo();
                        break;
                    case "9":
                        logOut();
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
            choice();
        }
    }

    private void logOut() {
        view.logIn();
    }

    private void checkWorkingOrNot() {
        view.showStatus(service.checkStatusNhanVien(getIndex()));
    }

    private void showListNhanVien() {
        view.showListNhanVien(service.getList());
    }

    private void addNhanVien() {
        if (isAdmin) {
            String choose = view.choose();
            if(choose.equals("4")) return;
            service.addNhanVien(view.createNhanVien(choose));
        } else view.noAcess();
    }

    private void setStatusNhanVien() {
        if (isAdmin) {
            int tempIndex = getIndex();
            service.setStatusNhanVien(tempIndex);
            view.showStatus(service.checkStatusNhanVien(tempIndex));
        } else view.noAcess();
    }

    private void deleteNhanVien() {
        if (isAdmin) service.deleteNhanVien(getIndex());
        else view.noAcess();
    }

    private void findNhanVien() {
        int tempIndex = getIndex();
        view.showNhanVien(service.getList().get(tempIndex));
        if (isAdmin) {
            switch (view.chooseWhatToDoWithNhanVien()) {
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

    private void edit(int tempIndex) {
        if (!isAdmin) {
            view.noAcess();
            return;
        }
        if (tempIndex == -1) {
            switch (view.chooseWhatToEdit()) {
                case "1":
                    service.editNhanVien(getIndex(), view.createNhanVien(view.choose()));
                    break;
                case "2":
                    service.editGioLam(getIndex(), view.getGioLam());
                    break;
                case "3":
                    view.backToMenu();
                    break;
                default:
                    view.error();
                    edit(-1);
            }
        } else {
            switch (view.chooseWhatToEdit()) {
                case "1":
                    service.editNhanVien(tempIndex, view.createNhanVien(view.choose()));
                    break;
                case "2":
                    service.editGioLam(tempIndex, view.getGioLam());
                    break;
                case "3":
                    view.backToMenu();
                    break;
                default:
                    view.error();
                    edit(-1);
            }
        }
    }

    private void getInfo() {
        switch (view.info()) {
            case "1":
                view.showInfo(service.getList().get(getIndex()));
                break;
            case "2":
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
                break;
            case "3":
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
                break;
            case "4":
                if (isAdmin) {
                    int tempindex = getIndex();
                    if (service.checkAccountExist(tempindex))
                        service.signIn(tempindex, null, null);
                    else view.error();
                } else view.noAcess();
                break;
            case "5":
                break;
            default:
                System.err.println("VUI LONG CHON LAI!");
                getInfo();
                break;
        }
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