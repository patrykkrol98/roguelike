import java.util.ArrayList;
import java.util.Random;

public class Obstacle {
    private ArrayList<WallCell> obstacleCoordinates;
    private Random random = new Random();

    public Obstacle(int rows, int columns, Board board) {
        boolean isValid = false;
        while (!isValid) {
            int startingX = random.nextInt(3), startingY = random.nextInt(3)
            , shapeLenth = 1 + random.nextInt(6), shapeHeigth = 1 + random.nextInt(6);

            for (int i = startingX; i < shapeLenth + startingX; i++) {
                for (int j = startingY; j < shapeHeigth + startingY; j++) {
                    // if ((board.getCoordinates(i, j) instanceof Collidable)) {
                    //     // obstacleCoordinates.clear();
                    //     isValid = false;
                    //     // continue;
                    // }
                    obstacleCoordinates.add(new WallCell(i, j));
                }
            }
            isValid = true;
            // break;
        }

    }


    
    public void addObstacle(int x, int y) {
        obstacleCoordinates.add(new WallCell(x, y));
    }

    public  ArrayList<WallCell> getObstacle() {
        return obstacleCoordinates;
    }

    // public boolean isValid(Board board) {
    //     if (board.getCoordinates(i, j) instanceof Collidable)
    // }

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