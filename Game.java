import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Game extends KeyAdapter {
    Player player = new Player();
    
    @Override
    public void keyPressed(KeyEvent event) {

        char ch = event.getKeyChar();

        System.out.println((int)ch);
        Board board = new Board();
        Obstacle.createObstacle();// tutaj tak dla spradzenia na szybko przeszkoda
        clearScreen();
        switch(ch) {
            case 'w':
                // code block
                // Hero.moveUp()
                player.moveUp(board);
                break;

            case 's':
                // code block
                // Hero.moveDown()
                player.moveDown(board);
                break;

            case 'a':
                // code block
                // Hero.moveLeft()
                player.moveLeft(board);
                break;

            case 'd':
                // code block
                // Hero.moveRight()
                player.moveRight(board);
                break;

        }
        board.setSquare(player.getX(), player.getY(), true); //cos
        System.out.println(board);
        System.out.println(player);
    }

    public static void clearScreen() {
        System. out. print("\033[H\033[2J");
        System. out. flush();
        }
}

    // public void createBoard(int width, int height) {

    // }
