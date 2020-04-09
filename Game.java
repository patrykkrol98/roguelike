import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

class Game extends KeyAdapter {
    Player player = new Player(10, 10);
    Enemy enemyOne = new Enemy(20, 10, 5, 5);
    Enemy enemyTwo = new Enemy(50, 5, 12, 12);
    ArrayList<Item> BoardItems = new ArrayList<>();
    
    @Override
    public void keyPressed(KeyEvent event) {
        char ch = event.getKeyChar();
        Board board = new Board(player.getX(), player.getY(), player);
        Obstacle.createObstacle();// tutaj tak dla spradzenia na szybko przeszkoda
        clearScreen();
        createItems();

        ItemProvider(board);
        // System.out.println(board);
        List<Enemy> enemies = createEnemiesList();
        setEnemiesOnBoard(enemies, board);
        switch(ch) {
            case 'w':
                if (!(board.getCoordinates(player.getX() - 1, player.getY()) instanceof Collidable)) {
                    ifThereIsEnemyElseWalk(board, enemies, 1, 0);
                }
                enemyMovement(board);
                break;

            case 's':
                if (!(board.getCoordinates(player.getX() + 1, player.getY()) instanceof Collidable)) {
                    ifThereIsEnemyElseWalk(board, enemies, -1, 0);
                }
                enemyMovement(board);
                break;

            case 'a':
                if (!(board.getCoordinates(player.getX(), player.getY() - 1) instanceof Collidable)) {
                    ifThereIsEnemyElseWalk(board, enemies, 0, 1);
                }
                enemyMovement(board);
                break;

            case 'd':
                if (!(board.getCoordinates(player.getX(), player.getY() + 1) instanceof Collidable)) {
                    ifThereIsEnemyElseWalk(board, enemies, 0, -1);
                }
                enemyMovement(board);
                break;
            case 'i':
                clearScreen();
                player.inventory.drawInventory();
                int index = InputProvider.getInt("Which one you want to use?: ");
                player.inventory.getItems().get(index-1).use(player);
                player.inventory.getTable().removeRow(index-1);


        }
        player.stats.print_character();// TODO uncomment o print stats and inv
        board.setSomethingOnBoard(player);
        System.out.println(board);
        System.out.println("Max carry: " + player.inventory.max);
        player.inventory.drawInventory();// TODO uncomment
    }

    private void createItems() {
        if (BoardItems.isEmpty()&&player.inventory.getItems().isEmpty()){
            BoardItems.add(new StrengthPotion(1, 1));
            BoardItems.add(new Weapon(8, 8));
            BoardItems.add(new Food(7, 2));
            BoardItems.add(new HealthPotion(9, 4));
        }
    }

    private void ItemProvider(Board board) {

        for (int i = 0; i < BoardItems.size(); i++) {
            if (player.x == BoardItems.get(i).x && player.y == BoardItems.get(i).y){
                player.inventory.add(BoardItems.get(i));
                BoardItems.remove(BoardItems.get(i));
            }
            else{
                board.setSomethingOnBoard(BoardItems.get(i));
            }

        // for (Item item : items) { // dlaczego nie dziala?
        //     if (player.x == item.x && player.y == item.y){
        //         player.inventory.add(item);
        //         items.remove(item);
        //     }
        //     else{
        //         board.setSomethingOnBoard(item);
        //     }
        
        }

        if ((board.getCoordinates(player.getX(), player.getY()) instanceof Collectable)){
            System.out.println("collect");
        }
        player.stats.print_character(); //TODO uncomment o print stats and inv
        board.setSomethingOnBoard(new StrengthPotion(1, 1));
        board.setSomethingOnBoard(player);
        System.out.println(board);
        System.out.println("Max carry: " + player.inventory.max);
        player.inventory.drawInventory(); //TODO uncomment
    }

    public static void clearScreen() {
        System. out. print("\033[H\033[2J");
        System. out. flush();
        }

    private void enemyMovement(Board board) {
        enemyOne.walkHorizontal(board);
        enemyTwo.walkVertically(board);
    }
    private List<Enemy> createEnemiesList() {
        List<Enemy> enemies = new ArrayList<Enemy>();
        enemies.add(enemyOne);
        enemies.add(enemyTwo);
        return enemies;
    }
    private void setEnemiesOnBoard(List<Enemy> enemies, Board board) {
        for (Enemy enemy : enemies) {
            if(enemy.stats.health > 0) {
                board.setSomethingOnBoard(enemy);
            }
        }
    }
    private void battle(List<Enemy> enemies, int playerX, int playerY) {
        for(Enemy enemy : enemies) {
            if (player.getX() - playerX == enemy.getX() && player.getY() - playerY == enemy.getY()) {
                enemy.attack(player);
            }
        }
    }
    private void ifThereIsEnemyElseWalk(Board board, List<Enemy> enemies, int movementX, int movementY) {
        if (board.getCoordinates(player.getX() - movementX, player.getY() - movementY) instanceof Enemy) {
            battle(enemies, movementX, movementY);
        }else {
            player.move(-movementX, -movementY);
        }
    }
}
