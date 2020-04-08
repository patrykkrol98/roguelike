public class StrengthPotion extends Item {
    public StrengthPotion(Coordinates coordinate) {
        super(coordinate);
        this.icon = Icon.STRENGTH_POTION;
        this.name = "Strength Potion";
        this.tooltip = "Increases your strengh!";
    }

    public void use(Player player) {
        player.stats.strength += 1;
        player.inventory.remove(this);
    }

}