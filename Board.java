class Board {
    private Coordinates[][] gameBoard;
    private int rows = 20, columns = 20;
    
    public Board(int playerX, int playerY, Player player) {
        Obstacle.addObstacle(5, 5);// testowo dodane na potzrby sprawdzenia dzialania
        gameBoard = new Coordinates[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                gameBoard[row][column] = new EmptyField(row, column);
            }
        }
        gameBoard[playerX][playerY] = player;
        // for (Coordinates Coordinates : Obstacle.getObstacle()) { // dodawanie przeszkod nastepny for innych rodzajow czy wrogow lub przy pomocy interfejsow
        //     gameBoard[Coordinates.getX()][Coordinates.getY()] = new Coordinates(Coordinates.getX(), Coordinates.getY(), Icon.WALL_CELL);
        // }
    }

    public Coordinates[][] getGameBoard() {
        return gameBoard;
    }

    public void setCoordinates(int row, int column, Icon icon) {
        gameBoard[row][column] = new Coordinates(row, column);
    }

    public Coordinates getCoordinates(int row, int column) {
        return gameBoard[row][column];
    }

    public String toString() {
        String result = String.format("%s%n", Icon.WALL_CELL.getIcon().repeat(rows + 2));
        for (Coordinates[] row: gameBoard) {
            result += Icon.WALL_CELL.getIcon();
            for (Coordinates element: row) {
                result += element.toString();
            }
            result += String.format("%s%n", Icon.WALL_CELL.getIcon());
        }
        result += Icon.WALL_CELL.getIcon().repeat(rows + 2);
        return result;
    }
}