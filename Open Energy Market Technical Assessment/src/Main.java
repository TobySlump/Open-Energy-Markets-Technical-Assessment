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

        System.out.println("Hello and welcome to my Rock Paper Scissors game!");

        // Note: User is locked into game mode once selected.
        System.out.println("""
                Menu:\s
                1) Original Rock Paper Scissors.\s
                2) Extended Rock Paper Scissors Lizard Spock\s
                3) Quit""");

        boolean validGameMode = false;

        // Repeat game mode question until valid answer provided.
        while (!validGameMode) {
            System.out.println("Enter the game mode you would like to play (1, 2, 3): ");
            String gameMode = reader.readLine();

            if (Objects.equals(gameMode, "1")
                    || Objects.equals(gameMode, "2")
                    || Objects.equals(gameMode, "3")) {
                validGameMode = true;
            }
        }
    }
}