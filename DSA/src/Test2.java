import java.util.LinkedList;

public class Test2 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(4);
        list.add(6);
        System.out.println("Size: " + list.size());

        System.out.println("Before: ");
        for (Integer e : list) {
            System.out.println(e);
        }

        System.out.println("After: ");
        //list.remove(2);
        list.set(2, -6);
        for (Integer e : list) {
            System.out.println(e);
        }

        System.out.println("Get element index 2: " + list.get(2));
    }
}

/*
Vơi các thao tác truy xuất ngâũ nhiên thì arraylist nhanh hơn.
Với các thao tác thêm, sửa, xóa thì linkedlist nhanh hơn.
 */


/*
Cho 1 ArrayList Số nguyên:
Viết menu cho phép người dùng thêm, sửa, xóa, xem thông tin của list đó.

============= Menu ==============
1.Thêm
    Vui lòng nhập dữ liêu: 4
    _ thêm
4.Hiển thị
    Danh sách: 4, 5

Sử dụng scaner và vòng lặp
 */