import java.util.ArrayList;
import java.util.Random;

public class Obstacle {
    private ArrayList<WallCell> obstacleCoordinates;
    private Random random = new Random();

    public Obstacle(int rows, int columns, Board board) {
        // boolean isValid = true;
        boolean isRunning = true;
        obstacleCoordinates = new ArrayList<WallCell>();
        while (isRunning) {
            // boolean isValid = true;
            int startingX = 1 + random.nextInt(15), startingY = 1 + random.nextInt(15)
            , shapeLength = 1 + random.nextInt(3), shapeHeigth = 1 + random.nextInt(3);

            
            for (int i = startingX; i < shapeLength + startingX; i++) {
                for (int j = startingY; j < shapeHeigth + startingY; j++) {
                    // if ((board.getCoordinates(i, j) instanceof Collidable || !(obstacleValidator(i, j))) ) {
                    //     System.out.println("nie dodane");
                    //     obstacleCoordinates.clear();
                    //     isValid = false;
                    //     isRunning = false;
                    //     break;
                    // }
                    obstacleCoordinates.add(new WallCell(i, j));
                    // System.out.println("dodane");
    
                    
                }
                // break;
                // boolean isValid = obstacleValidator(i, j);
            }
            boolean isValid = obstacleValidator();
            if (isValid) {
                int cornersBeforeAndAfterObstacle = 2;
                for (int inRow = 0; inRow < shapeHeigth + 2; inRow++) {
                    ObstacleList.addIllegalFields(new Coordinates(startingX - 1, startingY - 1 + inRow));
                    ObstacleList.addIllegalFields(new Coordinates(startingX + shapeHeigth, startingY - 1 + inRow));
                    System.out.println("row");
                }
                for (int inColumn = 0; inColumn < shapeLength; inColumn++) {
                    ObstacleList.addIllegalFields(new Coordinates(startingX + inColumn, startingY - 1));
                    ObstacleList.addIllegalFields(new Coordinates(startingX + inColumn, startingY + shapeLength));
                    System.out.println("column");
                }

                // for (int i = startingX; i < shapeLength + startingX; i++) {
                //     for (int j = startingY; j < shapeHeigth + startingY; j++) {

                //     }
                // ObstacleList.addObstacleToList(obstacleCoordinates);
                isRunning = false;
                // isValid = true;
            }
            else {
                obstacleCoordinates.clear(); 
            }
            
        }
        
    }

    public boolean obstacleValidator() {
        boolean isObstacleListValid = true;
        boolean isIllegalFieldsValid = true;

        for (WallCell coordinates : obstacleCoordinates) { //dla kazdej coordynaty w danej przeszkodzie
            for (Obstacle obstacle : ObstacleList.getObstacles()) { //dla kazdej przeszkody
                for (WallCell cell : obstacle.getObstacle()) { // dla kazdej coordynaty w danej przeszkodzie
                    System.out.println("spr1");
                    if (coordinates.getX() == cell.getX() && coordinates.getY() == cell.getY()) {
                        isObstacleListValid = false;
                    }
                }
            }
        }
        if (isObstacleListValid) {
            for (WallCell cell : obstacleCoordinates) { //sprawdzam w zajetych polach czyli tych do okola aktualnych przeszkod
                for (Coordinates coordinates : ObstacleList.getIllegalFields()) {
                    System.out.println("spr2");
                    if (cell.getX() == coordinates.getX() && cell.getY() == coordinates.getY()) {
                        isIllegalFieldsValid = false;
                    }
                }
            }
        }
        else {
            return isObstacleListValid;
        }
        return isIllegalFieldsValid;
        
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
    //       , shapeLength = 1 + random.nextInt(6), shapeHeigth = 1 + random.nextInt(6);
    //     for (int i = 0; i < shapeLength; i++) {
    //         for (int j = 0; j < shapeHeigth; j++) {
                
    //         }
    //     }
    // }
}