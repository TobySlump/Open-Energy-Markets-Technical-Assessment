import java.io.*;
import java.util.*;

public class Main {
    private Player player;
    private OriginalComputer originalComputer;
    private LastChoiceComputer lastChoiceComputer;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }


    /**
     * The public method called from the Main class that contains the game code.
     */
    public void run() throws IOException {

        // Set up reader to obtain user inputs.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Set up move options dictionary.
        Map<Integer, String> moveOptions = new HashMap<>();
        moveOptions.put(1, "Rock");
        moveOptions.put(2, "Paper");
        moveOptions.put(3, "Scissors");
        moveOptions.put(4, "Lizard");
        moveOptions.put(5, "Spock");

        // Set up player and computer objects.
        player = new Player(moveOptions);
        originalComputer = new OriginalComputer();
        lastChoiceComputer = new LastChoiceComputer();

        System.out.println("Hello and welcome to my Rock Paper Scissors game!");

        boolean keepPlaying = true;
        while (keepPlaying){
            // Allow user to choose the game mode.
            String gameMode = chooseGameMode(reader);

            // Exit keepPlaying loop preemptively if "Quit" option is chosen.
            if (gameMode.equals("3")){
                break;
            }

            // Allow user to choose their opponent.
            String opponent = chooseOpponent(reader);


            // Play chosen game.
            playGame(gameMode, opponent, moveOptions);

            // Ask for a rematch.
            System.out.println("Thank you for playing, would you like a rematch? (y/n)");
            String userRematchInput = reader.readLine().toLowerCase();
            if (!(userRematchInput.equals("y") ||
                    userRematchInput.equals("yes"))){
                keepPlaying = false;
            }
        }
    }

    /**
     * Method that allows the user to choose which of the presented options they would like to play.
     *
     * @param reader BufferedReader object used to record user inputs in the terminal.
     * @return The chosen game mode option.
     */
    public String chooseGameMode(BufferedReader reader) throws IOException {
        String gameMode = null;

        System.out.println("""
                Menu:\s
                1) Original Rock Paper Scissors.\s
                2) Extended Rock Paper Scissors Lizard Spock\s
                3) Quit""");

        boolean validGameMode = false;

        // Repeat game mode question until valid answer provided.
        while (!validGameMode) {
            System.out.println("Enter the game mode you would like to play (1, 2, 3): ");
            gameMode = reader.readLine();

            if (Objects.equals(gameMode, "1")
                    || Objects.equals(gameMode, "2")
                    || Objects.equals(gameMode, "3")) {
                validGameMode = true;
            }
        }

        return gameMode;
    }

    /**
     * Method that allows the user to choose which of the presented opponents they would like to face.
     *
     * @param reader BufferedReader object used to record user inputs in the terminal.
     * @return The chosen opponent option.
     */
    public String chooseOpponent(BufferedReader reader) throws IOException{
        String opponent = null;

        System.out.println("""
                Opponent Options:\s
                1) Random Computer.\s
                2) Last Choice Computer""");

        boolean validOpponent = false;

        // Repeat opponent question until valid answer provided.
        while (!validOpponent){
            System.out.println("Enter the opponent you would like to face (1, 2): ");
            opponent = reader.readLine();

            if (Objects.equals(opponent, "1")
                    || Objects.equals(opponent, "2")){
                validOpponent = true;
            }
        }

        return opponent;
    }

    /**
     *
     * The method that runs the Rock-Paper-Scissor game steps.
     *
     * @param gameMode The game mode previously selected by the user.
     * @param opponent The computer mode previously selected by the user.
     * @param moveOptions A dictionary of the possible moves.
     */
    public void playGame(String gameMode, String opponent, Map<Integer, String> moveOptions) throws IOException {
        player.setOptions(gameMode);
        originalComputer.setOptions(gameMode);
        lastChoiceComputer.setOptions(gameMode);

        // Set opponent computer.
        Computer computer = switch (opponent) {
            case "1" -> originalComputer;
            case "2" -> lastChoiceComputer;
            default -> new Computer();
        };


        System.out.println();
        System.out.println("""
                You are facing the\040""" + computer.getName());

        // Let player and computer choose their moves.
        int userMove = player.getUserMove();
        int computerMove = computer.getComputerMove();

        // Initiate matrix of win/loss combinations.
        List<List<Integer>> winLossMatrix = new ArrayList<>(List.of(
                List.of(0, -1, 1, 1, -1),
                List.of(1, 0, -1, -1, 1),
                List.of(-1, 1, 0, 1, -1),
                List.of(-1, 1, -1, 0, 1),
                List.of(1, -1, 1, -1, 0)
        ));

        int gameOutcome = winLossMatrix.get(userMove - 1).get(computerMove - 1);

        // Declare winner.
        switch (gameOutcome) {
            case 0 -> System.out.println("Same move chosen, you draw!");
            case 1 -> System.out.println(moveOptions.get(userMove) + " beats " +
                    moveOptions.get(computerMove) + ", you win!");
            case -1 -> System.out.println(moveOptions.get(userMove) + " loses to " +
                    moveOptions.get(computerMove) + ", you lose!");
        }

        // update last user move within LastChoiceComputer object.
        lastChoiceComputer.setLastChoice(userMove);
    }
}