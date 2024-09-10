import java.util.Random;

public class OriginalComputer extends Computer{

    private String name;

    public OriginalComputer(){
        this.name = "Glorious Common Computer!";
    }

    @Override
    protected String getName(){
        return name;
    }

    @Override
    public int getComputerMove(){
        // Randomly chooses a move.
        Random random = new Random();
        return random.nextInt(options) + 1;
    }
}
