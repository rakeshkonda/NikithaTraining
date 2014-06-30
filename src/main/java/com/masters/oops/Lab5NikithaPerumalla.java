package com.masters.oops;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author nikithaperumalla
 * @id 87312
 */
public class Lab5NikithaPerumalla {


    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        int randomMinRange = 1;
        int randomMaxRange = 1000;

        System.out.println("Enter a number between 1 to 100");
        int n = sc.nextInt();  //User input taken into the variable "n"

        /**
         * Generating "n" number of random numbers which ranges between 1 to 1000
         * and storing them in array list
         */
        ArrayList<Integer> randomIntegers = new ArrayList<Integer>();
        Random rand = new Random();
        int range = randomMaxRange - randomMinRange + 1;
        int randomNum;
        int i = 1;

        //collecting "n" number of random integers into array list
        while (i <= n){
            randomNum = rand.nextInt(range) + randomMinRange;
            randomIntegers.add(randomNum);
            i++;
        }

        for(int j = 0; j < randomIntegers.size(); j++){
            System.out.print(randomIntegers.get(j) + "\t");
        }

        //Printing an empty extra line
        System.out.println();

        System.out.println("Enter a number to search for: ");
        int searchElement = sc.nextInt();

        String searchResult = null;
        boolean numberFound = false;


        //Searching for user given input element in the array list
        for(int index = 0; index < randomIntegers.size(); index++){
            //if search element and array element is equal, number found
            if(randomIntegers.get(index) == searchElement){
                searchResult = "The Search Number "+searchElement+" found at index "+index+" in the list";
                numberFound = true;
            }
        }

        if(!numberFound){
            searchResult = "Number not found in the list";
        }
        System.out.println(searchResult);

        //Writing the program output, random numbers generated to output file
        writeToOutputFile(randomIntegers, searchResult);
    }
    
    private static void writeToOutputFile(ArrayList<Integer> randomIntegers, String searchResult){
        int lineBreak = 20;
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i < randomIntegers.size() + 1; i++){
            sb.append(randomIntegers.get(i-1)).append("\t");
            //writing to next line, if 20 numbers are written,
            if(i % lineBreak == 0){
                sb.append("\n");
            }
        }

        //finally appending searchResult to file output
        sb.append("\n").append(searchResult).append("\n");

        String outputFileName = "Lab5-output.txt";
        File file = new File(outputFileName);

        try {
            // if file does not exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sb.toString());
            
            bw.close();            
        } catch (IOException e) {
            e.printStackTrace(); 
        } 
    }
    

}
