import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class TestArrayDequeGold {
    StudentArrayDeque<Integer> tested = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> target = new ArrayDequeSolution<>();

    @Test
    public void testStudentArray() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne > 0.75) {
                Integer temp = StdRandom.uniform(10);
                tested.addFirst(temp);
                target.addFirst(temp);
                sb.append("addFirst(" + temp + ")" + "\n");
            } else if (numberBetweenZeroAndOne > 0.5) {
                Integer temp = StdRandom.uniform(10);
                tested.addLast(temp);
                target.addLast(temp);
                sb.append("addLast(" + temp + ")" + "\n");
            } else if (numberBetweenZeroAndOne > 0.25) {
                Integer actual = tested.removeFirst();
                Integer expected = target.removeFirst();
                sb.append("removeFirst()\n");
                assertEquals(sb.toString(),expected,actual);
            } else {
                // 用Integet接收可以避免null pointer问题
                Integer actual = tested.removeLast();
                Integer expected = target.removeLast();
                sb.append("removeLast()\n");
                assertEquals(sb.toString(),expected,actual);
            }
        }


    }

}

