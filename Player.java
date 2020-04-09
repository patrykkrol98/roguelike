
import java.util.ArrayList;
import java.util.List;

public class Player extends Coordinates implements Collidable {
    private String name;
    private final String state = Icon.PLAYER.getIcon();
    protected Inventory inventory;
    protected Stats stats;

    public Player(int startX, int startY) {
        super(startX, startY);
        Game.clearScreen();
        this.name = InputProvider.getString("What's your name?: ");
        this.stats = new Stats(); // TODO: uncomment to create stats and inv
        this.inventory = new Inventory(this.stats.strength);
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