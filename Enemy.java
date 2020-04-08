public class Enemy extends Coordinates {
    private String name;
    private int health;
    private int attack;

    public Enemy(String name, int health, int attack, int x, int y) {
        super(x, y);
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public void walkHorizontal(Square[][] board) {
        boolean horizontalDirection = true;
        horizontalDirection = horizontalDirection ? walkRight(board) : walkLeft(board);
    }

    private boolean walkRight(Square[][] board) {
        if (!(board[getX() + 1][getY()] instanceof Collidable)) {
            setX(getX() + 1);
            return true;
        } else {
            return false;
        }
    }

    private boolean walkLeft(Square[][] board) {
        if (!(board[getX() - 1][getY()] instanceof Collidable)) {
            setX(getX() - 1);
            return false;
        } else {
            return true;
        }
    }

    public void walkVertically(Square[][] board) {
        boolean vertivalDirection = true;
        vertivalDirection = vertivalDirection ? walkUp(board) : walkDown(board);
    }

    private boolean walkUp(Square[][] board) {
        if (!(board[getX()][getY() - 1] instanceof Collidable)) {
            setY(getY() - 1);
            return true;
        } else {
            return false;
        }
    }

    private boolean walkDown(Square[][] board) {
        if (!(board[getX()][getY() + 1] instanceof Collidable)) {
            setY(getY() + 1);
            return false;
        } else {
            return true;
        }
    }
}