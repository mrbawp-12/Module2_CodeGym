package accounts;

public class MainV2 {
    public static void main(String[] args) {
        Account account =  new Account(1, "ning1704", "123456");
        account.username = "long";
        account.checkPwd();
    }
}
