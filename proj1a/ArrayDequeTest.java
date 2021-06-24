
import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void checkIsEmpty() {
        ArrayDeque<String> A = new ArrayDeque<>();
        assertEquals(true, A.isEmpty());

    }

//    @Test
//    public void checkIsFull() {
//        ArrayDeque<String> A = new ArrayDeque<>();
//        for (int tmp = 0; tmp < 8; tmp++) {
//            A.addFirst("1");
//        }
//        A.printDeque();
//        assertEquals(true, A.isFull());
//
//    }

    @Test
    public void checkConstructor() {


    }

//    @Test
//    public void checkAddAndRemove() {
//        ArrayDeque<String> B = new ArrayDeque<>();
//        B.addFirst("1");
//        B.addFirst("2");
//        B.addFirst("3");
//        B.addLast("4");
//        Object[] exp = {"3", "2", "1", "4"};
//        Object[] actual = B.getArray();
//        assertArrayEquals(exp, actual);
//
//
//        String result1 = B.removeFirst();
//        Object[] exp1 = {"2", "1", "4"};
//        Object[] actual1 = B.getArray();
//        assertEquals("3", result1);
//        assertArrayEquals(exp1, actual1);
//
//
//        String result2 = B.removeLast();
//        Object[] exp2 = {"2", "1"};
//        Object[] actual2 = B.getArray();
//        assertEquals("4", result2);
//        assertArrayEquals(exp2, actual2);
//
//    }

    @Test
    public void checkSize() {
        ArrayDeque<String> A = new ArrayDeque<>();
        assertEquals(0, A.size());

        A.addFirst("1");
        A.addFirst("2");
        A.addLast("3");
        A.removeFirst();

        assertEquals(2, A.size());
    }

    @Test
    public void checkGet() {
        ArrayDeque<String> T = new ArrayDeque<>();
        T.addFirst("1");
        T.addFirst("2");
        String result = T.get(1);
        assertEquals("1", result);

    }

    @Test
    public void checkResize() {


    }


}
