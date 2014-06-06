package PractiseExercise;

/**
 * Created by nikithaperumalla on 6/2/14.
 */
import java.util.Scanner;

public class StringReverse {

    public static void main(String[] args) {
        String original;
        String reverse = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter original String :");
        original = sc.nextLine();
        for (int i = original.length() - 1; i >= 0; i--) {//points to last character of string
            reverse = reverse + original.charAt(i);
        }
        System.out.println("Reverse of a string : " + reverse);

        //another method of reversing a string

        System.out.println("Enter original String :");
        original = sc.nextLine();
        String result = new StringBuffer(original).reverse().toString();
        System.out.println(result);
    }
}