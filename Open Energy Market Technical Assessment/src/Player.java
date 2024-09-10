import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private int options;

    private Map<Integer, String> moveOptions;

    public Player(){
        this.moveOptions = new HashMap<Integer, String>();
        moveOptions.put(1, "Rock");
        moveOptions.put(2, "Paper");
        moveOptions.put(3, "Scissors");
        moveOptions.put(4, "Lizard");
        moveOptions.put(5, "Spock");
    }

    public void setOptions(String gameMode){
        this.options = 2 * Integer.parseInt(gameMode) + 1;
    }


    public String getUserMove() throws IOException {
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

        return userMove;
    }

    private List<String> getValidMoveList(){
        List<String> validMoveList = new ArrayList<String>();
        for (int moveIndex = 1; moveIndex <= options; moveIndex++){
            validMoveList.add(Integer.toString(moveIndex));
        }
        return validMoveList;
    }



}
