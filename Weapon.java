public class Weapon extends Item
{
    public int damage;
    public int strength;
    
    public Weapon(int x, int y) {
        super(x, y);
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
        //  Item previouslyEquipped = player.equipSword; 
        //  player.equipSword = this; 
        //  player.inventory.remove(this); 
        //  if (previouslyEquipped != null) 
        //     player.inventory.add(previouslyEquipped); 
      }
   }
}
   