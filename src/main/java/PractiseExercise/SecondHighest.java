package PractiseExercise;

/**
 * Created by nikithaperumalla on 6/2/14.
 */
import java.util.Scanner;
public class SecondHighest {
    public static void main(String[] args) {
            int highest = 0;
            int secondHighest = 0;
            int h[] = new int[5];
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the elements in an array");

            for (int i = 0; i < h.length; i++) {
                sc.nextInt();
                if (i >= highest) {  //checks the new highest number
                    secondHighest = highest; //assigns new highest number to secondHighest
                    highest = i;  //sets new highest
                } else if (i >= secondHighest) { //checks the highest and replaces it with secondHighest
                    secondHighest = i;

                }
            }
            System.out.println("secondHighest :" + secondHighest);
        }
    }


