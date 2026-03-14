import java.util.Arrays;

public class Mang {
    public static void main(String[] args) {

        //là 1 biến chứa tập hợp các giá trị liên quan đến nhau
        //cách khai báo java:
        int[] numbers = {1, 2, 10};
        //chỉ số: vị trí của các phần tử tring mảng, bắt đầu từ 0, vị trí cuối luôn là length - 1 ( index )
        //phẩn tử: các giá trị ở trong mảng ( element )
        System.out.println(numbers[2]);
        // độ dài mảng: số lượng phần tử trong mảng
        System.out.println(numbers.length);
        //thay đổi giá trị phẩn tử tại 1 vị trí
        numbers[2] = 4;
        System.out.println(numbers[2]);
        //duyệt mảng
        System.out.println("Duyet mang: ");
        //cách 1: dùng fori
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        //cách 2: dùng for each
        System.out.println("Duyet bang for each");
        for (int element : numbers) { // duyệt qua và lấy từng phần tử gán cho element
            System.out.println(element);
        }

        System.out.println("Duyet mang khai bao moi");
        int[] arr = new int[10]; // khai báo khác, đang khai báo 1 mảng 10 phần tử
        //Tùy theo kiểu dữ liệu của mảng khi khai báo như trên các phần tử sẽ có giá trị mặc định
        // int = 0, double = 0.0, String hoặc các kiểu định nghĩa bằng class ~ null, boolean ~ false
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println(Arrays.toString(arr)); //in nhanh 1 mảng
        showHello(); // gọi hàm

        int number1 = 1;
        int number2 = 2;
        int total = getTotal(number1, number2); // number 1 và 2 dối số: Giá trị thực sự sử dụng thay cho tham số truyền vào
        //gọi hàm và hứng giá trị trả về
        System.out.println("total" + total);

    }

    public static void showHello() {
        System.out.println("Hello world");
    }

    public static int getTotal(int a, int b) {  // a, b: Tham số truyền vào: là các biến giả định cho dữ liệu truyền vào
        int sum = a + b;
        return sum;
    }
}
