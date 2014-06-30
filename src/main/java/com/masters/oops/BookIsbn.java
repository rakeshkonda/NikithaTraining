package com.masters.oops;

/**
 * @author nikithaperumalla
 * @id 87312
 */

import java.util.Scanner;

/**
 * An ISBN book number consists of 10 digits 
 * D1D2D3D4D5D6D7D8D9D10 
 * The last digit D10 is a checksum which is calculated from the other 9 digits using the formula: 
 * (D1 x 1 + D2 x 2 + D3 x 3 + D4 x 4 + D5 x 5 + D6 x 6 + D7 x 7 + D8 x 8 + D9 x 9) % 11 
 * 
 * If the checksum is 10, the last digit is denoted as X. 
 */
public class BookIsbn {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("_________________________________________________________________");
        System.out.println("This program calculates the checksum of a 9-digit ISBN code and display the whole 10-digit ISBN.");

        System.out.println("Enter 9 digits for the ISBN code:");
        String userInput = sc.next();

        char checkSum = getCheckSum(userInput);
        String completeISBNCode = "";

        //Char checkSum to char '10' comparison  0306406152
        if(checkSum == Character.forDigit(10, 10)){
            completeISBNCode = userInput + 'X';
        } else {
            completeISBNCode = userInput + Character.getNumericValue(checkSum);
        }

        System.out.println("The complete ISBN code is "+completeISBNCode);
        System.out.println("_________________________________________________________________");
    }

    private static char getCheckSum(String input){
        //9 digit length check
        if(input.length() != 9){
            System.out.println("The input ISBN code is not valid.");
            System.exit(1);
        }

        char[] inputChars = input.toCharArray();

        int checkSum = 0;
        for(int i=0; i<inputChars.length; i++){
            //is digit check?
            boolean isDigit = checkIfDigit(inputChars[i]);
            if(!isDigit){
                System.out.println("The input ISBN code is not valid.");
                System.exit(1);
            }

            //Calculating the value of (D1 x 1 + D2 x 2 + D3 x 3 + D4 x 4 + D5 x 5 + D6 x 6 + D7 x 7 + D8 x 8 + D9 x 9)
            int numericVal = Character.getNumericValue(inputChars[i]);
            checkSum = checkSum +  numericVal * (i+1);
        }
        checkSum = checkSum % 11;
        System.out.println("Generated check sum value is " + checkSum);

        char result = Character.forDigit(checkSum,10);
        return result;
    }

    private static boolean checkIfDigit(char inputChar) {
        return (inputChar >= '0' && inputChar <= '9');
    }

}
