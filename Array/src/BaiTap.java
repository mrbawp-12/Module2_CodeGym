import java.util.Arrays;

public class BaiTap {
    public static void main(String[] args) {
        // Tạo 1 hàm nhận vào 1 mảng số nguyên và thực hiện trả về tổng của các phần tử chẵn;
        int[] numbers = {1, 4, 6, 6, 0};
        int total = getTotal(numbers);
        System.out.println("Total: " + total);
        String test = "abc";
        System.out.println(test.contains("ab"));
        String[] test2 = test.split("");
        System.out.println(Arrays.toString(test2));
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


    // [1, 4, 2, 2, 4]
    public int singleNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                // kiểm tra từ i đến những phần tử sau
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            for (int j = i - 1; j >= 0; j--) {
                // kiểm tra các phần tử trước i
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count == 1) {
                return nums[i];
            }
        }
        return 0;
    }


    // doing
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            String[] e = strs[i].split("");
            if(e.length == 1) {
                continue;
            }
            String text = e[0] + e[1]; // lấy 2 từ đầu
            int count = 0;
            for (int j = 0; j < strs.length; j++) {
                if(strs[j].contains(text)) {
                    count++;
                }
            }
            if(count == strs.length) {
                return text;
            }
        }
        return "";
    }
}


// Tạo các hàm để thêm, sửa, xóa phần tử trong mảng.
