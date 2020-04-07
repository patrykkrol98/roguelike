class Board {
    private Square[][] gameBoard;
    private int rows, columns;
    
    public Board(int rows, int columns) {
        // Obstacle.addObstacle(5, 5);// testowo dodane na potzrby sprawdzenia dzialania

        this.rows = rows;
        this.columns = columns;

        gameBoard = new Square[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                gameBoard[row][column] = new Square();
            }
        }
        for (Coordinates square : Obstacle.getObstacle()) { // dodawanie przeszkod nastepny for innych rodzajow czy wrogow lub przy pomocy interfejsow
            gameBoard[square.getX()][square.getY()] = new Square(square.getX(), square.getY(), Icon.WALL_CELL);
        }
    }

    public Square[][] getGameBoard() {
        return gameBoard;
    }

    public void setSquare(int row, int column, Icon icon) {
        gameBoard[row][column] = new Square(row, column, icon);
    }

    public Square getSquare(int row, int column) {
        return gameBoard[row][column];
    }

    public String toString() {
        String result = String.format("%s%n", Icon.WALL_CELL.getIcon().repeat(rows + 2));
        for (Square[] row: gameBoard) {
            result += Icon.WALL_CELL.getIcon();
            for (Square element: row) {
                result += element.toString();
            }
            result += String.format("%s%n", Icon.WALL_CELL.getIcon());
        }
        result += Icon.WALL_CELL.getIcon().repeat(rows + 2);
        return result;
    }
}