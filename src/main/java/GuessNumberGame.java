import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 100;
    private static final Scanner s = new Scanner(System.in);

    public void run(){
        boolean guessed = false;
        int randomNumber = getRandomNumber(MIN_NUMBER, MAX_NUMBER);
        System.out.printf("Random number is %d\n", randomNumber);
        System.out.printf("Guess a number between %d and %d\n", MIN_NUMBER, MAX_NUMBER);
        do {
            System.out.printf("Enter a number between %d and %d: ", MIN_NUMBER, MAX_NUMBER);
            String line = s.nextLine();
            if(isValidNumber(line)){
                int playerNumber = Integer.parseInt(line);
                guessed = guess(playerNumber, randomNumber);
            }
        }while(!guessed);
    }

    public boolean guess(int playerNumber, int numberToBeGuessed){
        boolean guess = playerNumber == numberToBeGuessed;
        System.out.printf(guess ? String.format("Number guessed correctly, user input: %d, random number was %d.\n",
                playerNumber, numberToBeGuessed) : "Your guess %d is wrong. The number should be %s.\n", playerNumber, playerNumber < numberToBeGuessed ?
                "higher" : "lower");
        return guess;
    }

    public int getRandomNumber(int smallest, int largest){
        return new Random().nextInt(smallest,largest);
    }

    public boolean isValidNumber(String line){
        try{
            int number = Integer.parseInt(line);
            return number >= 0 && number <= 100;
        }catch(NumberFormatException e){
            System.out.println("Input must be a whole number between 0 and 100.");
            return false;
        }
    }
}
