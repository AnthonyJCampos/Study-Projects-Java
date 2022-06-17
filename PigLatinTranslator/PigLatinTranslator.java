/** @file PigLatinTranslator.java
 * @author Anthony Campos
 * @date 02/16/2020
 * @brief the project implements a Pig Latin Translator  that prompts the user for the name of a file containing English sentences, one
 * per line, and converts the words to Pig Latin using the given rules,and saves away the
 * translated sentences to a different file.
 *
 * */

//---------------------------------------------------------------------------
// Pig Latin Translation Rules:
//   If the word starts with a vowel, just add ‘way’ to the end of the word. For example,
//      -- 'are' becomes ‘areway’
//      -- 'in' becomes ‘inway’
//  If the word starts with a consonant, move all of the consonants that appear before the
//  first vowel to the end of the word, and then add ‘ay’ to the end of the word. For
//  Example,
//      -- ‘word’ becomes ‘ordway’ (‘ord’ + ‘w’+ ‘ay’)
//      -- ‘student’ becomes ‘udentstay’ (‘udent’ + ‘st’ + ‘ay’)
//      -- ‘road’ becomes ‘oadray’ (‘oad’ + ‘r’ + ‘ay’)
//
//---------------------------------------------------------------------------


// imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util. *;

public class PigLatinTranslator {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner console = new Scanner(System.in);
        // Prompts user to input requested file name without extension.
        System.out.print("Please enter the name of the text file excluding .txt: ");
        String fileName = console.next(); // reads and returns the next token as a string

        File inputFile = new File(fileName + ".txt"); // construct file object
        Scanner input = new Scanner(inputFile); // create scanner object


        // creates a new file titled original-Pl.txt with piglatin text
        PrintStream output = new PrintStream( fileName + "-PL.txt"); // print object to write to file

        pigLatin(input, output);


    } // end of main

    // Method piglatin  accepts two objects as parameters, input file & output file
    // Writes out the input file's text in a simplified version of Pig Latin
    public static void pigLatin(Scanner input, PrintStream output){

        while(input.hasNextLine()){

            // line read
            String line = input.nextLine();
            // convert line to all lower case
            line = line.toLowerCase();
            // create scanner object to can each line
            Scanner lineScan = new Scanner(line);
            // new line to write to file
            StringBuilder newLine = new StringBuilder();

            while(lineScan.hasNext()){

                newLine.append(pigLatinHelper(lineScan.next()));

                if(lineScan.hasNext()){

                    newLine.append(" ");

                } // end if

            } // end while

            output.println(newLine); // write to output file

        } // end while

    } // end of pigLatin

    // Method pigLatinHelper trims of punctuation from the provided text and
    // applies the pig latin rules to the given text
    public static String pigLatinHelper(String text){

        // punctuations check
        int charVal = text.charAt(text.length() - 1);
        if(charVal  < 97 || charVal > 122){

            text = text.substring(0, text.length() - 1);

        } // end if

        // get vowel index
        int index = vowelIndex(text);

        if(index != -1){

            // if not index 0 apply first rule
            if(index != 0){

                text = text.substring(index) + text.substring(0, index) + "ay";

            } else { // else vowel first char

                text += "way";

            } // end if

        } // end if

        return text;

    } // end of pigLatinHelper

    // Method isVowel checks if the char parameter is Vowel and return true or false.
    public static boolean isVowel(char c) {
        // Method isVowel checks if the char parameter is Vowel and return true or false.
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // Method vowelIndex gets the index number of the Vowel located in the string text
    public static int vowelIndex(String text){

        int index = -1;
        boolean found = false;
        for(int i = 0; i < text.length() && !found; i++){

            if(isVowel(text.charAt(i))) {
                index = i;
                found = true;

            } // end if

        } // end for

        return index;

    } // end vowelIndex

} // end of PigLatinTranslator
