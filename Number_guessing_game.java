import java.util.Random;
import java.util.Scanner;

public class Number_guessing_game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int randomnumber = random.nextInt(100)+1;
        int guess;
        int attempts =0;

        System.out.println(" ===Number guessing game=== ");
        System.out.println("guess number between 1 to 100 ");

        do{
            System.out.println("Guess your number: ");
             guess = sc.nextInt();

            attempts++;

            if(guess < randomnumber){
                System.out.println(" To Low ! Try again: ");
            }else if(guess > randomnumber){
                System.out.println("To Big ! Try again: ");
            }else{
                System.out.println("Congratulation you guess the right number: ");
                System.out.println("You took: " + attempts + " " +" attempts to guess the number ");
            }
        }while(guess != randomnumber);
    }
}
