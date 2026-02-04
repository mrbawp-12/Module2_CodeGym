import java.util.ArrayList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        // bản chất của ArrayList : là 1 class có thuộc tính là 1 mảng và có các hàm để
        // thêm, sửa, xóa và lấy ra dữ liệu từ mảng đó đã được xây dựng sẵn thuộc Java Collection FrameWork

        arrayList.add(21); // thêm dữ liệu
        arrayList.add(18);
        arrayList.add(12);
        arrayList.add(5);

        System.out.println("Size array: " + arrayList.size());
        System.out.println("Get element index 0: " + arrayList.get(0));
        // duyệt
        System.out.println("Before: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("Index: " + i + " - Element: " + arrayList.get(i));
        }
//        arrayList.remove(2); // xóa ở vị trí 2
        arrayList.set(1, -18); // sửa ở vị trí 1 thay bằng -18

        System.out.println("After: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("Index: " + i + " - Element: " + arrayList.get(i));
        }

        // For-each: có thể hoạt động với các Collection hoặc mảng
//        for (Integer e: arrayList) {
//            System.out.println("Element: " + e);
//        }


    }
}


//(Tạo mỗi lớp môt file)
//Cho một lớp Student có id, name, giới tính, có các hàm get/set
//Một lớp StudentManager thuộc tính là một mảng các sinh viên,
// thực hiện tạo các hàm thêm, sửa, xóa sinh viên.
//+ Tạo hàm tìm kiếm học viên theo ID.
//+ Tạo hàm tìm kiếm học viên theo tên gần đúng . ( contains)
//Tạo một lớp Main thực hiện tạo các đối tượng sinh viên rồi sử dụng các hàm đã có ở StudentManager

