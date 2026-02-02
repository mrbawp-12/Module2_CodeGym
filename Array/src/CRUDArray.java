public class CRUDArray {

    public static void main(String[] args) {
        int[] numbers = new int[10]; // length = 10;
        int size = 0;
        size = addElement(numbers, size, 4); // Ctr + D: Nhân đôi dòng
        size = addElement(numbers, size, 11);
        size = addElement(numbers, size, 6);
        size = addElement(numbers, size, 9);
//        System.out.println("Truoc xoa: ");
//        showArray(numbers, size);
//        size = removeElement(numbers, size, 1);
//        System.out.println("Sau xoa: ");
//        showArray(numbers, size);

        // Insert
        System.out.println("Truoc chen: ");
        showArray(numbers, size);
        size = insertElement(numbers, size, -8, 1);
        System.out.println("Sau chen: ");
        showArray(numbers, size);
    }

    // Phương thức của khuôn mẫu ~ tất cả đôi tượng đều có
    public static int insertElement(int[] numbers, int size, int newElement ,int insertIndex) {
        for (int i = size - 1; i >= insertIndex; i--) {
            numbers[i + 1] = numbers[i];
        }
        numbers[insertIndex] = newElement;
        size++;
        return size;
    }

    public static int removeElement(int[] numbers, int size, int removeIndex) {
        for (int i = removeIndex; i < size; i++) {
            numbers[i] = numbers[i + 1];
        }
        size--;
        return size;
    }

    public static int addElement(int[] numbers, int size, int newElement) {
        // Add đến gần phần tử cuối mà quá sức chứa => clone mảng hiện ra mới có sức chứa cao hơn
        numbers[size] = newElement;
        size++;
        return size;
    }

    public static void showArray(int[] numbers, int size) {
        System.out.println("Cac phan tu co trong mang: ");
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            String elementStr = numbers[i] + ""; // 1 số + 1 chuỗi => 1 chuỗi
            if (i != size - 1) {
                elementStr += ", ";
            }
            System.out.print(elementStr);
        }
        System.out.println(" ]");
    }

    // ArrayList: 1 Collection đã tích hợp các thao tác thêm sửa xóa bên trong
}