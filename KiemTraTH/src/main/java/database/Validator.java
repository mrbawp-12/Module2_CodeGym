package database;

public class Validator {

    // kiem tra so dien thoai: chi gom so, do dai 10-11 ky tu
    public static boolean isValidPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) return false;
        return phone.matches("\\d{10,11}");
    }

    // kiem tra email co dung dinh dang co chua ky tu @ va . sau @, va phan duoi co it nhat 2 ky tu
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) return false;
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    // kiem tra truong bat buoc khong duoc de trong va khong chi gom ky tu trang
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}