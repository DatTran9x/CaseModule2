package CaseModule.Model;

public class FullTime extends NhanVien {
    private double coefficients;

    public FullTime() {
    }

    public FullTime(String name, int age, String gender, int salaryByHours, double coefficients) {
        super(name, age, gender, salaryByHours );
        this.coefficients = coefficients;
    }

    @Override
    public double getLuongTong(){
        return super.getLuongTong()*coefficients;
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "Fulltime "+
                " name='" + getName() + '\'' +
                ", age=" + getName() +
                ", gender='" + getGender() + '\'' +
                ", status=" + isStatus() +
                ", salary=" + getLuongTheoGio() +
                ", giolam=" +getGioLam()+
                ", luong=" + getLuongTong() +
                ", coefficients=" + coefficients +
                '}';
    }
}
