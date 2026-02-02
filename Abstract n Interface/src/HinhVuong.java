package abstr;

public class HinhVuong extends Hinh {
    // abstract class dùng khi có trừu tượng trong mỗi quan hệ is-a
//    Một class non-abstract kế thừa 1 class abstract sẽ phải triển
//    khai tất cả phương thức abstract ở class cha
    private int canh;

    public HinhVuong(String name, int canh) {
        super(name);
        this.canh = canh;
    }

    // Triền khai 2 phương thức abstract
    @Override
    public double getS() {
        return  this.canh * this.canh;
    }

    @Override
    public double getC() {
        return this.canh * 4;
    }

}