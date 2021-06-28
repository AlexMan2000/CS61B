import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /*Uncomment this class once you've created your Palindrome class. */


    @Test
    public void testPalindrome(){
        String A = "haha";
        String B = "asdsa";
        String T = "Asdsa";
        String J = "";
        String I = "1";
        assertFalse(palindrome.isPalindrome(A));
        assertTrue(palindrome.isPalindrome(B));
        assertFalse(palindrome.isPalindrome(T));
        assertTrue(palindrome.isPalindrome(J));
        assertTrue(palindrome.isPalindrome(I));

    }

}
