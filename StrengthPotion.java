public class StrengthPotion extends Item {
    public StrengthPotion(int x, int y) {
        super(x, y);
        this.icon = Icon.STRENGTH_POTION.getIcon();
        this.name = "Strength Potion";
        this.tooltip = "Increases your strengh!";
    }

    public void use(Player player) {
        player.stats.strength += 1;
        player.inventory.remove(this);
    }

    @Override
    public String toString() {
        return this.icon;
    }

}