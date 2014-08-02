package com.masters.oops;

import junit.framework.TestCase;
import org.junit.Test;

import javax.swing.*;

/**
 * @author nikithaperumalla.
 * @id 87312
 *
 * This program validates the given credit card number
 * using Hans Luhn Algorithm
 */
public class CreditCardCheckNikitha extends TestCase {

    public static void main(String[] args){
        boolean tryAnotherCard = true;

        while(tryAnotherCard) {
            Object userInput = JOptionPane.showInputDialog(null, "Please enter the credit card number",
                    "Credit Card Number Validator", JOptionPane.INFORMATION_MESSAGE);

            if(userInput == null || userInput.toString().length() <= 0){

                JOptionPane.showMessageDialog(null, "This is an invalid credit card number",
                        "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);

            } else if(userInput.toString().length() < 13 || userInput.toString().length() < 16){

                JOptionPane.showMessageDialog(null, "This is an invalid credit card number \n Credit card number must be between 13 & 16 digits",
                        "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);

            } else {
                applyHansAlgorithm(userInput);
            }

            int retry = JOptionPane.showConfirmDialog(null, "Do you want to validate another credit card?");
            tryAnotherCard = (retry == 0); //resets retry another condition based on user input
        }
    }

    @Test
    public void testProgramWithPredefinedInputs(){
        String[] testInputs = {"4388576018410707", "4640182017102496", "5121071848156976",
                               "6011000593748746", "371515488281005", "4388576018402625",
                               "6011000593748745"};
        for(String cardNumber : testInputs){
            applyHansAlgorithm(cardNumber);
        }
    }

    /**
     * Performs the Hans Luhn Algorithm on the credit number
     * and validates the given credit card number
     *
     * @param userInput credit card number
     */
    public static void applyHansAlgorithm(Object userInput) {
        char[] cardNumber;
        cardNumber = userInput.toString().toCharArray();

        int firstDigit = Character.getNumericValue(cardNumber[0]);
        String cardType = null;
        switch (firstDigit){
            case 4:
                cardType = "Visa";
                if(isValid(cardNumber)){
                    JOptionPane.showMessageDialog(null, "This is a valid credit card. \n Credit Card Type : " + cardType,
                            "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "This is an invalid credit card number",
                            "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case 5:
                cardType = "Master";
                if(isValid(cardNumber)){
                    JOptionPane.showMessageDialog(null, "This is a valid credit card. \n Credit Card Type : "+cardType,
                            "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "This is an invalid credit card number",
                            "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case 6:
                cardType = "Discover";
                if(isValid(cardNumber)){
                    JOptionPane.showMessageDialog(null, "This is a valid credit card. \n Credit Card Type : "+cardType,
                            "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "This is an invalid credit card number",
                            "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            case 3:
                int secondDigit = Character.getNumericValue(cardNumber[1]);
                if(secondDigit == 7) {
                    cardType = "American Express";
                    if(isValid(cardNumber)){
                        JOptionPane.showMessageDialog(null, "This is a valid credit card. \n Credit Card Type : "+cardType,
                                "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "This is an invalid credit card number",
                            "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "This is an invalid credit card number",
                        "Credit Card Checker", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    /**
     * Performs the Hans Luhn Algorithm to check it the given
     * the card number is valid credit number or not
     *
     * @param cardNumber credit card number
     * @return is valid or not based of Hans Luhn Algorithm
     */
    public static boolean isValid(char[] cardNumber){
        boolean isValid = false;

        int sumOfEvenPlace = sumOfEvenPlace(cardNumber);
        int sumOfOddPlace = sumOfOddPlace(cardNumber);

        int finalSum = sumOfEvenPlace + sumOfOddPlace;

        if(finalSum % 10 == 0){
            isValid = true;
        }
        return isValid;
    }

    /**
     * Calculates the  sum of twice the even digit numbers from left to right
     * but if the twice the even digit value is a 2 digit num, then gets the sum of two digits
     *
     * @param cardNumber credit card number
     *
     * @return sum of twice the even digit numbers from left to right
     */
    public static int sumOfEvenPlace(char[] cardNumber){
        int sumOfEvenPlace = 0;

        for(int i=cardNumber.length-2; i >= 0; i=i-2){
            int twiceValue = 2 * Character.getNumericValue(cardNumber[i]);

            //If twice is value is a 2 digit num, then get the sum of digits
            if(twiceValue >= 10) {
                twiceValue = getDigitSum(twiceValue);
            }
            sumOfEvenPlace = sumOfEvenPlace + twiceValue;
        }

        return sumOfEvenPlace;
    }

    /**
     * Calculates the sum of digits at odd place from left to right
     *
     * @param cardNumber credit card number
     *
     * @return sum of digits at odd place from left to right
     */
    public static int sumOfOddPlace(char[] cardNumber){
        int sumOfOddPlace = 0;

        for(int i=cardNumber.length-1; i >= 0; i=i-2){
            sumOfOddPlace = sumOfOddPlace + Character.getNumericValue(cardNumber[i]);
        }

        return sumOfOddPlace;
    }

    /**
     * Calculates the sum of 2 digits in the given number
     *
     * @param twoDigitNumber two digit number
     *
     * @return sum of 2 digits in the given number
     */
    public static int getDigitSum(int twoDigitNumber){
        int unitsDigit = twoDigitNumber % 10;
        int tensDigit = twoDigitNumber / 10;

        return unitsDigit + tensDigit;
    }

}

