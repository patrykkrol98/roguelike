public class Enemy extends Coordinates {
    private String name;
    private int health;
    private int attack;
    private final String state = Icon.ENEMY.toString();

    public Enemy(String name, int health, int attack, int x, int y) {
        super(x, y);
        this.name = name;
        this.health = health;
        this.attack = attack;

    }

    public void setOnBoard(Board board) {
        board.setCoordinates(this.x, this.y); // TODO: change it 
    }

    boolean horizontalDirection = true;

    public void walkHorizontal(Board board) {
        horizontalDirection = horizontalDirection ? walkRight(board) : walkLeft(board);
    }

    private boolean walkRight(Board board) {
        Coordinates[][] gameBoard = board.getGameBoard();
        try {
            if (!(gameBoard[getX()][getY() + 1] instanceof Collidable)) {
                setY(getY() + 1);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private boolean walkLeft(Board board) {
        Coordinates[][] gameBoard = board.getGameBoard();
        try {
        if (!(gameBoard[getX()][getY() - 1] instanceof Collidable)) {
            setY(getY() - 1);
            return false;
        } else {
            return true;
        }
    } catch (Exception e) {
        return true;
    }
}

    public void walkVertically(Board board) {
        boolean vertivalDirection = true;
        vertivalDirection = vertivalDirection ? walkUp(board) : walkDown(board);
    }

    private boolean walkUp(Board board) {
        Coordinates[][] gameBoard = board.getGameBoard();
        if (!(gameBoard[getX()][getY() - 1] instanceof Collidable)) {
            setY(getY() - 1);
            return true;
        } else {
            return false;
        }
    }

    private boolean walkDown(Board board) {
        Coordinates[][] gameBoard = board.getGameBoard();
        if (!(gameBoard[getX()][getY() + 1] instanceof Collidable)) {
            setY(getY() + 1);
            return false;
        } else {
            return true;
        }
    }
    @Override
    public String toString() {
        return state;
    }
}