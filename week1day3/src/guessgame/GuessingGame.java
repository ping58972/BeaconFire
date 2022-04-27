package guessgame;

import java.util.Random;

public class GuessingGame {
    private int answer, max, differential,
            maxGuessesAllowed, numGuessesTaken;
    private Random generator;
    private boolean gameOver;

    public GuessingGame(){
        setMax(0);
        generator = new Random();
    }
    public GuessingGame(int max){
        setMax(max);
        generator = new Random();
    }
    public void newGame(int maxGuessesAllowed){
        setMaxGuessesAllowed(maxGuessesAllowed);
        setAnswer(generator.nextInt(max+1));
        setGameOver(false);
        setDifferential(5);
        setNumGuessesTaken(0);
    }
    public void guess(int newGuess){
        if(newGuess == answer){
            System.out.println("It's correct. You Win!");
            setGameOver(true);
        }
        else if(newGuess > (answer + differential)){
            System.out.println("Too High!");
        } else if(newGuess < (answer - differential)){

        }
    }
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
}
