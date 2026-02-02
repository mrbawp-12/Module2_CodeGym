package abstr;

public abstract class Hinh { //khai báo 1 class abstract
    public abstract double getS(); //phương thức abstract thì không có phần thân
    public  abstract double getC();
    //abstract method phải nằm trong abstract class

    private String name;

    public Hinh(String name){
        this.name=name;
    }

    public Hinh(){
    }

    public void showName(){ // non-abstract
        System.out.println("Day la" + this.name);
    }
}

// final không đi được cùng abstract