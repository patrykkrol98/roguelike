public class Food extends Item {
    public Food(Coordinates coordinate) {
        super(coordinate);
        this.icon = Icon.STRENGTH_POTION;
        this.name = "Food";
        this.tooltip = "Increases your health!";
    }

    public void use(Player player) {
        player.stats.health += 1;
        player.inventory.remove(this);
    }

}