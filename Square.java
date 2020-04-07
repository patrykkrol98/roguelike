class Square {
    private String state;

    public Square() {
        state = Icon.EMPTY.getIcon();
    }

    public Square(int row, int column, Icon icon) {
        if (icon.equals(Icon.PLAYER)) {
            state = Icon.PLAYER.getIcon();
        }
        else if (icon.equals(Icon.WALL_CELL)) {
            state = Icon.WALL_CELL.getIcon();
        }
        else if (icon.equals(Icon.COIN)) {
            state = Icon.COIN.getIcon();
        }
    }

    public String getSquare() {
        return state;
    }

    public String toString() {
        return state;
    }
}