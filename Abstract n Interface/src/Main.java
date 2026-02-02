package abstr;

public class Main {
    public static void main(String[] args) {
        // abstr.Hinh hinh = new abstr.Hinh("Haha");
        // không thể khởi tạo đối tượng cho abstract class

        abstr.HinhVuong hinhVuong = new abstr.HinhVuong("vuong", 4);
        hinhVuong.showName();
        System.out.println("S = " +hinhVuong.getS());
        System.out.println("C = " +hinhVuong.getC());
    }
}