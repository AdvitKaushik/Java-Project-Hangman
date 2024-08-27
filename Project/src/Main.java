import java.util.*;
public class Main {
    public static boolean signIn(String x, String y) {
        String[] usernames = {"password", "hy71djsay"};
        String[] passwords = {"username", "dj84bzeakgi2"};
        int index = 0;
        for (int i = 0; i < usernames.length; i++) { //Finding index of username
            if (x.equals(usernames[i])) {
                index = i;
            }
        }
        if (y.equals(passwords[index])) {
            return true; //Return true if inputted password is correct
        }
        return false;//return false if username/password is incorrect
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String wordnew;
        int count = 0, no_of_guesses = 5;
        //user Sign In
        System.out.println("Enter Username: ");
        String username = sc.nextLine(); //input username
        System.out.println("Enter Password: ");
        String password = sc.nextLine();//input password
        if (signIn(username, password)){
            System.out.println("Signing In...");
            for (long i = 1; i<=2000000000L; i++);
        }
        else{
            System.out.println("Wrong username or password");
            for (long i = 1; i<=2000000000L; i++);
            System.exit(0);
        }
        System.out.println("\t\tWELCOME TO HANGMAN\t\t\n -------------------------------- \n\n Are you ready? (y/n)");
        char ready = sc.next().charAt(0);
        if (ready == 'y' || ready == 'Y') {
            String[] words = {"ivory", "hall", "sail", "rice", "family", "licence", "triangle", "account", "miracle", "dollar", "work", "hour", "merit", "neglect", "cylinder"};
            String[] hints = {"Material from elephant tusks, used in carvings", "A big room or long hallway in a building", "A cloth that helps a boat move in the wind", "Small white grain, often served with meals", "People related by birth or marriage", "A paper that lets you do something legally", "A shape with three sides and three corners", "A place to keep money or log into apps", "Something amazing that seems impossible", "Money used in the United States", "Something you do, like a job or task", "A measure of time, 60 minutes long", "Something good you’ve done, deserving praise", "Not taking care of something important", "A shape like a can with round ends" };
            int num = (int) (Math.random() * words.length);
            String word = words[num];
            String hint = hints[num];
            wordnew = word; // Select random word from array "words"
            for (long i = 1; i<=2000000000L; i++);
            // Replace consonants with underscores
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != 'a' && word.charAt(i) != 'e' && word.charAt(i) != 'i' && word.charAt(i) != 'o' && word.charAt(i) != 'u') {
                    wordnew = wordnew.replace(wordnew.charAt(i), '_');
                }
            }
            System.out.println("Your hint is: " + hint);
            System.out.println("Your word is: ");
            while (true) {
                System.out.println(wordnew);
                System.out.println("You have " + (no_of_guesses - count) + " guesses");
                count++;
                System.out.println("Take your guess No." + count);
                char guess = sc.next().charAt(0);
                boolean correctGuess = false;

                // Check if the guessed character is in the word
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        wordnew = wordnew.substring(0, i) + guess + wordnew.substring(i + 1);
                        correctGuess = true;
                    }
                }
                for (long i = 1; i<=10000000L; i++);
                if (wordnew.equals(word)) {
                    for (long i = 1; i<=1000000000L; i++);
                    System.out.println("The word was " + word + "\nYou Win!!");
                    break;
                } else if (count > no_of_guesses) {
                    System.out.println("You ran out of guesses \nThe word was " + word);
                    break;
                } else {
                    if (correctGuess) {
                        System.out.println("CORRECT!");
                    } else {
                        System.out.println("WRONG!");
                    }
                }
            }
        }
        else {
            System.exit(0); //Exit if user says no
        }
    }
}
/*
              Variable Description Table
Variable Name	    Variable Type	Variable Use
usernames	        String Array	store Usernames
passwords	        String Array	store Passwords
index	            Int	            find index of Username in usernames array
i	                Int	            Loop Variable
sc	                Scanner         Scanner variable
username	        String	        store Username inputted by user
password	        String	        store  password inputted by user
wordnew	            string	        modify the random generated word word
words	            String Array	store words
hint	            String Array	store hints
num	                int	            select random word
count	            int	            Count Number of gusses
no_of_guesses	    int	            total number of gusses
guess	            String	        Guess inputted by user
word	            String	        word selected at random
correctGuess	    Boolean	        check whether guess is correct or not
*/