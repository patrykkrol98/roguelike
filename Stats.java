
public class Stats {
    public int health = 0;
    public int strength = 0;
    public int speech = 0;
    public int availablePoints = 50;

    Stats(int health, int strenght, int speech) {
        this.health = health;
        this.strength = strenght;
        this.speech = speech;
    }

    Stats() {
        boolean isRunning = true;
        while (isRunning) {
            System.err.println("Create a character! You have points to assign to strength, health, and speech.");
            print_character();
            System.out.println("\nYou have " + this.availablePoints + " points left.\n");
            System.out.println("1. Add points\n2. Remove points\n3. See current attributes\n4. Play!\n");
            switch (InputProvider.getInt("Choice:")) {
                case 1:
                    if ( availablePoints>0 ){
                        add_character_points();
                    }
                    else{
                        System.out.println("You don't have points to assign!");
                    }
                    break;
                case 2:
                    if ( availablePoints<50 ){
                        remove_character_points();
                    }
                    else{
                        System.out.println("You don't have points to remove!");
                    }
                    break;
                case 3:
                    print_character();
                    System.out.println("\nYou have " + this.availablePoints + " points left.\n");
                    break;
                case 4:
                    isRunning = false;
                    break;
            }
        }

    }

    private void add_character_points() {
        int value;
        Game.clearScreen();
        System.err.println("Which point you want to add?");
        System.out.println("1. Health\n2. Strength\n3. Speech\n4. Back\n");
            switch (InputProvider.getInt("Choice to add:")) {
                case 1:
                    value = getValue();
                    if(value <= availablePoints){
                        this.health += value;
                        availablePoints -= value;
                    }
                    else{
                        System.out.println("You don't have enough points!");
                    }
                    break;
                case 2:
                    value = getValue();
                    if(value <= availablePoints){
                        this.strength += value;
                        availablePoints -= value;
                    }
                    else{
                        System.out.println("You don't have enough points!");
                    }
                    break;
                case 3:
                    value = getValue();
                    if(value <= availablePoints){
                        this.speech += value;
                        availablePoints -= value;
                    }
                    else{
                        System.out.println("You don't have enough points!");
                    }
                    break;
                case 4:
                    // isRunning = false;
                    break;

        }

    Game.clearScreen();
    }

    private void remove_character_points() {
        int value;
        Game.clearScreen();
        System.err.println("Which point you want to remove?");
        System.out.println("1. Health\n2. Strength\n3. Speech\n4. Back\n");
            switch (InputProvider.getInt("Choice to remove: ")) {
                case 1:
                    value = getValue();
                    if(value <= this.health){
                        this.health -= value;
                        availablePoints += value;
                    }
                    else{
                        System.out.println("You don't have enough points!");
                    }
                    break;
                case 2:
                    value = getValue();
                    if(value <= this.strength){
                        this.strength -= value;
                        availablePoints += value;
                    }
                    else{
                        System.out.println("You don't have enough points!");
                    }
                    break;
                case 3:
                    value = getValue();
                    if(value <= this.speech){
                        this.speech -= value;
                        availablePoints += value;
                    }
                    else{
                        System.out.println("You don't have enough points!");
                    }
                    break;                    
                case 4:
                    break;
            
        }
        Game.clearScreen();

    }


    private int getValue() {
        return InputProvider.getInt("How much?");

    }

    public void print_character() {
        System.out.println(
            "\nHealth: " + this.health +
            "\nStregth: " + this.strength +
            "\nSpeech: " + this.speech          
        );
    }

}