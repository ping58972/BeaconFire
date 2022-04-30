package guessgame;
import java.util.Random;
/*
* @Author: Ping Danddank
* @email: ndanddank@gmail.com
The game is played by the program randomly generating a number and the user attempting
to guess that number.
After each guess the program will provide a hint to the user identifying the relationship
between the number and the guess.
If the guess is above the answer then “Too High” is returned, if the guess is below the answer
then “Too Low”.
Also if the difference between the answer and the guess is less than the difference between
the answer and the previous guess, “Getting warmer” is returned.
If the difference between the answer and the guess is more than the difference between the
answer and the previous guess, then “Getting Colder” is returned.
 */
public class GuessingGame {
    private int answer,         //  representing the randomly generated number
            max,                // maximum value of the number to guess.
            differential,       // the difference between a guess and the answer
            maxGuessesAllowed,  //  the maximum number of guesses the user gets,
                                //  once this value is passed the game is over.
            numGuessesTaken;    //  stores the number of guessed taken so far in any game.
    private Random generator;   // a random Generator object
    private boolean gameOver;   //  false if game still in progress, true if the game is over

    public GuessingGame(){
        setMax(0);
        generator = new Random();
    }
    public GuessingGame(int max){
        setMax(max);
        generator = new Random();
    }
    /*
    * Takes in an integer as a parameter representing
    * the maximum number of guesses and
    * sets maxGuessesAllowed.
    * @params:
    *     maxGuessesAllowed - int
    * @return:
    * */
    public void newGame(int maxGuessesAllowed){
        setMaxGuessesAllowed(maxGuessesAllowed);
        setAnswer(generator.nextInt(max+1));
        setGameOver(false);
        setDifferential(5);
        setNumGuessesTaken(0);
    }
    /*
     * Takes an integer as a parameter representing a new guess.
     * Compares the new guess with the answer and generates
     * and returns a String representing an appropriate response
     * @params:
     *     newGuess - int -> from user input.
     * @return:
     *      String -> an appropriate response.
     * */
    public String guess(int newGuess){
        if(++numGuessesTaken > maxGuessesAllowed ){
            setGameOver(true);
            return "You have taken too many guess, and beyond maximum guesses allowed!";
        }
        if(newGuess<0 || newGuess > this.max)
            return "Guess out of range, The guess must be between 0 and 50";
        if(newGuess == answer){
            setGameOver(true);
            return "Congratulation";
        }
        if(newGuess > (answer + differential))
            return "Too High!";
        if(newGuess > answer)
            return "Getting Colder";
        if(newGuess < (answer - differential))
            return "Too Low";
        if(newGuess < answer)
            return "Getting Warmer";
        // otherwise return empty string.
        return "";
    }
    // return state of game when it's running.
    public boolean isGameOver(){
        return gameOver;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getDifferential() {
        return differential;
    }

    public void setDifferential(int differential) {
        this.differential = differential;
    }

    public int getMaxGuessesAllowed() {
        return maxGuessesAllowed;
    }

    public void setMaxGuessesAllowed(int maxGuessesAllowed) {
        this.maxGuessesAllowed = maxGuessesAllowed;
    }

    public int getNumGuessesTaken() {
        return numGuessesTaken;
    }

    public void setNumGuessesTaken(int numGuessesTaken) {
        this.numGuessesTaken = numGuessesTaken;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public String toString() {
        return "GuessingGame{" +
                "answer=" + answer +
                ", max=" + max +
                ", differential=" + differential +
                ", maxGuessesAllowed=" + maxGuessesAllowed +
                ", numGuessesTaken=" + numGuessesTaken +
                ", gameOver=" + gameOver +
                '}';
    }
}
