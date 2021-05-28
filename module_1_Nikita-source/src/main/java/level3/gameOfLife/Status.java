package level3.gameOfLife;

public enum Status {
    NONE,
    BORN,
    LIVE,
    DIED;

    public Status toPrepare(int liveAround) {
        switch (this) {
            case NONE:
                if (liveAround == 3) {
                    return BORN;
                } else {
                    return NONE;
                }
            case LIVE:
                if (liveAround < 2 || liveAround > 3) {
                    return DIED;
                } else {
                    return LIVE;
                }
            default:
                return this;
        }
    }

    public Status replace() {
        switch (this) {
            case BORN:
                return LIVE;
            case DIED:
                return NONE;
            default:
                return this;
        }
    }

    public boolean isCell() {
        if (this == LIVE || this == DIED) {
            return true;
        } else {
            return false;
        }
    }
}
