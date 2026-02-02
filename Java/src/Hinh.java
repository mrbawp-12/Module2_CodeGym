public abstract class Hinh {
    public abstract double getS(); //phương thức abstract thì không có phần thân
    public  abstract double getC();
    //abstract method phảu nằm trong abstract class

    private String name;
    public Hinh(String name){
        this.name=name;
    }

    public void showName(){ // non-abstract
        System.out.println("Day la" + this.name);
    }
}
