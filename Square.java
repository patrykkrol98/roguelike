class Square {
    private String state;

    public Square() {
        state = " . "; //enumy do stanow
    }

    public Square(int row, int column, boolean cos) {//nie cos tylko czy przeszkoda czy player
       state = cos ?  " @ " : " # ";
    }

    public String getSquare() {
        return state;
    }

    public String toString() {
        return state;
    }
}