package lib;

import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    public static String inputSring(){
        String str = input.nextLine();
        return str;
    }

    public static int InputInt(){
        do {
            try {
                int num = Integer.parseInt(input.nextLine());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Wrong format, please enter input agian!");
            }
        } while (true);
    }
}
