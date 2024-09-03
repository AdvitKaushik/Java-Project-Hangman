import java.util.*;
public class Main {

    // Method to sign in the user by checking the username and password
    public static boolean signIn(String x, String y) {
        // Arrays to store usernames and corresponding passwords
        String[] usernames = {"password", "hy71djsay"};
        String[] passwords = {"username", "dj84bzeakgi2"};
        int index = 0;

        // Loop through the usernames to find the index of the inputted username
        for (int i = 0; i < usernames.length; i++) {
            if (x.equals(usernames[i])) {
                index = i; // Store the index of the matched username
            }
        }

        // Check if the inputted password matches the password at the found index
        if (y.equals(passwords[index])) {
            return true; // Return true if the password is correct
        }
        return false; // Return false if the username/password is incorrect
    }
    public static void drawLine(int x) {
        for (int i = 0; i < x; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wordnew; // Variable to store the word with underscores
        int count = 0, no_of_guesses = 5; // Initialize guess counter and max guesses

        // User Sign In
        System.out.println("Enter Username: ");
        String username = sc.nextLine(); // Input username
        System.out.println("Enter Password: ");
        String password = sc.nextLine(); // Input password

        // Validate the username and password
        if (signIn(username, password)) {
            System.out.println("Signing In...");
            for (long i = 1; i <= 2000000000L; i++); // Simulate a delay for signing in
        } else {
            System.out.println("Wrong username or password");
            for (long i = 1; i <= 2000000000L; i++); // Simulate a delay before exiting
            System.exit(0); // Exit the program if credentials are incorrect
        }

        // Game introduction
        System.out.println("\n\tWELCOME TO HANGMAN\t\t");
        drawLine(34);
        System.out.println("Are You Ready (y/n)");
        char ready = sc.next().charAt(0); // Check if the user is ready to play

        if (ready == 'y' || ready == 'Y') {
            // Arrays of words and corresponding hints
            String[] words = {"ivory", "hall", "sail", "rice", "family", "licence", "triangle", "account", "miracle", "dollar", "work", "hour", "merit", "neglect", "cylinder"};
            String[] hints = {"Material from elephant tusks, used in carvings", "A big room or long hallway in a building", "A cloth that helps a boat move in the wind", "Small white grain, often served with meals", "People related by birth or marriage", "A paper that lets you do something legally", "A shape with three sides and three corners", "A place to keep money or log into apps", "Something amazing that seems impossible", "Money used in the United States", "Something you do, like a job or task", "A measure of time, 60 minutes long", "Something good you’ve done, deserving praise", "Not taking care of something important", "A shape like a can with round ends" };

            // Select a random word and hint
            int num = (int) (Math.random() * words.length);
            String word = words[num];
            String hint = hints[num];
            wordnew = word; // Store the selected word for modification

            for (long i = 1; i <= 2000000000L; i++); // Simulate a delay before starting the game

            // Replace consonants in the word with underscores
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != 'a' && word.charAt(i) != 'e' && word.charAt(i) != 'i' && word.charAt(i) != 'o' && word.charAt(i) != 'u') {
                    wordnew = wordnew.replace(wordnew.charAt(i), '_');
                }
            }

            // Display the hint and the word with underscores
            System.out.println("Your hint is: " + hint);
            System.out.println("Your word is: ");

            while (true) {
                // Display the word with guessed letters and remaining guesses
                System.out.println(wordnew);
                System.out.println("You have " + (no_of_guesses - count) + " guesses");
                System.out.println("Take your guess No." + (count + 1));
                char guess = sc.next().charAt(0); // Input the user's guess
                boolean correctGuess = false;

                // Check if the guessed character is in the word
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordnew = wordnew.substring(0, i) + guess + wordnew.substring(i + 1);
                        correctGuess = true; // Mark as a correct guess
                    }
                }

                for (long i = 1; i <= 10000000L; i++); // Simulate a delay after each guess

                // Check if the user has guessed the entire word
                if (wordnew.equals(word)) {
                    for (long i = 1; i <= 1000000000L; i++); // Simulate a delay before displaying the win message
                    System.out.println("The word was " + word + "\nYou Win!!");
                    break;
                }
                else if (count >= no_of_guesses - 1) { // Check if the user has run out of guesses
                    System.out.println("You ran out of guesses \nThe word was " + word);
                    break;
                }
                else {
                    // Display feedback for the user's guess
                    if (correctGuess) {
                        System.out.println("CORRECT!");
                    }
                    else {
                        System.out.println("WRONG!");
                    }
                    count++; // Increment the guess counter
                }
            }
        } else {
            System.exit(0); // Exit if the user is not ready to play
        }
    }
}

/*                  Variable Description Table

            | Variable Name | Variable Type | Variable Use |
            |---------------|---------------|--------------|
            | `usernames`   | `String[]`    | Stores the usernames for sign-in.
            | `passwords`   | `String[]`    | Stores the corresponding passwords for sign-in.
            | `index`       | `int`         | Stores the index of the found username in the `usernames` array.
            | `i`           | `int`         | Loop variable for iterating through arrays and string characters.
            | `sc`          | `Scanner`     | Scanner object for taking input from the user.
            | `username`    | `String`      | Stores the username inputted by the user.
            | `password`    | `String`      | Stores the password inputted by the user.
            | `wordnew`     | `String`      | Stores the randomly generated word with consonants replaced by underscores.
            | `words`       | `String[]`    | Stores an array of words for the Hangman game.
            | `hints`       | `String[]`    | Stores an array of hints corresponding to the words in the `words` array.
            | `num`         | `int`         | Stores a random index used to select a word and its corresponding hint.
            | `count`       | `int`         | Tracks the number of guesses the user has made.
            | `no_of_guesses` | `int`       | Stores the total number of allowed guesses (set to 5).
            | `guess`       | `char`        | Stores the character guessed by the user.
            | `word`        | `String`      | Stores the randomly selected word for the game.
            | `correctGuess` | `boolean`    | Indicates whether the user's guess is correct (i.e., if the guessed character is in the word).
            | `ready`       | `char`        | Stores the user's response to whether they are ready to play (y/n).
 */