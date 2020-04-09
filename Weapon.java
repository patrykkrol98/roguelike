public class Weapon extends Item
{
    public int damage;
    public int strength = 5;
    
    public Weapon(int x, int y) {
        super(x, y);
        this.icon = Icon.WEAPON.getIcon();
        this.name = "Sword";
        this.tooltip = "Increases your attack!";
    }
   
   public void use(Player player)
   {
      if (this.strength > player.stats.strength)
      {
         System.out.println("This weapons strength requirement (" + this.strength + ") > your strength (" + player.stats.strength + ")!");
         return;
      }
      else
      {
       player.stats.attack += 20;
      }
   }
   @Override
    public String toString() {
        return this.icon;
    }
}
   