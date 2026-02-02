public class BTMang {
    public static void main(String[] args) {
        //tạo 1 hàm nhập vào 1 mảng số nguyên và thực hiện trả về tổng của các phần tử chẵn
        int[] numbers = {1, 4, 6, 6, 4};
        int total = getTotal(numbers);
        System.out.println("Total: " + total);

    }

    public static int getTotal(int[] numbers) {
        int total = 0;
        for (int e : numbers) {
            if (e % 2 == 0) {
                total = total + e;
            }
        }
        return total;
    }


}
