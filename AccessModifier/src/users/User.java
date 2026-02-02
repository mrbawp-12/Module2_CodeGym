package users;

public class User { // public ở class sẽ cho phép export class này cho nơi khác có thể sử dụng
    public int age; // Khi để từ khóa public thì có thể sử dingj ở bất cứ đâu trong dự án
    public String name;

    // constructơr
    public User(String nameInput, int  ageInput) { // Nhà máy tạo các đối tượng
        this.age = ageInput;
        this.name = nameInput;
    }

    public User(String nameInput) {
        this.name = nameInput;
    }

    public void run(int a) {
        System.out.println("Person is running");
    }

}
