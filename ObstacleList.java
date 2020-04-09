import java.util.ArrayList;

public class ObstacleList {
    private static ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    private static ArrayList<Coordinates> illegalFields = new ArrayList<Coordinates>();

    public static void addObstacleToList(Obstacle obstacle) {
        obstacles.add(obstacle);
    }

    public static ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public static void addIllegalFields(Coordinates coordinates) {
        illegalFields.add(coordinates);
    }

    public static ArrayList<Coordinates> getIllegalFields() {
        return illegalFields;
    }
}