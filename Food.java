public class Food extends Item {
    public Food(int x, int y) {
        super(x, y);
        this.icon = Icon.FOOD.getIcon();
        this.name = "Food";
        this.tooltip = "Increases your health!";
    }

    public void use(Player player) {
        player.stats.health += 10;
        player.inventory.remove(this);
    }

    @Override
    public String toString() {
        return this.icon;
    }
}