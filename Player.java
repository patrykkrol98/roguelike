
import java.util.List;

public class Player {
    private String name;
    // private List<Item> items;
    private Coordinates position = new Coordinates(10, 10);
    private int x = 10, y = 10;
    private int health;
    private int attack;
    // private String PlayerIcon = " @ ";

    // public Player(String name, Coordinates coo) {
    //     this.name = name;
    //     health = 100;
    // }

    public void move(Coordinates coordinates) {
        this.x = coordinates.getX();
        this.y = coordinates.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveUp(Board board) {
        if (x - 1 < 0) { 
            return;
        }
        else if (board.getSquare(x - 1, y).getSquare().equals(" # ")) {
            return;
        } else {
            move(new Coordinates(x - 1, y));
        }
    }

    public void moveDown(Board board) {
        if (x + 1 >= 20) {
            return;
        }
        else if (board.getSquare(x + 1, y).getSquare().equals(" # ")) {
            return;
        } 
        else {
            move(new Coordinates(x + 1, y));
        }
        // int a = Player.x + 1 >= 20 ? break : Player.move(new Coordinates(Player.x + 1, Player.y));
    }

    public void moveLeft(Board board) {
        if (y - 1 < 0) {
            return;
        }
        else if (board.getSquare(x, y - 1).getSquare().equals(" # ")) {
            return;
        } 
        else {
            move(new Coordinates(x, y - 1));
        }
    }

    public void moveRight(Board board) {
        if (y + 1 >= 20) {
            return;
        }
        else if (board.getSquare(x, y + 1).getSquare().equals(" # ")) {
            return;
        }  
        else {
            move(new Coordinates(x, y + 1));
        }
    }

    public String toString() {
        String result = String.format("Player Coo: (row %d, column %d)", this.x, this.y);
        return result;
    }
}