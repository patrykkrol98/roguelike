public class WallCell extends Coordinates implements Collidable {
    private final String state = Icon.WALL_CELL.getIcon();

    public WallCell(int row, int column) {
        super(row, column);
    }

    @Override
    public String toString() {
        return state;
    }
}
