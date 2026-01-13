import java.util.Scanner;

public class Loop {
    /*
    for
    while
    do while
     */

    public static void main(String[] args) {
//        for(int i = 1; i <= 5; i++){
//            System.out.println("Hoc modile: " + i);
//        }
//
//       int i = 1;
//        while (i <= 5){ //vong lap while chỉ quan tam dk lặp true thì chạy, false thì dừng
//            System.out.println("Hoc module: " + i);
//            i++;
//        }
//        //cho người dùng nhập 1 số, đến khi nhập 0 thì kết thúc nếu nhâp cac số khác thò bắt nhập lại
//        Scanner input = new Scanner(System.in);
//        int a;
//        do {
//            System.out.println("Nhap a: ");
//            a = input.nextInt();
//        }while (a != 0);
//        System.out.println("End");

        //viết nhanh: fori + tab
        // Ctrl + /  : comment code
//        for (int i = 1; i < 10; i++) {
//            System.out.println(i);
//            if (i == 5){
//                break;
//            }
//        }

        //hiển thị 20 số nguyên tố đầu tiên
        //số nguyên tố là các số CHỈ chia được 1 và chính nó ( chỉ có 2 ước)
        //kiểm tra 1 số xem có phải số nguyên tố hay không => hiển thị 20 số nguyên tố

//        int count = 0;
//        for (int n = 2; count < 20 ; n++) {
//            boolean isPrime = true;
//
//            for (int i = 2; i < 20 ; i++) {
//                if (n % i ==0){
//                    isPrime = false;
//                    break;
//                }
//            }
//            if (isPrime){
//                System.out.println(n +"");
//                count++;
//            }
//        }

//        int number = 1;
//        int countPrime = 0;
//        System.out.println("20 so nguyen to dau tien: ");
//        while (countPrime < 20) {
//            int count = 0;
//            for (int i = 1; i <= number; i++) {
//                if (number % i == 0) {
//                    count++;
//                }
//            }
//            if (count == 2) {
//                System.out.println(number);
//                countPrime++;
//            }
//            number++;
//        }

        //hiển thị hình
//        for (int i = 1; i <= 5; i++) { //dòng i = 1
//            for (int j = 1; j <= i; j++) { // * trong dòng
//                System.out.print("* ");
//            }
//            System.out.print("\n");
//        }

        for (int i = 1; i <= 5; i++) { //dòng i = 1
            for (int j = 1; j <= 6 - i; j++) { // * trong dòng
                System.out.print("* ");
            }
            System.out.print("\n");
        }

    }
}