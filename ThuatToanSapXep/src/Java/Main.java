package Java;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {29, 10, 14, 37, 14, 6, 48, 5, 2};
        bubbleSort(numbers);
        selectionSort(numbers);
        insertionSort(numbers);
    }

    public static void bubbleSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.println("Array : " + Arrays.toString(numbers));
    }

    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int indexOfMinElement = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] < numbers[indexOfMinElement]) {
                    indexOfMinElement = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[indexOfMinElement];
            numbers[indexOfMinElement] = temp;
        }
        System.out.println("Array: " + Arrays.toString(numbers));
    }

    public static void insertionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    int temp =  numbers[j];
                    numbers[j] = numbers[j - 1];
                    numbers[j - 1] = temp;
                }
            }
        }
        System.out.println("Array: " + Arrays.toString(numbers));
    }

}