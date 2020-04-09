public enum Icon {
    WALL_CELL(" # "),
    EMPTY(" . "),
    PLAYER(" @ "),
    COIN(" $ "),
    ENEMY(" Ω "),
    STRENGTH_POTION(" 🍼"),
    HEALTH_POTION(" 🍺"),
    FOOD(" 🍗"),
    WEAPON(" 🔪")
    ;
    // inne ktorych uzywamy
    
    public final String icon;

    private Icon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}