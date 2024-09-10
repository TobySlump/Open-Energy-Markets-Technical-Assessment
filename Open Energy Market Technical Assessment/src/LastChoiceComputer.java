import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Child class of the Computer class.
 * When used as an opponent, this class will return the previous move made by the user.
 * If there is no previous move or the previous move is invalid, a default random move will be made.
 */
public class LastChoiceComputer extends Computer {
    private int lastChoice;
    private final String name;

    public LastChoiceComputer() {
        this.name = "Mighty Last Choice Computer!";
        this.lastChoice = 0;
    }

    public void setLastChoice(int lastChoice) {
        this.lastChoice = lastChoice;
    }

    @Override
    protected String getName(){
        return name;
    }

    /**
     * Method called to produce a valid move.
     * If possible the previous move made by the user will be used.
     *
     * @return The move chosen by the computer as an integer.
     */
    @Override
    public int getComputerMove(){
        int computerMove;

        if (getValidMoveList().contains(lastChoice)){
            // Last move from user is a valid move this round.
            computerMove = lastChoice;

        }else{
            // Randomly chooses a move as no previous move is invalid.
            Random random = new Random();
            computerMove = random.nextInt(options) + 1;
        }

        return computerMove;
    }

    /**
     * A method to produce a list of all possible moves this round, as integers.
     *
     * @return The list of possible moves.
     */
    private List<Integer> getValidMoveList(){
        List<Integer> validMoveList = new ArrayList<>();
        for (int moveIndex = 1; moveIndex <= options; moveIndex++){
            validMoveList.add(moveIndex);
        }
        return validMoveList;
    }
}
