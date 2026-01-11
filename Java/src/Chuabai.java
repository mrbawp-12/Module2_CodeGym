import java.util.Scanner;

public class Chuabai {

    public static void main(String[] args) {
        //Bài 1: Chuyển từ độ C sang độ F
//        Scanner input = new Scanner(System.in);
//        System.out.println("Vui long nhap do C: ");
//        double doC = input.nextDouble();
//        //°C  x  9/5 + 32 = °F
//        double doF = doC  *  9/5 + 32;
//        System.out.println("==> Do F: " + doF);

        //tím số lớn nhất trong 3 số
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap a: ");
        int a = input.nextInt();
        System.out.println("Nhap b: ");
        int b = input.nextInt();
        System.out.println("Nhap c: ");
        int c = input.nextInt();

        int max = a;
        if (max < b) {
            max = b;
        }
        if (max < c) {
            max = c;
        }
        System.out.println("Max = " + max);
    }
}
