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
        int count = 0;
        for (int n = 2; count < 20 ; n++) {
            boolean isPrime = true;

            for (int i = 2; i < 20 ; i++) {
                if (n % i ==0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.println(n +"");
                count++;
            }
        }
    }
}