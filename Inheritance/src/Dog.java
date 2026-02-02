public class Dog extends Animal { //Dog k thừa Animal
    int age;
    String mauLong;
//    String name = "Dog default name";

    public Dog(String name, int age, String mauLong) {
        super(name); // khởi tạo thành phần dữ liệu ở lớp cha
        this.age = age;
        this.mauLong = mauLong;
    }
    // chuỗi constructor

    public void bark() {
        System.out.println("Gau Gau");
    }

    //    public String getName() {
//        return super.name; // trỏ thuộc tính name ở class cha
//    }

        @Override // annotation
    public void eat() {
            System.out.println("Dog is eating");
        }
        // AM của phương thức lớp con phải rộng hơn lớp cha
}
