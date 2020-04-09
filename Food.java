public class Food extends Item {
    public Food(int x, int y) {
        super(x, y);
        this.icon = Icon.STRENGTH_POTION.getIcon();
        this.name = "Food";
        this.tooltip = "Increases your health!";
    }

    public void use(Player player) {
        player.stats.health += 1;
        player.inventory.remove(this);
    }

}