class Dog{

}

class Cat{

}

public interface Manager<T> { //Tương tự tham số truyền vào nhưng dành cho kiểu dữ liệu
    void add(T t);

    void update(int id, T t);
}

class DogManager implements Manager<Dog>{ // QUản lý Dog => Truyền Dog

    @Override
    public void add(Dog cat) {

    }

    @Override
    public void update(int id, Dog dog) {

    }

    class CatManager implements Manager<Cat> {

        @Override
        public void add(Cat cat) {

        }

        @Override
        public void update(int id, Cat cat) {

        }
    }


}