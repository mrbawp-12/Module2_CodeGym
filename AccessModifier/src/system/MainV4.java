package system;

public class MainV4 {
    public static void main(String[] args) {
        UserSystem userSystem = new UserSystem(); // sử dụng trong phạm vi cùng package
        System.out.println(userSystem.id);
        System.out.println(userSystem.name);
        userSystem.manageAccounts();
    }
}
