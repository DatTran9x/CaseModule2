package CaseModule.Model;

public class Admin extends FullTime{


    public Admin() {
    }

    public Admin(String name, int age, String gender, int salaryByHours, double coefficients) {
        super(name, age, gender, salaryByHours, coefficients);
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
