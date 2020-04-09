public class EmptyField extends Coordinates {
    private final String state = Icon.EMPTY.getIcon();

    public EmptyField(int row, int column) {
        super(row, column);
    }

    @Override
    public String toString() { // w Coordinates dodac pole state i zmienic toString i bedzie moglo byc chyba bez nadwpisywania
        return state;
    }
}