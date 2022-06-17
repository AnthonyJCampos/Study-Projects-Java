/* Anthony Campos, CS 211, Spring 2020
   This is Assignment #6 */

import java.util.*;

public class BogoSort {
   
	public static void main(String[] args) {	   
      
	  //ask the user to input a desired array size of random numbers.
      System.out.println("Enter an Integer to Create an Random Number List of that Size");
      Scanner console = new Scanner(System.in);
      int n = console.nextInt();
      System.out.println("Your Random Array of " + n + " numbers has been created");
      
	  //ask the user if the how many times they would like to gnereate that array & Bogo Sort it
      System.out.println("How many times would you like generate a random array of this size & Bogo Sort it?");
      int runTimes = console.nextInt();
      System.out.println("This will run: " + runTimes + " Times.");
      System.out.println("--------------------");
      
	  //ask the user if they like to do a LazyRun
      //if yes creates a easy data set the user can pull info from to create they excel doc.
      System.out.println("Are you feelin' lazy, You can do a lazyRun");
      System.out.println("This will increase your size by 1 up to 5 times, if so type YES");
      System.out.println("If no type anything");
      String s = console.next();
      
      // check if user entered yes
      if(s.toLowerCase().equals("yes")){
         lazyRun(runTimes, n);   
      } else{
         dataGenertor(runTimes, n); 
      }
	}
   
   //method is suppose to take in the size of array  & how many times
   //The goal of this method is to easily display data to the user & large amounts if request
   //This saves the user time as they can set it run 1+ times instead of doing 1 at a time.
   public static void dataGenertor(int runTimes,int n){
      // loops the numbe of times requested by the User
      for(int i = 1; i <= runTimes; i++){      
         //This block reports the run# and array size to console as well as the array
         System.out.println("run #" + i + " Array Size: " + n);        
         int[] array = randomArray(n); // generates the randomized array based on length n
         System.out.println("Unsorted Array: " + printArray(array) );  
         System.out.println("*******");
         
         long start = System.currentTimeMillis(); // used to track the (ms) that has Elapsed time (ms):
      	bogoSort(array);
         long end = System.currentTimeMillis();
         long timeElapsed = end - start; // calculates the Elapsed time
         //this block reports the results of the bogoSort
         // "The Number of Shuffles:" appears here when printing to console.
         System.out.println("Sorted Array: " + printArray(array));
      	printArray(array);
         System.out.println("*******");
         System.out.println("Elapsed time (ms): " + timeElapsed); // reports the Elapsed time (ms)
         System.out.println("*******");
         System.out.println();    
      }
   }
   
   //Runs 5 additional dateGenertor to provide the user with a greater pool of data.
   //as well as increments the array size by one for each run to build a stronger data set    
   public static void lazyRun(int runTimes,int n){   
      for(int i = 0; i <= 5; i++){     
         dataGenertor(runTimes, n);
         System.out.println("###############");
         n++;
      }
   }
   
   //Generates a random number array with length per input
	public static int[] randomArray(int size){
      Random rd = new Random();      
      int[] array = new int[size];    
      for(int i = 0; i < array.length; i++){
         array[i] = rd.nextInt(100)+1; 
      }	
      return array;         
   }
   
	// Places the elements of a into sorted order.
   public static void bogoSort(int[] a) {
	   long numShuffles = 0; // used to track the amount of shuffles
      while(!isSorted(a)){
         shuffle(a);
         numShuffles++;   
      }
      System.out.println("The Number of Shuffles: " + numShuffles);		
	}
	// Returns true if a's elements are in sorted order.
	public static boolean isSorted(int[] a) {
		for(int i = 0; i < a.length -1; i++){
         if(a[i] > a[i +1]){
            return false;
         }    
      }
      return true;
	}
	// Shuffles an array of ints by randomly swapping each
	// element with an element ahead of it in the array.   
   public static void shuffle(int[] a){
      Random rnd = new Random();
      for(int i = 0; i < a.length; i++){
         int swapPos = rnd.nextInt(a.length);
         int temp = a[i];
         a[i] = a[swapPos];
         a[swapPos] = temp;
      }
   }
	// a ToString type method that will print the array out
	public static String printArray(int[] a){
      String s = "";
      for(int i=0; i < a.length; i++)
		{
			if( i == 0){
            s = s + "[" + a[i] + ", ";
         } else if( i == a.length - 1){
            s = s + a[i] + "]";
         } else {         
            s = s + a[i] + ", ";
         }
		}
      return s; // Format [#,#,#,#] & so on
	}
}//end of BogoSort class





