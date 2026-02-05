package abstr;

public class TestFinal { // Khi đặt final ở class thì class naỳ không cho phép extends
    final int a = 10; // đây là hằng số

    void test() {
        final int b = 10; // đi với biến thì final có tác dụng đánh dấu là hằng số
    }

    void add() { // đi với method thì không cho phép ghi đè

    }
}

class TestV2 extends abstr.TestFinal {
//    void add() {
//
//    }
}