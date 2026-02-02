package users;

import accounts.Account;

public class MainV3 {
    public static void main(String[] args) {
        Account account = new Account(2, "ning111", "123456");
//        System.out.println(account.); // không thể sử dụng vì ngoài package

        User user = new User("lINH", 29);
        User user1 = new User("Hướng");
    }
}