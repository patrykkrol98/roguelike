public enum Icon {
    WALL_CELL(" # "),
    EMPTY(" . "),
    PLAYER(" @ "),
    COIN(" $ ");
    // inne ktorych uzywamy
    
    public final String icon;

    private Icon(String icon) {
        this.icon = icon;
    }
}