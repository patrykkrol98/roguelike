
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;  
    private Coordinates position = new Coordinates(10, 10);
    private int x = 10, y = 10;
    public Inventory inventory;
    public Stats stats;


    public Player(){
        this.stats = new Stats();
    }
    // public Player(String name, Coordinates coo) {
    //     this.name = name;
    //     health = 100;
    // }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean checkIfNextIsWall(Board board, int num, int num2) {
        return board.getSquare(x + num, y + num2).getSquare().equals(Icon.WALL_CELL.getIcon());

    }

    public void moveUp(Board board) {
        if (x - 1 < 0) { 
            return;
        } 
        else if (checkIfNextIsWall(board, - 1, 0)) {
            return;
        } else {
            x -= 1;
        }
    }

    public void moveDown(Board board) {
        if (x + 1 >= 20) {
            return;
        } 
        else if (checkIfNextIsWall(board, 1, 0)) {
            return;
        } 
        else {
            x += 1;
        }
    }

    public void moveLeft(Board board) {
        if (y - 1 < 0) {
            return;
        } 
        else if (checkIfNextIsWall(board, 0, - 1)) {
            return;
        } 
        else {
            y -= 1;
        }
    }

    public void moveRight(Board board) {
        if (y + 1 >= 20) {
            return;
        } 
        else if (checkIfNextIsWall(board, 0, 1)) {
            return;
        }  
        else {
            y += 1;
        }
    }

    public String toString() {
        String result = String.format("Player Coo: (row %d, column %d)", this.x, this.y);
        return result;
    }
}