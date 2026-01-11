import java.util.Scanner;

public class Nhunhi {
    public static void main(String[] args) {
//Tên file trung ten class
//main, psvm + tab : cú pháp tạo hàm để chạy chương trình
        System.out.println("dong duc là 1 con chó ngu"); //sout + tab

// sắp xếp code : Ctrl + Alt + L
//biến kiểu dữ liệu điều kiện vòng lặp hàm toán tử

//biến là tên gọi 1 vùng nhớ chứa dữ liệu
    /*
    Khai báo 1 biến trong Java
    <kieu_du_lieu> <ten_bien> = <gia_tri>
   */
        //Số(Number): Số nguyên (int), số thực (double)
        //Chuỗi(Spring)
        //Logic(Boolean)
        int a = 1;
        a = 3;
        double c = 2.7;
        String name = "Linh"; //chuỗi trong Java: ""
        char d = 'c'; //Kiểu ký tự
        boolean isSick = true; //2 loại giá trị true or false

        //Toán tử là các ký hiệu cho phép tương tác với giá trị của các biến
        /*
        Toán tử gán: + += -= *= /= %=
        Toán tử toán học: + - * / %
        Toán tử so sánh: == > < >= <= != (luôn trả lại giá trị boolean)
        Toán tử logic: && || !
         */

        boolean g = 5 > 3;
        System.out.println("5 > 3:" + g);

        //kiểu hỗ trợ cho nhập xuất dữ liệu
        Scanner input = new Scanner(System.in);//System.in : đại diện cho dữ liệu lấy từ bàn phím

        System.out.println("Vui long nhap ten: ");
        String fullName = input.nextLine();//nextLine(): hàm cho phép nhập chuỗi
        System.out.println("Full Name: " + fullName);
        //Ctrl + Space: Bật gợi ý
        System.out.println("Nhap tuoi cua ban: ");
        int age = input.nextInt();//Nhập số nguyuên
        System.out.println("Tuoi cua ban la: " + age);
    }


}
