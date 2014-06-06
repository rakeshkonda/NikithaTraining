package com.masters.oops;

import java.util.Random;
import java.util.Scanner;

/**
 * @author nikithaperumalla
 */

 public class NumberGame87312{
    public static void main(String[] args) {
        playRandomNumberGame();
    }

    private static void playRandomNumberGame() {
        Scanner sc = new Scanner(System.in);

        try {
            int totalNumberOfGames = 0;
            int totalNumberOfWins = 0;
            int totalNumberOfLoses = 0;

            int userSelectedNumber = 0;
            Random random = new Random();
            int randomNum = random.nextInt(10);

            while(randomNum != userSelectedNumber){
                    //for loop to control the 3 trials
                    for(int j = 1 ; j <= 3; j++) {
                        System.out.println("Enter a number >= 1 and <= 10, or enter -1 to exit game:");
                        userSelectedNumber = sc.nextInt();

                        //user chooses to exit the game
                        if (userSelectedNumber == -1) {
                            System.out.println("You chose to exit the game. Exiting the game");
                            System.out.println("Game Summary");
                            System.out.println("Total Games: "+totalNumberOfGames);
                            System.out.println("Number of Wins: "+totalNumberOfWins);
                            System.out.println("Number of Losts: "+totalNumberOfLoses);
                            return;
                        }

                        //wins the game
                        if (userSelectedNumber == randomNum) {
                            totalNumberOfGames++;
                            totalNumberOfWins++;  //increasing the win count
                            System.out.println("Congratulations." + "Your guess is correct. \n"
                                    + "A new game starts now. \n");
                            randomNum = random.nextInt(10);
                            break;
                        } else {
                            totalNumberOfGames++;
                            System.out.println("Your guess is incorrect. Try again");
                            // looses the game
                            totalNumberOfLoses++; // increasing the losts count
                        }
                        if(j == 3)  {
                            System.out.println("3 trials have been exceeded." +
                                    " The correct answer is "+randomNum);

                            System.out.println("A new game starts now");
                            randomNum = random.nextInt(10);
                        }
                    }
                }
        }  catch (Exception e) {
            e.printStackTrace();
        }  finally {
            sc.close();
        }
    }
}

