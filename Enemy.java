
public class Enemy extends Coordinates{
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
        if (!(board[getX() + 1][getY()] instanceof Collidable)) { setX(getX() + 1); }
    }
}