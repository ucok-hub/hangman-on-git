import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Game {
    protected String word;
    protected List<Character> playerGuesses;
    protected int wrongCount;

    public Game() {
        this.word = "";
        this.playerGuesses = new ArrayList<>();
        this.wrongCount = 0;
    }

    protected void printHangedMan() {
        System.out.println(" -------");
        System.out.println(" |     |");
        if (this.wrongCount >= 1) {
            System.out.println(" O");
        }

        if (this.wrongCount >= 2) {
            System.out.print("\\ ");
            if (this.wrongCount >= 3) {
                System.out.println("/");
            } else {
                System.out.println("");
            }
        }

        if (this.wrongCount >= 4) {
            System.out.println(" |");
        }

        if (this.wrongCount >= 5) {
            System.out.print("/ ");
            if (this.wrongCount >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
        }
        System.out.println("");
    }

    protected void printWordState() {
        boolean wordGuessed = true;
        for (char c : this.word.toCharArray()) {
            if (this.playerGuesses.contains(c)) {
                System.out.print(c + " ");
            } else {
                System.out.print("_ ");
                wordGuessed = false;
            }
        }
        System.out.println("");
    }

    protected void getPlayerGuess(Scanner keyboard) {
        System.out.println("Enter your guess:");
        String guess = keyboard.nextLine();
        char c = guess.charAt(0);
        if (this.word.contains(guess)) {
            System.out.println("Good guess!");
            this.playerGuesses.add(c);
        } else {
            System.out.println("Salah guess!");
            this.playerGuesses.add(c);
        }
    }

    public void play() throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the Word Warden Game!");
        System.out.println("Try to guess the word before the man is hanged.");
        System.out.println("Enter a letter at a time. Good luck!");
        System.out.println("");

        // Logic to initialize the game, set the word to be guessed, etc.
        // ...

        while (this.wrongCount < 6) {
            printHangedMan();
            printWordState();
            getPlayerGuess(keyboard);

            // Logic to check if the word has been guessed or if the player has lost
            // ...
        }

        System.out.println("You lost! The word was: " + this.word);
        keyboard.close();
    }
}

public class WordWarden extends Game {
    public static void main(String[] args) throws FileNotFoundException {
        WordWarden wordWarden = new WordWarden();
        wordWarden.play();
    }

    // Optionally, you can override any methods from the Game class
    // to provide custom implementation specific to WordWardenGame

    @Override
    protected void printHangedMan() {
        // Custom implementation for printing hanged man in WordWardenGame
        // ...
    }

    @Override
    protected void printWordState() {
        // Custom implementation for printing word state in WordWardenGame
        // ...
    }

    @Override
    protected void getPlayerGuess(Scanner keyboard) {
        // Custom implementation for getting player's guess in WordWardenGame
        // ...
    }

    @Override
    public void play() throws FileNotFoundException {
        // Custom implementation for playing the game in WordWardenGame
        // ...
    }
}