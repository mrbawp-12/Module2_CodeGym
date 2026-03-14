package java;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        Stack<Integer> numbers = new Stack<>();
        System.out.println("Is empty: " + numbers.empty());
        numbers.push(4); // thêm phần tử
        numbers.push(10);
        numbers.push(-32);

        System.out.println("Stack: ");
        for(Integer e: numbers) {
            System.out.println(e);
        }

        System.out.println("Get first: " + numbers.peek()); // -32
        numbers.pop(); // get and remove first element;
        numbers.pop();
        System.out.println("Get first: " + numbers.peek()); // 10
         */

        /*
        Queue<Integer> numbers = new LinkedList<>();
        numbers.add(3);
        numbers.add(4);
        numbers.add(10);
        numbers.add(-20);
        System.out.println("First: " + numbers.peek()); // 3
        numbers.remove(); // Get and remove first element (get and remove 3)
        System.out.println("Get and remove : " + numbers.remove()); // 4
        System.out.println("First: " + numbers.peek()); // 10
         */
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Linh");
        map.put(2, "Huong");
        map.put(3, "Long");
        map.put(4, "Duc");
        // map.remove(1);
        map.replace(1, "Ning"); // <=> map.put(1, "Ning"); => Sửa giá trị dựa trên key
        // System.out.println(map.get(1));
        // Lấy danh sách key:
        Set<Integer> keys = map.keySet();
        /*
         Set là 1 loại CTDL tương tự ArrayList nhưng các phần tử bên
         trong không đuợc trùng nhau
        */

        System.out.println("Map: ");
        for (Integer k: keys) {
            System.out.println(map.get(k));
        }

        // Tree
        NavigableSet<String> ts = new TreeSet<>();

        // Elements are added using add() method
        ts.add("Beek");
        ts.add("AHHH");
        ts.add("Ceeks");
        System.out.println("First Value " + ts.first());

        // Print all elements inside object
        System.out.println(ts);
    }
}