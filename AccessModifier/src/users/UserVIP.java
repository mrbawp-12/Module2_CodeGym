package users;

public class UserVIP {
    // Khi khai báo thành phần dữ liệu là private thì sẽ chỉ có thể sử dụng ở trong class đó

    private int id; // THường các thuộc tính ở các dự án sẽ để private
    // muốn lấy ra thì sử dụng hàm public get, sửa thì sử dụng hàm public set
    private String fullName;
    private String name;

    public UserVIP(int id, String fullName, String name) {
        this.id = id;
        this.fullName = fullName;
        this.name = name;
    }

    private void eat() {
        System.out.println("user is eating");
    }

    public int getId() { // hàm get: lấy thông tin
        return this.id;
    }

    public void setId() { // hàm set: sửa thông tin
        this.id = id;
    }

    //    public static void main(String[] args) {
//        UserVIP userVIP = new UserVIP(1, "Duc Dong", "duc");
//        System.out.println(userVIP.id);
//    }

}