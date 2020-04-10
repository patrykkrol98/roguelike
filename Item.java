abstract class Item extends Coordinates implements Collectable {
     protected String icon;
     protected String name;
     protected String tooltip;
     protected Color color;
     
     public Item(int x, int y) {
          // set icon, name, tooltip, color -> private
          super(x, y);
     }

     public void use(Player player) {
     }
}   
   

