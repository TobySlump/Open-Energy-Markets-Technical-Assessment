import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LastChoiceComputer extends Computer {
    private int lastChoice;
    private String name;

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

    private List<Integer> getValidMoveList(){
        List<Integer> validMoveList = new ArrayList<Integer>();
        for (int moveIndex = 1; moveIndex <= options; moveIndex++){
            validMoveList.add(moveIndex);
        }
        return validMoveList;
    }
}
