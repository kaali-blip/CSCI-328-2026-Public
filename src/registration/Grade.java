package registration;

public enum Grade {
    A, B, C, D, F, W;

    public boolean isPassing() {
        return this == A || this == B || this == C;
    }
}
