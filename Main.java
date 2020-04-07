import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Board board = new Board();
        // Coordinates startCoo = new Coordinates(10, 10);

        // System.out.println(board);
        JTextField textField = new JTextField();

        textField.addKeyListener(new Game());
        JFrame jframe = new JFrame();

        jframe.add(textField);
        jframe.setSize(100, 100);
        jframe.setVisible(true);
    }
}