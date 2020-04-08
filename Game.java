import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Game extends KeyAdapter {
    Player player = new Player(10, 10);
    
    @Override
    public void keyPressed(KeyEvent event) {
        char ch = event.getKeyChar();
        // System.out.println((int)ch);
        Board board = new Board(player.getX(), player.getY(), player);
        Obstacle.createObstacle();// tutaj tak dla spradzenia na szybko przeszkoda
        clearScreen();
        // System.out.println(board);

        switch(ch) {
            case 'w':
                // player.moveUp(board);
                if (!(board.getCoordinates(player.getX() - 1, player.getY()) instanceof Collidable)) {
                    player.move(-1, 0);
                }
                break;

            case 's':
                // player.moveDown(board);
                if (!(board.getCoordinates(player.getX() + 1, player.getY()) instanceof Collidable)) {
                    player.move(1, 0);
                }
                break;

            case 'a':
                // player.moveLeft(board);
                if (!(board.getCoordinates(player.getX(), player.getY() - 1) instanceof Collidable)) {
                    player.move(0, -1);
                } 
                break;

            case 'd':
                // player.moveRight(board);
                if (!(board.getCoordinates(player.getX(), player.getY() + 1) instanceof Collidable)) {
                    player.move(0, 1);
                }
                break;

        }
        // board.setSquare(player.getX(), player.getY(), Icon.PLAYER);
        board.setSomethingOnBoard(player.getX(), player.getY(), player); 
        System.out.println(board);
        // System.out.println(player);
    }

    public static void clearScreen() {
        System. out. print("\033[H\033[2J");
        System. out. flush();
        }
}

