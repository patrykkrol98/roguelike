import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Game extends KeyAdapter {
    Player player = new Player(10, 10);
    Enemy enemyOne = new Enemy(100, 10, 5, 5);
    Enemy enemyTwo = new Enemy(50, 5, 12, 12);
    
    @Override
    public void keyPressed(KeyEvent event) {
        char ch = event.getKeyChar();
        Board board = new Board(player.getX(), player.getY(), player);
        Obstacle.createObstacle();// tutaj tak dla spradzenia na szybko przeszkoda
        clearScreen();
        // System.out.println(board);
        board.setSomethingOnBoard(enemyOne);
        board.setSomethingOnBoard(enemyTwo);
        switch(ch) {
            case 'w':
                if (!(board.getCoordinates(player.getX() - 1, player.getY()) instanceof Collidable)) {
                    player.move(-1, 0);
                }
                enemyMovement(board);
                break;

            case 's':
                if (!(board.getCoordinates(player.getX() + 1, player.getY()) instanceof Collidable)) {
                    player.move(1, 0);
                }
                enemyMovement(board);
                break;

            case 'a':
                if (!(board.getCoordinates(player.getX(), player.getY() - 1) instanceof Collidable)) {
                    player.move(0, -1);
                }
                enemyMovement(board);
                break;

            case 'd':
                if (!(board.getCoordinates(player.getX(), player.getY() + 1) instanceof Collidable)) {
                    player.move(0, 1);
                }
                enemyMovement(board);
                break;

        }
        // player.stats.print_character(); TODO uncomment o print stats and inv
        // board.setSomethingOnBoard(new StrengthPotion(1, 1));
        board.setSomethingOnBoard(player);
        System.out.println(board);
        // System.out.println("Max carry: " + player.inventory.max);
        // player.inventory.drawInventory(); TODO uncomment
    }

    public static void clearScreen() {
        System. out. print("\033[H\033[2J");
        System. out. flush();
        }

    private void enemyMovement(Board board) {
        enemyOne.walkHorizontal(board);
        enemyTwo.walkVertically(board);
    }
}
