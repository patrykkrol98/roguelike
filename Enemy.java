public class Enemy extends Coordinates {
    private final String state = Icon.ENEMY.getIcon();
    protected Stats stats;
    private boolean horizontalDirection;
    private boolean vertivalDirection;

    public Enemy(int health, int attack, int x, int y) {
        super(x, y);
        this.stats = new Stats(health, attack, 0);
        this.horizontalDirection = true;
        this.vertivalDirection = true;
    }
    public void attack(Player player) {
        player.stats.health -= this.stats.strength;
        this.stats.health -= player.stats.strength;
    }

    public void walkHorizontal(Board board) {
        horizontalDirection = horizontalDirection ? walkRight(board) : walkLeft(board);
    }

    private boolean walkRight(Board board) {
        if (!(board.getCoordinates(getX(), getY() + 1) instanceof Collidable)) {
            setY(getY() + 1);
            return true;
        }

        return false;
    }

    private boolean walkLeft(Board board) {
        if (!(board.getCoordinates(getX(), getY() - 1) instanceof Collidable)) {
            setY(getY() - 1);
            return false;
        }
        return true;
    }

    public void walkVertically(Board board) {
        vertivalDirection = vertivalDirection ? walkUp(board) : walkDown(board);
    }

    private boolean walkUp(Board board) {
        if (!(board.getCoordinates(getX() - 1, getY()) instanceof Collidable)) {
            setX(getX() - 1);
            return true;
        }
        return false;
    }

    private boolean walkDown(Board board) {
        if (!(board.getCoordinates(getX() + 1, getY()) instanceof Collidable)) {
            setX(getX() + 1);
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return state;
    }
}