import java.util.ArrayList;
import java.util.Random;

public class Obstacle {
    private ArrayList<Coordinates> obstacleCoordinates;
    private Random random = new Random();

    public Obstacle(int rows, int columns) {
        // obstacle.add(new Coordinates(5, 5));
        int startingX = random.nextInt(rows), startingY = random.nextInt(columns)
          , shapeLenth = 1 + random.nextInt(6), shapeHeigth = 1 + random.nextInt(6);

        for (int i = startingX; i < shapeLenth + startingX; i++) {
            for (int j = startingY; j < shapeHeigth + startingY; j++) {
                obstacleCoordinates.add(new Coordinates(i, j));
            }
        }
        boolean isValid = 
    }
    
    public void addObstacle(int x, int y) {
        obstacleCoordinates.add(new Coordinates(x, y));
    }

    public  ArrayList<Coordinates> getObstacle() {
        return obstacleCoordinates;
    }

    // public void createObstacle() {
    //     for (int i = 5; i < 10; i++) {
    //         for (int j = 5; j < 10; j++) {
    //             obstacleCoordinates.add(new Coordinates(i, j));
    //         }
    //     }
    // }

    // public static void create(int rows, int columns) {
    //     int startingX = random.nextInt(rows), startingY = random.nextInt(columns)
    //       , shapeLenth = 1 + random.nextInt(6), shapeHeigth = 1 + random.nextInt(6);
    //     for (int i = 0; i < shapeLenth; i++) {
    //         for (int j = 0; j < shapeHeigth; j++) {
                
    //         }
    //     }
    // }
}