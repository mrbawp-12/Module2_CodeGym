package abstr;

public class Main {
    public static void main(String[] args) {
        // abstr.Hinh hinh = new abstr.Hinh("Haha");
        // Không thể khởi tạo đối tượng cho abstract class

     HinhVuong hinhVuong =  new HinhVuong("vuong", 4);
     hinhVuong.showName();
        System.out.println("S = " + hinhVuong.getS());
        System.out.println("C = " + hinhVuong.getC());
    }
}