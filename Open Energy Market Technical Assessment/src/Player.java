import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class containing the methods that allow the user to play the game.
 */
public class Player {
    private int options;

    private final Map<Integer, String> moveOptions;

    public Player(Map<Integer, String> moveOptions){
        this.moveOptions = moveOptions;
    }

    public void setOptions(String gameMode){
        this.options = 2 * Integer.parseInt(gameMode) + 1;
    }


    /**
     * Method that allows the user to enter a valid move.
     *
     * @return The move chosen by the user.
     */
    public int getUserMove() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userMove = null;

        for (int moveIndex = 1; moveIndex <= options; moveIndex++){
            System.out.println(moveIndex + ") "+ moveOptions.get(moveIndex));
        }

        boolean validUserMove = false;

        // Repeat user move question until valid move provided.
        while (!validUserMove){
            System.out.println("Choose your move:");
            userMove = reader.readLine();

            if (getValidMoveList().contains(userMove)){
                validUserMove = true;
            }
        }

        return Integer.parseInt(userMove);
    }

    /**
     * A method that produces a list of all possible moves this round, as strings.
     *
     * @return The list of possible moves.
     */
    private List<String> getValidMoveList(){
        List<String> validMoveList = new ArrayList<>();
        for (int moveIndex = 1; moveIndex <= options; moveIndex++){
            validMoveList.add(Integer.toString(moveIndex));
        }
        return validMoveList;
    }



}
