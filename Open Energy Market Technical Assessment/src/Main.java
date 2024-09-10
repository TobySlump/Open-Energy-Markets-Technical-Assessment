import java.io.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        // Create the console object.
        Console console = System.console();
        if (console == null) {
            System.out.println(
                    "No console available");
            return;
        }

        System.out.println("Hello and welcome to my Rock Paper Scissors game!");

        // Note: User is locked into game mode once selected.
        System.out.println("Menu:" +
                "1) Original Rock Paper Scissors." +
                "2) Extended Rock Paper Scissors Lizard Spock" +
                "3) Quit");

        Boolean validGameMode = false;

        // Repeat game mode question until valid answer provided.
        while (!validGameMode) {
            String gameMode = console.readLine("Enter the game mode you would like to play (1, 2, 3): ");

            if (gameMode == "1" || gameMode == "2" || gameMode == "3") {
                validGameMode = true;
            }
        }
    }
}