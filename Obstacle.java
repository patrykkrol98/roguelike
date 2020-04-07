import java.util.ArrayList;

public class Obstacle implements Collidable{
    private static ArrayList<Coordinates> obstacles = new ArrayList<Coordinates>();

    // public Obstacle() {
    //     obstacle.add(new Coordinates(5, 5));
    // }
    
    public static void addObstacle(int x, int y) {
        obstacles.add(new Coordinates(x, y));
    }

    public static ArrayList<Coordinates> getObstacle() {
        return obstacles;
    }

    public static void createObstacle() {
        for (int i = 5; i < 10; i++) {
            for (int j = 5; j < 10; j++) {
                obstacles.add(new Coordinates(i, j));
            }
        }
    }
}