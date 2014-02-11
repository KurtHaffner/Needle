package needle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kurt
 */
public class Needle {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        //Iterate through for every file input in command line.
        for (int i = 0; i < args.length; i++) {

            //Make sure the file is long enough.
            //Then save it in the haystack variable.
            File haystack = null;
            if (0 < args.length) {
                haystack = new File(args[i]);
            } else {
                //Print error if file not put in to command line.
                System.err.println("Invalid arguments count:" + args.length);
                System.exit(0);
            }

            //Set up a scanner for reading through the file.
            Scanner search;
            search = new Scanner(haystack);

            //Variable to hold line number.
            int lineCount = 0;

            //Arraylist to hold every line.
            ArrayList<String> words = new ArrayList<>();

            //Go through the file until you reach the end or find the needle.
            while (search.hasNextLine()) {

                //Make the next line into a string,
                //then convert it to lowercase.
                String line = search.nextLine();
                line = line.toLowerCase();

                //Add the string to an arraylist.
                words.add(line);
            }

            //Set three Strings for searching substings.
            //Also make a boolean for finding "needle".
            String word1;
            String word2;
            String added;
            boolean found;

            //Set an int for the line number of needle.
            int lineNumber;

            //Take each word and the next word, add them together
            //and then see if "needle" is in them.
            for (int j = 0; j < words.size() - 1; j++) {
                //Check first line for needle.
                word1 = words.get(j);
                found = word1.contains("needle");

                //If found print correct output and then exit,
                //since you only need to find first "needle".
                if (found == true) {
                    //Linenumber equal to position plus one,
                    //since arraylist start at 0.
                    lineNumber = j + 1;
                    System.out.println(args[0] + " : " + lineNumber);
                    System.exit(0);
                }

                //Check second line for needle.
                word2 = words.get(j + 1);
                found = word2.contains("needle");

                //If found print correct output and then exit,
                //since you only need to find first "needle".
                if (found == true) {
                    //Linenumber equal to position plus two,
                    //since arraylist start at 0.
                    lineNumber = j + 2;
                    System.out.println(args[0] + " : " + lineNumber);
                    System.exit(0);
                }

                //Check for needle being split between two lines.
                added = word1 + word2;
                found = added.contains("needle");

                //If found print correct output and then exit,
                //since you only need to find first "needle".
                if (found == true) {
                    //Linenumber equal to position plus one,
                    //since arraylist start at 0.
                    lineNumber = j + 1;
                    System.out.println(args[i] + " : " + lineNumber);
                    System.exit(0);
                }
            }
        }
    }
}
