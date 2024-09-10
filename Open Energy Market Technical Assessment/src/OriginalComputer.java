import java.util.Random;

/**
 * Child class of the Computer class.
 * When used as an opponent, this class will return a random move.
 */
public class OriginalComputer extends Computer{

    private final String name;

    public OriginalComputer(){
        this.name = "Glorious Common Computer!";
    }

    @Override
    protected String getName(){
        return name;
    }

    /**
     * Method to generate a random valid move.
     *
     * @return The chosen  move.
     */
    @Override
    public int getComputerMove(){
        // Randomly chooses a move.
        Random random = new Random();
        return random.nextInt(options) + 1;
    }
}
