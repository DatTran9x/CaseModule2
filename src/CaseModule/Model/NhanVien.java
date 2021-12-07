package CaseModule.Model;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private String name;
    private int age;
    private String gender;
    private boolean status = true;
    private int luongTheoGio;
    private String accountName=null;
    private String password=null;
    private double gioLam;

    public NhanVien(String name, int age, String gender, int luongTheoGio) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.luongTheoGio = luongTheoGio;
    }

    public NhanVien() {
    }

    public int getLuongTheoGio() {
        return luongTheoGio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public double getLuongTong() {
        return luongTheoGio * gioLam;
    }

    public String isStatus() {
        if (status) {
            return "Dang lam viec";
        } else {
            return "Nghi";
        }
    }

    public double getGioLam() {
        return gioLam;
    }

    public void setGioLam(double gioLam) {
        this.gioLam = gioLam;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "Partime "+
                " name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", status=" + isStatus() +
                ", salary=" + luongTheoGio +
                ", giolam=" +gioLam+
                ", luong=" + getLuongTong() +
                '}';
    }

    public String getInfo() {
        return "Account name=" + accountName +
                ", password=" + password;
    }
}
