import java.util.ArrayList;
import java.util.Random;

public class Obstacle implements Collidable {
    private ArrayList<WallCell> obstacleCoordinates;
    private Random random = new Random();
    // Coordinates pivot;
    // int width, height;

    public Obstacle(int rows, int columns, Board board) {
        boolean isRunning = true;
        obstacleCoordinates = new ArrayList<WallCell>();
        while (isRunning) {
            int startingX = 1 + random.nextInt(15);
            int startingY = 1 + random.nextInt(15);
            int shapeLength = 1 + random.nextInt(4); 
            int shapeHeigth = 1 + random.nextInt(4);
            
            for (int i = startingX; i < shapeLength + startingX; i++) {
                for (int j = startingY; j < shapeHeigth + startingY; j++) {
                    obstacleCoordinates.add(new WallCell(i, j));
                }
            }
            boolean isValid = obstacleValidator();
            if (isValid) {
                int cornersBeforeAndAfterObstacle = 2;
                for (int inRow = 0; inRow < shapeHeigth + cornersBeforeAndAfterObstacle; inRow++) {
                    ObstacleList.addIllegalFields(new Coordinates(startingX - 1, startingY - 1 + inRow));
                    ObstacleList.addIllegalFields(new Coordinates(startingX + shapeHeigth, startingY - 1 + inRow));
                }
                for (int inColumn = 0; inColumn < shapeLength; inColumn++) {
                    ObstacleList.addIllegalFields(new Coordinates(startingX + inColumn, startingY - 1));
                    ObstacleList.addIllegalFields(new Coordinates(startingX + inColumn, startingY + shapeLength));
                }
                isRunning = false;
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
                    if (coordinates.getX() == cell.getX() && coordinates.getY() == cell.getY()) {
                        isObstacleListValid = false;
                    }
                }
            }
        }
        if (!isObstacleListValid) {
            return isObstacleListValid;
        }

        for (WallCell cell : obstacleCoordinates) { //sprawdzam w zajetych polach czyli tych do okola aktualnych przeszkod
            for (Coordinates coordinates : ObstacleList.getIllegalFields()) {
                if (cell.getX() == coordinates.getX() && cell.getY() == coordinates.getY()) {
                    isIllegalFieldsValid = false;
                }
            }
        }

        return isIllegalFieldsValid;
    }
    
    public void addObstacle(int x, int y) {
        obstacleCoordinates.add(new WallCell(x, y));
    }

    public  ArrayList<WallCell> getObstacle() {
        return obstacleCoordinates;
    }
}