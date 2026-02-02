public class Animal {
    String name;
    int soChan;

        public Animal(String name){
            this.name = name;
        }

        public Animal(String name, int soChan) {
            this(name);// gọi đến constructor có tham số tương ứng ở cùng lớp
            this.soChan = soChan;
        }

        protected void eat() {
            System.out.println("Animal is eating");
        }
}
