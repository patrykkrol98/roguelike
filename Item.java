abstract class Item {
    protected Icon icon;
    protected String name;
    protected String tooltip;
    protected Color color;
    private Coordinates coordinate;
   
   public Item(Coordinates coordinate)
   {
        this.coordinate = coordinate;
   }
}
