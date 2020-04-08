import java.util.*;
   
public class Inventory
{
   /* List of items in the inventory, size cannot exceed max */
   private List<Item> items;
   private int max;
   private CommandLineTable inventoryTable;
   
   public Inventory(int max)
   {
      this.items = new ArrayList<Item>();
      this.max = max;
      inventoryTable.setHeaders("ID", "Item", "Icon", "Attribiutes");
   }
   
   
   public List<Item> getItems()
   {
      return new ArrayList<Item>(items);
   }
   
   public boolean add(Item item)
   {
      if (this.items.size() < this.max)
      {
         items.add(item);
         return true;
      }
      return false;
   }
   
   public void remove(Item item)
   {
      items.remove(item);
   }
   
   public void drawInventory(){
      inventoryTable.print();
   }
}