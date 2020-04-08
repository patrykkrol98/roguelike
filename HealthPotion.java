public class HealthPotion extends Item {
        public HealthPotion(Coordinates coordinate) {
            super(coordinate);
            this.icon = Icon.STRENGTH_POTION;
            this.name = "Health Potion";
            this.tooltip = "Increases your health!";
        }
    
        public void use(Player player) {
            player.stats.health += 1;
            player.inventory.remove(this);
        }
    
}