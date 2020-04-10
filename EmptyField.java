public class EmptyField extends Coordinates {
    private final String state = Icon.EMPTY.getIcon();

    public EmptyField(int row, int column) {
        super(row, column);
    }

    @Override
    public String toString() {
        return state;
    }
}