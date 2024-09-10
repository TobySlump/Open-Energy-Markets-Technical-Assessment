import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }

    public void run() throws IOException {

        // Set up reader to obtain user inputs.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Set up player and computer objects.
        Player player = new Player();
        OriginalComputer originalComputer = new OriginalComputer();
        LastChoiceComputer lastChoiceComputer = new LastChoiceComputer();

        // Set up game parameters.
        String gameMode = null;
        String opponent = null;

        System.out.println("Hello and welcome to my Rock Paper Scissors game!");

        boolean keepPlaying = true;
        while (keepPlaying){
            gameMode = chooseGameMode(reader);

            // Exit keepPlaying loop preemptively if "Quit" option is chosen.
            if (gameMode.equals("3")){
                break;
            }

            opponent = chooseOpponent(reader);


            // Play chosen game.
            player.setOptions(gameMode);
            originalComputer.setOptions(gameMode);
            lastChoiceComputer.setOptions(gameMode);



        }
    }

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
}