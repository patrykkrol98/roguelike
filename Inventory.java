import java.util.*;
   
public class Inventory
{
   /* List of items in the inventory, size cannot exceed max */
   private List<Item> items;
   public int max;
   private CommandLineTable inventoryTable = new CommandLineTable();
   
   public Inventory(int max)
   {
      this.items = new ArrayList<Item>();
      this.max = max;
      inventoryTable.setHeaders("Idx", "Item", "Icon", "Attribiutes");
      inventoryTable.setShowVerticalLines(true);
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
         inventoryTable.addRow(Integer.toString(items.size()), item.name, item.icon, item.tooltip);
         return true;
      }
      return false;
   }
   
   public CommandLineTable getTable(){
      return inventoryTable;
   }
   
   public void remove(Item item)
   {
      items.remove(item);
   }
   
   public void drawInventory(){
      inventoryTable.print();
   }
}