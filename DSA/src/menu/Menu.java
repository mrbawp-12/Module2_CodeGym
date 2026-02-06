package menu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<Integer> list = new ArrayList<>();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputStr = new Scanner(System.in);

    public void showMenu() {
        int choice;
        do {
            System.out.println("============== Menu ===============\n" +
                    "1.Add\n" +
                    "2.Edit\n" +
                    "3.Delete\n" +
                    "0.Exit\n"
                    );
            System.out.println("Enter your choice: ");
            choice = inputNumber.nextInt();
            switch (choice) {
                case 1:
                    this.showAddMenu();
                    break;
                case 2:
                    this.showEditMenu();
                    break;
                case 3:
                    this.showDeleteMenu();
                    break;
                case 4:
                    this.showAll();
                    break;
            }
        }while (choice!= 0);
    }

    public void showEditMenu() {
        System.out.println("Enter edit index: ");
        int index = this.inputNumber.nextInt();
        System.out.println("Enter new number: ");
        int newNumber = this.inputNumber.nextInt();
        this.list.set(index, newNumber);
        System.out.println("Edited!");
    }

    public void showDeleteMenu() {
        System.out.println("Enter delete index: ");
        int index = this.inputNumber.nextInt();
        this.list.remove(index);
        System.out.println("Deleted!");
    }

    public void showAll() {
        System.out.println("Your number: ");
        for (Integer e: this.list){
            System.out.println(e);
        }
    }

    public void showAddMenu() {
        System.out.println("Enter a number: ");
        int numer = this.inputNumber.nextInt();
        this.list.add(numer);
        System.out.println("Add successfully!");
    }
}

class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showMenu();
    }
}

/*
=> Thực hành theo demo bài menu trên và thêm tính năng:
+ Hiển thị các số chẵn
+ Cho người dùng nhập 1 số và hiển thị số lần xuất hiện của số đó trong danh sách.
+ Hiển thị số lớn nhất.
+ Hiển thị số nhỏ nhất.
+ Cho người dùng nhập vào 2 số (from, to) và hiển thị danh sách các số trong khoảng 2 số đó.
 */