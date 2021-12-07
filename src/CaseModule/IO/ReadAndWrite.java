package CaseModule.IO;

import CaseModule.Model.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List<NhanVien> readNhanVien() {
        try {
            File file = new File("C:\\CaseModule2\\src\\CaseModule\\Data\\NhanVien.txt");
            if (!file.isFile()) {
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream("C:\\CaseModule2\\src\\CaseModule\\Data\\NhanVien.txt");

            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                return (List<NhanVien>) objectInputStream.readObject();
            }
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeNhanVien(List<NhanVien> nhanViens)  {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\CaseModule2\\src\\CaseModule\\Data\\NhanVien.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(nhanViens);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}
