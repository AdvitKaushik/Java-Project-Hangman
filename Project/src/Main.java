import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wordnew;
        int count = 1, no_of_guesses = 5;

        System.out.println("\t\tWELCOME TO HANGMAN \nAre you ready? (y/n)");
        char ready = sc.next().charAt(0);
        if (ready == 'y' || ready == 'Y') {
            String[] words = {"ivory", "hall", "sail", "rice", "family", "licence", "triangle", "account", "miracle", "dollar", "work", "hour", "merit", "neglect", "cylinder"}; // Array of all words
            int num = (int) (Math.random() * words.length);
            String word = words[num];
            wordnew = word; // Select random word from array "words"

            // Replace consonants with underscores
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) != 'a' && word.charAt(j) != 'e' && word.charAt(j) != 'i' && word.charAt(j) != 'o' && word.charAt(j) != 'u') {
                    wordnew = wordnew.replace(wordnew.charAt(j), '_');
                }
            }

            System.out.println("Your word is: ");
            while (true) {
                System.out.println(wordnew);
                System.out.println("Take your guess No." + count);
                count++;
                char guess = sc.next().charAt(0);
                boolean correctGuess = false;

                // Check if the guessed character is in the word
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordnew = wordnew.substring(0, i) + guess + wordnew.substring(i + 1);
                        correctGuess = true;
                    }
                }

                if (wordnew.equals(word)) {
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
        }
        else {
            System.exit(0); //Exit if user says no
        }
    }
}
