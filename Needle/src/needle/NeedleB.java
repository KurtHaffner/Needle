/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package needle;

//Imports needed to do stuff.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author kurt
 */
public class NeedleB {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //Make sure the file is long enough.
        //Then save it in the haystack variable.
        File haystack = null;
        if (0 < args.length) {
            haystack = new File(args[0]);
        } else {
            //Print error if file not put in to command line.
            System.err.println("Invalid arguments count:" + args.length);
            System.exit(0);
        }

        //Set up a scanner and put the file into it.
        Scanner copy;
        copy = new Scanner(haystack);
        
        //Make a string for storing the file contents.
        String test = null;

        //Step through each line of the file and add it to copy.
        while (copy.hasNextLine()) {

            test = copy.nextLine();
        }

        //Make a new string and fill it with the bytes from the file,
        //which you first put into a BigInteger, then use
        //.toString() to get the string value of the BigInteger.
        String bits = new BigInteger(test.getBytes()).toString(2);

        //Use this if statement to fix missing bit in the string.
        if (bits.length() % 8 != 0) {

            bits = "0" + bits;
        }

        //Make a null substring to be used soon, along with a count variable.
        String subString = null;
        int count = 0;
        
        //Step through the bits in blocks of 8, thus forming two characters.
        for (int i = 0; i < bits.length() - 8; i++) {
            //Substring used to hold 8 bits.
            subString = bits.substring(i, i + 15);

            //Check to see if the 8 bits hold all 0's.
            if (subString.contains("00000000") == true) {
                //If true, use the count variable to set the first
                //and second character that form the needle.
                char ans1 = test.charAt(count);
                char ans2 = test.charAt(count + 1);
                //Print out which letters form the needle.
                System.out.println("The letters for the needle are: " + ans1
                        + ", " + ans2);
                //Exit after printing.
                System.exit(0);
            } 
            //If those characters did not contain the needle,
            //up i by 7, thus making it equal to the next character.
            else {
                i = i + 7;
            }
            //Increase the count by one so that it is equal to the 
            //starting character.
            count++;
        }

    }

}
