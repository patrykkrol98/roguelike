class Board {
    private Coordinates[][] gameBoard;
    private int rows = 20, columns = 20;
    
    public Board(int playerX, int playerY, Player player) {
        // Obstacle.addObstacle(5, 5);// testowo dodane na potzrby sprawdzenia dzialania
        gameBoard = new Coordinates[rows][columns];
        
        for (int header = 0; header < columns; header++) { // tworzenie headera z obiektow typu WallCell
            gameBoard[0][header] = new WallCell(0, header);

        }
        for (int row = 1; row < rows - 1 ; row++) { // zaczynam od 1 i odejmuje 1 bo to miejsce na header i footer
            gameBoard[row][0] = new WallCell(row, 0);// boczna sciana
            for (int column = 1; column < columns - 1; column++) { //analogicznie odejmuje 1 dla zrobienia bokow
                gameBoard[row][column] = new EmptyField(row, column);
            }
            gameBoard[row][columns - 1] = new WallCell(row, columns - 1);//boczna sciana
        }
        for (int footer = 0; footer < columns; footer++) {
            gameBoard[rows - 1][footer] = new WallCell(rows - 1, footer);
        }
        // gameBoard[playerX][playerY] = player;

        // for (Coordinates Coordinates : Obstacle.getObstacle()) { // dodawanie przeszkod nastepny for innych rodzajow czy wrogow lub przy pomocy interfejsow
        //     gameBoard[Coordinates.getX()][Coordinates.getY()] = new Coordinates(Coordinates.getX(), Coordinates.getY(), Icon.WALL_CELL);
        // }
    }

    public Coordinates[][] getGameBoard() {
        return gameBoard;
    }

    public void setSomethingOnBoard(int x, int y, Coordinates object) {
        gameBoard[x][y] = object;
    }

    public Coordinates getCoordinates(int row, int column) {
        return gameBoard[row][column];
    }

    public String toString() {
        String result = "";
        for (Coordinates[] row: gameBoard) {
            for (Coordinates element: row) {
                result += element;
            }
            result += "\n";
        }
        return result;
    }
}