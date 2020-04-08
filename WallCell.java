public class WallCell extends Coordinates implements Collidable {
    private final String state = Icon.WALL_CELL.getIcon();

    public WallCell(int row, int column) {
        super(row, column);
    }

    @Override
    public String toString() { // w Coordinates dodac pole state i zmienic toString i bedzie moglo byc chyba bez nadwpisywania
        return state;
    }
}
