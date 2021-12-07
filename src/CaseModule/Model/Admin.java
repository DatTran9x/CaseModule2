package CaseModule.Model;

public class Admin extends NhanVien{
    public Admin() {
    }

    public Admin(String name, int age, String gender, int luongTheoGio) {
        super(name, age, gender, luongTheoGio);
    }

    @Override
    public String toString(){
        return  "NhanVien{" +
                "ADMIN "+
                " name='" + getName() + '\'' +
                ", age=" + getName() +
                ", gender='" + getGender() + '\'' +
                ", status=" + isStatus() +
                ", salary=" + getLuongTheoGio() +
                ", giolam=" +getGioLam()+
                ", luong=" + getLuongTong() +
                '}';
    }
}
