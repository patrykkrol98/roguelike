public class Enemy extends Coordinates {
    private String name;
    private int health;
    private int attack;
    private final String state = Icon.ENEMY.getIcon();

    public Enemy(String name, int health, int attack, int x, int y) {
        super(x, y);
        this.name = name;
        this.health = health;
        this.attack = attack;

    }

    private boolean horizontalDirection = true;

    public void walkHorizontal(Board board) {
        horizontalDirection = horizontalDirection ? walkRight(board) : walkLeft(board);
    }

    private boolean walkRight(Board board) {
        try {
            if (!(board.getCoordinates(getX(), getY() + 1) instanceof Collidable)) {
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
        try {
            if (!(board.getCoordinates(getX(), getY() - 1) instanceof Collidable)) {
                setY(getY() - 1);
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
    }

    private boolean vertivalDirection = true;

    public void walkVertically(Board board) {
        vertivalDirection = vertivalDirection ? walkUp(board) : walkDown(board);
    }

    private boolean walkUp(Board board) {
        if (!(board.getCoordinates(getX() - 1, getY()) instanceof Collidable)) {
            setX(getX() - 1);
            return true;
        } else {
            return false;
        }
    }

    private boolean walkDown(Board board) {
        if (!(board.getCoordinates(getX() + 1, getY()) instanceof Collidable)) {
            setX(getX() + 1);
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