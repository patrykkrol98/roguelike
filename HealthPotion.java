public class HealthPotion extends Item {
    public HealthPotion(int x, int y) {
        super(x, y);
        this.icon = Icon.HEALTH_POTION.getIcon();
        this.name = "Health Potion";
        this.tooltip = "Increases your health!";
    }
    
    public void use(Player player) {
        player.stats.health += 20;
        player.inventory.remove(this);
    }

    @Override
    public String toString() {
        return this.icon;
    }
    
}