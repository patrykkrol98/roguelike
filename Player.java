
import java.util.ArrayList;
import java.util.List;

public class Player extends Coordinates {
    // private String name;
    // private List<Item> items;
    private final String state = Icon.PLAYER.getIcon();
    private int health;
    private int attack;

    public Player(int startX, int startY) {
        super(startX, startY);
        health = 100;
        attack = 50;
    }

    public void move(int x, int y) {
        this.x += x;
        this.y += y; 
    }

    @Override
    public String toString() {
        return state;
    }
}