package Java;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(6);
        numbers.add(8);
        numbers.add(3);
        numbers.add(9);
        numbers.add(20);
        numbers.add(12);

        int K = 9;
        int index = linearSearch(numbers, K);
//        int index  = sentinelSearch(numbers, K);
        if ( index != 1) {
            System.out.println("Index of " + K + ": " + index);
        }else {
            System.out.println("Array not include: " + K);
        }

    }

    public static int linearSearch(ArrayList<Integer> numbers, int K) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == K) {
                return i;
            }
        }
        return  -1;
    }

}