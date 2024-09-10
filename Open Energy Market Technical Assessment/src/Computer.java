/**
 * Parent class that contains the base parameters and methods for the computer opponent.
 */
public class Computer {
    protected int options;
    protected String name;

    public Computer(){

    }

    protected void setOptions(String gameMode) {
        this.options = 2 * Integer.parseInt(gameMode) + 1;
    }

    protected String getName(){
        return name;
    }

    protected int getComputerMove(){
        return 1;
    }
}
