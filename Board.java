class Board {
    private Square[][] gameBoard;
    private int rows = 20, columns = 20;
    // Obstacle obstacle = new Obstacle();
    
    public Board() {
        Obstacle.addObstacle(5, 5);
        gameBoard = new Square[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                gameBoard[row][column] = new Square();
            }
        }
        for (Coordinates square : Obstacle.getObstacle()) { // dodawanie przeszkod nastepny for innych rodzajow czy wrogow
            gameBoard[square.getX()][square.getY()] = new Square(square.getX(), square.getY(), false);//zmieniec
        }
    }

    public Square[][] getGameBoard() {
        return gameBoard;
    }

    public void setSquare(int row, int column, boolean cos) { // cos
        gameBoard[row][column] = new Square(row, column, true);
    }

    public Square getSquare(int row, int column) {
        return gameBoard[row][column];
    }

    public String toString() {
        String wallCell = " # ";//z enumow wziac
        String result = wallCell.repeat(rows + 2) + "\n";
        for (Square[] row: gameBoard) {
            result += wallCell;
            for (Square element: row) {
                result += element.toString();
            }
            result += wallCell + "\n";
        }
        result += wallCell.repeat(rows + 2);
        return result;
    }

    // public boolean isOccupied(Obstacle obstacle, int row, int column) {
    //     boolean isOccupied = false;
    //     for (Coordinates square : obstacle.getObstacle()) {
    //         if (square.getX() == row && square.getY() == column) {
    //             return isOccupied = true;
    //         }
    //     }
    //     return isOccupied;
    // }
}