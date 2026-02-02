package accounts;

import system.UserSystem;

public class Account extends UserSystem {
    // default: Trong cùng 1 package;

    int id;
    String username;
    String pwd;

    public Account(int id, String username, String pwd) {
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    void checkPwd() {
        System.out.println("Check pwd");
    }

    void getName() {
        System.out.println(this.name); // ngoài package trong mqh kế thừa
        this.manageAccounts();
    }

}
