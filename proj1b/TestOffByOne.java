import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    @Test
    public void testEqualChars(){
        char t1 = 'a';
        char t2 = 'b';
        char t3 = 'a';
        assertFalse(offByOne.equalChars(t1,t3));
        assertTrue(offByOne.equalChars(t1,t2));
    }

}
