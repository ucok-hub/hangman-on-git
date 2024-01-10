import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordWarden {
    private Scanner keyboard;
    private List<String> words;
    private Random rand;
    private String word;
    private List<Character> playerGuesses;
    private int wrongCount;

    public WordWarden() throws FileNotFoundException {
        this.keyboard = new Scanner(System.in);
        this.words = new ArrayList<>();
        this.rand = new Random();
        this.word = "";
        this.playerGuesses = new ArrayList<>();
        this.wrongCount = 0;
    }

    public void playGame() throws FileNotFoundException {
        System.out.println("Welcome To Word Warden! How many prisoners want to join, 1 or 2?");
        String players = keyboard.nextLine();

        System.out.println("This prison at the mountain's end has kept the state safe from massive crime. The supreme judge is bored, so today, the criminals will be challenged to play a word game proposed by the supreme judge. If they beat the warden, they will be allowed to live, but if they lose, they will be given a punishment that makes them wish they were made of stone. ");

        if (players.equals("1")) {
            Scanner scanner = new Scanner(new File("C:/Users/Inspiron/Documents/PENTING/KATA INDO.txt"));

            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }

            word = words.get(rand.nextInt(words.size()));
        } else {
            System.out.println("Warden, please enter your word:");
            word = keyboard.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Be ready, O prisoner!");
        }

        while (true) {
            printHangedMan();

            if (wrongCount >= 6) {
                System.out.println("You lost! Get ready for something you'll never be ready for!");
                System.out.println("The word was: " + word);
                break;
            }

            printWordState();
            if (!getPlayerGuess()) {
                wrongCount++;
            }

            if (printWordState()) {
                System.out.println("You won. You deserve to live. But will you ever be free again?");
                break;
            }

            System.out.println("Please enter your guess for the word:");
            if (keyboard.nextLine().equals(word)) {
                System.out.println("You won. You deserve to live. But will you ever be free again?");
                break;
            } else {
                System.out.println("every mistake you make, the closer your regret will be. ");
            }
        }
    }

    private boolean printWordState() {
        return false;
    }

    private void printHangedMan() {
        System.out.println(" -------");
        System.out.println(" |     |");
        if (wrongCount >= 1) {
            System.out.println(" O");
        }

        if (wrongCount >= 2) {
            System.out.print("\\ ");
            if (wrongCount >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }

        if (wrongCount >= 4) {
            System.out.println(" |");
        }

        if (wrongCount >= 5) {
            System.out.print("/ ");
            if (wrongCount >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");
    }

    private boolean getPlayerGuess() {
        System.out.println("Please enter a letter:");

         {
            int correctCount = 0;
            for (int i = 0; i < word.length(); i++) {
                if (playerGuesses.contains(word.charAt(i))) {
                    System.out.print(word.charAt(i));
                    correctCount++;
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        return false;
    }

}
