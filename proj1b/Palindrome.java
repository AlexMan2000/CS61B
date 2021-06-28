public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> A = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            A.addLast(word.charAt(i));
        }
        return A;
    }

    public boolean isPalindrome(String word) {
        LinkedListDeque<Character> deque = (LinkedListDeque<Character>)this.wordToDeque(word);
        for(int i=0;i<word.length()/2;i++){
            char temp1 = deque.removeFirst();
            char temp2 = deque.removeLast();
            if(temp1 != temp2){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        LinkedListDeque<Character> deque = (LinkedListDeque<Character>) this.wordToDeque(word);
        for (int i = 0; i < word.length() / 2; i++) {
            char temp1 = deque.removeFirst();
            char temp2 = deque.removeLast();
            if (!cc.equalChars(temp1, temp2)) {
                return false;
            }
        }
        return true;
    }
}
