package baseball;

public class BallNumber {
    public static final int MIN = 1;
    public static final int MAX = 9;
    private int number;
    public int getNumber(){
        return number;
    }

    public BallNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("볼 숫자는 1부터 9의 값이어야 합니다");
        }
        this.number = number;
    }
}
