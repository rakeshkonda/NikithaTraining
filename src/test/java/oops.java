/**
 * Created by nikithaperumalla on 5/28/14.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



        import java.util.Random;
        import java.util.Scanner;

/**
 *
 * @author nikithaperumalla
 */

 public class oops{
    public static void main(String[] args) {
        int i=1;
        int num;
        System.out.println("Enter a number >= 1 and <= 10, or enter -1 to exit game:");
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        Random random = new Random();
        while(i<=3){
            if (num != -1) {
                int ran_Num = random.nextInt(10);

                if (num == ran_Num) {
                    System.out.println("Congratulations." + "Your guess is correct. \n"
                            + "A new game starts now. \n"
                            + "Enter a number >= 1 and <= 10, or enter -1 to exit game: ");


                 }
            }
            else {
                System.out.println("enter num");
            }
        }

    }

}

