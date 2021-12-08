package CaseModule.View;

import CaseModule.Controller.NhanVienController;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    Scanner scanner = new Scanner(System.in);
    NhanVienController controller = new NhanVienController();
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
            regex = validateName();
        }
        return regex;
    }

    public String validateGender() {
        while (true) {
            String gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("nam")) return "Nam";
            if (gender.equalsIgnoreCase("nu")) return "Nu";
            System.err.println("VUI LONG NHAP NAM HOAC NU!");
        }
    }

    protected double validateGioLam() {
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

    public int validateNumber() {
        try {
            String number = scanner.nextLine();
            int so = Integer.parseInt(number);
            if (so < 0) {
                System.err.println("VUI LONG NHAP LAI!");
                return validateNumber();
            }
            return so;
        } catch (Exception e) {
            System.err.println("VUI LONG NHAP SO!");
            return validateNumber();
        }
    }
}
