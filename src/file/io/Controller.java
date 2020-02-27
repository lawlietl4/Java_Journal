package file.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Controller {
    public static void run() {
        MainMenu();
    }

    private static void MainMenu() {

        String menu = "Welcome to the simple console journal in Java\n" + "What would you like to do today?\n" +
                "1) Write in your journal\n" +
                "2) Read journal's contents based on their day\n\n\n" +
                "0) Exit\n" +
                "Please enter what you would like to do: ";
        boolean isInvalid;
        int userChoice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("\n" + menu);
            try {
                String input = br.readLine();
                userChoice = Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                System.out.println("You must enter a valid number");
            } catch (IOException ioe) {
                System.out.println("There has been a major failure, please kill process");
            }
            isInvalid = userChoice < 0 || userChoice > 2;
            switch (userChoice) {
                case 1:
                    System.out.println("What do you want to name the file?: ");
                    Write.writeFile();
                    break;
                case 2:
                    System.out.print("Search for file: ");
                    String output = readFile.read();
                    System.out.print(output);
                    break;
                default:
                    break;
            }

        } while (isInvalid || userChoice > 0);
    }
}
