package baseball;

public enum BallStatus {
    NOTHING, BALL, STRIKE;

    public boolean isNotNoting() {
        return this != NOTHING;
    }
}
