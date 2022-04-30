package guessgame;
/*
* @Author: Ping Danddank
* @email: ndanddank@gmail.com
a. This program will create GuessingGame objects and completely test the GuessingGame Class.
b. The tester will also provide two loops.
c. The first loop will allow the user to play a new game after the previous game is completed.
d. The second or nested loop will prompt the user for a new guess and provide a response
based on the guess.
* */
import java.util.Scanner;

public class GuessingGameTester {
    public static void main(String[] args) {
        GuessingGame guessingGame = new GuessingGame();
        Scanner scan = new Scanner(System.in);
        playGameLoop(guessingGame, scan); // play game in loop until game over, then go to next round.
        System.out.println("Would you like to play again, enter Y for yes, N for no.");
        String playAgain = scan.next(); // "y" if want to play again else stop game.
        while(playAgain.equalsIgnoreCase( "Y") ){
            playGameLoop(guessingGame, scan);// play game in loop until game over, then go to next round.
            System.out.println("Would you like to play again, enter Y for yes, N for no.");
            playAgain = scan.next(); // "y" if want to play again else stop game.
        }
        System.out.println("Good Bye!");
        scan.close();
    }
    // method for playing game one round on looping.
    private static void playGameLoop(GuessingGame guessingGame, Scanner scan){
        System.out.println("Welcome to the Guessing Game");
        System.out.println("Enter the maximum number");
        guessingGame.setMax(scan.nextInt());
        System.out.println("Enter the number of guess allowed:");
        guessingGame.newGame(scan.nextInt());
        System.out.println("The answer is: "+ guessingGame.getAnswer());
        while(!guessingGame.isGameOver()){
            System.out.println("Enter your guess, remember it must be between 0 and "+ guessingGame.getMax());
            String guess = guessingGame.guess(scan.nextInt());
            if(guess != "")
                System.out.println(guess);
        }
    }
}
