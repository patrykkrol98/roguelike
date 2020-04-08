import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Game extends KeyAdapter {
    Player player = new Player(10, 10);
    Enemy enemy = new Enemy("Orc", 100, 10, 5, 5);
    
    @Override
    public void keyPressed(KeyEvent event) {
        char ch = event.getKeyChar();
        // System.out.println((int)ch);
        Board board = new Board(player.getX(), player.getY(), player);
        Obstacle.createObstacle();// tutaj tak dla spradzenia na szybko przeszkoda
        clearScreen();
        enemy.setOnBoard(board);
        System.out.println(board);

        switch(ch) {
            case 'w':
                // player.moveUp(board);
                player.move(-1, 0);
                enemy.walkHorizontal(board);
                break;

            case 's':
                // player.moveDown(board);
                player.move(1, 0);
                enemy.walkHorizontal(board);
                break;

            case 'a':
                // player.moveLeft(board);
                player.move(0, -1);
                enemy.walkHorizontal(board);
                break;

            case 'd':
                // player.moveRight(board);
                player.move(0, 1);
                enemy.walkHorizontal(board);
                break;

        }
        System.out.println(board);
        // board.setSquare(player.getX(), player.getY(), Icon.PLAYER);
        // System.out.println(board);
        // System.out.println(player);
    }

    public static void clearScreen() {
        System. out. print("\033[H\033[2J");
        System. out. flush();
        }
}

