public enum Status {
    OPEN, TODO, IN_PROGRESS, DONE, VERIFIED;

    public Status next() {
        return values()[(ordinal() + 1) % values().length];
    }

    public Status previous() {
        return values()[(ordinal() - 1 + values().length) % values().length];
    }
}
