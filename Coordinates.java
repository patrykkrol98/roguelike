class Coordinates {
    protected int x;
    protected int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        String result = String.format("(%d, %d)", this.x, this.y);
        return result;
    }
}