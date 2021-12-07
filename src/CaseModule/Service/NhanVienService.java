package CaseModule.Service;

import CaseModule.IO.ReadAndWrite;
import CaseModule.Model.NhanVien;

import java.util.List;

public class NhanVienService {
    private final List<NhanVien> nhanViens;

    public NhanVienService() {
        nhanViens = ReadAndWrite.readNhanVien();
    }

    public void addNhanVien(NhanVien nhanVien) {
        nhanViens.add(nhanVien);
        ReadAndWrite.writeNhanVien(nhanViens);
    }

    public int findNhanVien(String name) {
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isNameValid(String name) {
        for (NhanVien nv : nhanViens) {
            if (nv.getName().equals(name)) return true;
        }
        return false;
    }

    public String checkStatusNhanVien(int index) {
        return nhanViens.get(index).isStatus();
    }

    public void deleteNhanVien(int index) {
        nhanViens.remove(index);
        ReadAndWrite.writeNhanVien(nhanViens);
    }

    public List<NhanVien> getList() {
        return nhanViens;
    }

    public void editNhanVien(int index, NhanVien nhanVien) {
        nhanViens.set(index, nhanVien);
        ReadAndWrite.writeNhanVien(nhanViens);
    }

    public void setStatusNhanVien(int index) {
        nhanViens.get(index).setStatus(!nhanViens.get(index).isStatus().equals("Dang lam viec"));
    }

    public boolean logIn(String account, String password) {
        try {
            for (NhanVien nhanVien : nhanViens) {
                if (nhanVien.getAccountName() == null) {
                    continue;
                }
                if (nhanVien.getAccountName().equals(account) && nhanVien.getPassword().equals(password)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkAccountExist(int index) {
        return nhanViens.get(index).getAccountName() == null;
    }

    public boolean checkACccountNameDupplicate(String name) {
        for (NhanVien nv : nhanViens) {
            if (nv.getAccountName() == null) continue;
            if (nv.getAccountName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public void signIn(int index, String account, String password) {
        nhanViens.get(index).setAccountName(account);
        nhanViens.get(index).setPassword(password);
        ReadAndWrite.writeNhanVien(nhanViens);
    }

    public int getIndexAccount(String account) {
        for (int i = 0; i < nhanViens.size(); i++) {
            if (nhanViens.get(i).getAccountName() == null) continue;
            if (nhanViens.get(i).getAccountName().equals(account)) {
                return i;
            }
        }
        return -1;
    }

    public void editGioLam(int index, double gioLam) {
        nhanViens.get(index).setGioLam(gioLam);
        ReadAndWrite.writeNhanVien(nhanViens);
    }
}
