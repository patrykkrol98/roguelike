public enum Icon {
    WALL_CELL(" # "),
    EMPTY(" . "),
    PLAYER(" @ "),
    COIN(" $ "),
    ENEMY(" Ω ");
    // inne ktorych uzywamy
    
    public final String icon;

    private Icon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}