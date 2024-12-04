// CODSOFT NOVEMBER BATCH 2024
// JAVA PROGRAMMING
// Sehrish Kazmi
// TASK 1: Random Number Generator
import java.util.Scanner;
public class Random_Number_Generator {
    public static void main(String[] args) {
        Scanner round = new Scanner(System.in);
        System.out.println("How many rounds would you like to play?");
        //Enter no. of rounds
        int rounds = round.nextInt();
        int score = 0; //cumulative score of all rounds played
        for(int i=1; i<=rounds; i++){
            System.out.println("\nROUND "+i);
            System.out.println("Generating a random number...");
            //Generates a random number within the range 0-100
            int randnum = (int) (Math.random()*101);
            //System.out.println(randnum);
            System.out.println("Take a guess at what that number is!");
            int guess = 0;
            int no_of_guesses = 0;
            int guesses_left = 15;

            while (guess!=randnum){
                //input function to ask user to enter a guess
                Scanner number = new Scanner(System.in);
                System.out.println("\nYou have "+guesses_left+" guesses left.");
                System.out.println("Please enter your guess: ");
                guess = number.nextInt();
                //check if number is >, < or = to randnum
                if (guess  == randnum) {
                    System.out.println("\nYour guess is correct. You won!");
                } else if (guess > randnum) {
                    System.out.println("\nYour guess is greater than the number.");
                } else if (guess < randnum) {
                    System.out.println("\nYour guess is less than the number");
                } else {
                    System.out.println("\nYour guess is not a number.");
                }
                //counter increment: no of guesses taken
                no_of_guesses++;
                //counter decrement: no of guesses left
                guesses_left--;
                if (guesses_left==0) {
                    System.out.println("Out of guesses. You lost!");
                    //break if user loses
                    break;
                }
            }
            //print scores
            System.out.println("The randomly generated number was: "+randnum);
            System.out.println("Used Guesses: "+no_of_guesses);
            System.out.println("Guesses Remaining: "+guesses_left);
            System.out.println("Your score for this round is: "+guesses_left);
            score += guesses_left;
        }
        System.out.println("Your cumulative score is: "+score);
    }
}