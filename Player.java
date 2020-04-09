
import java.util.ArrayList;
import java.util.List;

public class Player extends Coordinates {
    // private String name;
    // private List<Item> items;
    private final String state = Icon.PLAYER.getIcon();
    protected Inventory inventory;
    protected Stats stats;

    public Player(int startX, int startY) {
        super(startX, startY);
        this.stats = new Stats();
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