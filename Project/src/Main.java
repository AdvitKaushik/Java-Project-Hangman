import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wordNew;
        char playAgain;
        int count = 1, no_of_guesses = 5;
        String[] words = {"ivory", "hall", "sail", "rice", "family", "licence", "triangle", "account", "miracle", "dollar", "work", "hour", "merit", "neglect", "cylinder"}; // Array of all words
        System.out.println("\t\t\u001B[1m WELCOME TO HANGMAN \nAre you ready? (y/n)");
        char ready = sc.next().charAt(0);
        if (ready == 'y' || ready == 'Y') {
            do {
                count = 1;
                no_of_guesses = 5;
                int num = (int) (Math.random() * words.length);
                String word = words[num];
                wordNew = word; // Select random word from array "words"

                // Replace consonants with underscores
                for (int j = 0; j < word.length(); j++) {
                    if (word.charAt(j) != 'a' && word.charAt(j) != 'e' && word.charAt(j) != 'i' && word.charAt(j) != 'o' && word.charAt(j) != 'u') {
                        wordNew = wordNew.replace(wordNew.charAt(j), '_');
                    }
                }

                System.out.println("Your word is: ");
                while (true) {
                    System.out.println(wordNew);
                    System.out.println("Take your guess No." + count);
                    count++;
                    char guess = sc.next().charAt(0);
                    boolean correctGuess = false; // Flag variable to check ig guess is correct

                    // Check if the guessed character is in the word
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == guess) {
                            wordNew = wordNew.substring(0, i) + guess + wordNew.substring(i + 1); // Add guess into the word
                            correctGuess = true;
                        }
                    }

                    if (wordNew.equals(word)) {
                        System.out.println("The word was " + word + "\nYou Win!!");
                        break;
                    } else if (count > no_of_guesses) {
                        System.out.println("You ran out of guesses \nThe word was " + word);
                        break;
                    } else {
                        if (correctGuess) {
                            System.out.println("CORRECT! \nYou have " + (no_of_guesses - count) + " guesses left");
                        } else {
                            System.out.println("WRONG!! \nYou have " + (no_of_guesses - count) + " guesses left");
                        }
                    }
                }
                System.out.println("\nPlay Again? (y/n)");
                playAgain = sc.next().charAt(0);
            }
            while (playAgain == 'y' || playAgain == 'Y');
        }
        else {
            System.exit(0); //Exit if user says no
        }
    } //main()
}//Class