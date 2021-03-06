public class OffByN implements CharacterComparator {

    private int allowedDiff;
    public OffByN(int N){
        this.allowedDiff = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x-y;
        return Math.abs(diff) == this.allowedDiff;
    }
}
