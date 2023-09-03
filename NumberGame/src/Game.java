import java.util.Random;
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int randomNumber ;
        System.out.println("     Welcome to Number Game    ");
        System.out.println(" 1. Guess number should be 1 to 100");
        System.out.println(" 2. Only 5 attempts allowed");
        System.out.println(" 3. TO exit enter 0");
        Scanner sc = new Scanner(System.in);
        boolean retry = true;
        while(retry){
            randomNumber = (int)Math.floor(Math.random() * (max - min + 1) + min);
            playGame(randomNumber, sc);
            System.out.println("All attempts done play again");
            System.out.println(" 1. Retry");
            System.out.println(" 2. Exit");
            int nextStep= sc.nextInt();
            if(nextStep == 2){
                retry = false;
            }
        }
        System.out.println(" Thanks");
    }
    static void playGame(int randomNumber, Scanner sc){
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter the guess number");
            int guess = sc.nextInt();
            if (randomNumber == guess) {
                System.out.println("correct");
                System.out.println("your total attempts:" + i);
                System.out.println("you won");
            }else if(guess==0){
                System.out.println("you exist");
                System.out.println("your total attempts:" + i);
                break;
            } else if ((randomNumber - 10 < guess) && (randomNumber +10 > guess)) {
                System.out.println("too low");
            } else {
                System.out.println("too high");
            }
        }
    }
}


