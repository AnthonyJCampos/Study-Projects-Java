/** @file SumBigInts.java
 * @author Anthony Campos
 * @date 02/27/2020
 * @brief This program reads an input file that contains sequences of integers to
 * be added together.  The program reads them as Strings so that it can
 * process large integers.  Reset the constant MAX_ARRAY_SIZE to allow it to handle
 * larger integers.
 * */

// This program reads an input file that contains sequences of integers to
// be added together.  The program reads them as Strings so that it can
// process large integers.  Reset the constant MAX_DIGITS to allow it to handle
// larger integers.

import java.io.FileNotFoundException;
import java.util.*; // for scanner object
import java.io.*; // for file object

public class SumBigInts {

    public static final int MAX_ARRAY_SIZE = 25;


    public static void main(String[] args) throws FileNotFoundException {

        // get file to read through Scanner object
        Scanner input = new Scanner(new File("sum.txt"));

        // process file to compute
        processFile(input);


    } // end of main

    public static void processFile(Scanner input) {

        int lineCount = 0; // store line count
        while(input.hasNextLine()){

            // takes and stores it in line as a String
            String line = input.nextLine();
            Scanner scanLine = new Scanner(line);
            // process line
            processLine(scanLine);
            lineCount++;

        } // end while

        System.out.print("Total lines = " + lineCount);

    } // end fo processFile

    public static void processLine(Scanner scanLine){

        int[] result = new int[MAX_ARRAY_SIZE];
        Arrays.fill(result, 0);

        // tokenize string Line
        String newLine = "";

        while(scanLine.hasNext()){

            String number = scanLine.next();
            newLine += number;


            if(scanLine.hasNext()){

                newLine += " + ";

            } else {

                newLine += " = ";

            } // end if

            // do math
            addition(result, number);

        } // end while

        // print newLine
        newLine += buildString(result);
        System.out.println(newLine);

    } // end of processLine

    public static void addition(int[] lhsArr, String rhsString){

        int index = MAX_ARRAY_SIZE - 1;
        for(int i = rhsString.length() - 1; i >= 0; i--){

            int sum = lhsArr[index] + Character.getNumericValue(rhsString.charAt(i));

            if(sum < 10){

                lhsArr[index] = sum;

            } else {

                sum -= 10;
                lhsArr[index] = sum;
                // deal with carry over
                carryOver(index - 1, lhsArr);

            } // end if
            index--;

        } // end for

    } // end of addition

    public static void carryOver(int index, int[] arr){

        int carry = 1;
        while(carry != 0 && index < MAX_ARRAY_SIZE){

            int sum = carry + arr[index];
            // check for carry over
            if(sum < 10){

                arr[index] = sum;
                carry = 0;

            } else {

                sum -= 10;
                arr[index] = sum;
                index--;

            } // end if
        } // end while

    } // end of carryOver

    public static String buildString(int[] arr){

        // get first numeric index
        int startIndex = MAX_ARRAY_SIZE - 1;
        for(int i = 0; i < MAX_ARRAY_SIZE; i++){

            if(arr[i] > 0){

                startIndex = i;
                break;

            } // end if

        } // end for

        String result = "";
        for(int i = startIndex; i < MAX_ARRAY_SIZE; i++){

            result  += arr[i];

        } // end for

        return result;

    } // end buildString

} // end of SumBigInts
