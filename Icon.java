public enum Icon {
    WALL_CELL(" # "),
    EMPTY(" . "),
    PLAYER(" @ "),
    COIN(" $ "),
    STRENGTH_POTION(" * ");
    // inne ktorych uzywamy
    
    public final String icon;

    private Icon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}