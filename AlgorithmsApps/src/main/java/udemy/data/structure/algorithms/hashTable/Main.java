package udemy.data.structure.algorithms.hashTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws InterruptedException {
        
            // Get the object of DataInputStream
        	int maxLines = 3; // Desired number of lines

      try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
	        String line;
	        int count = 0;
	        while ((line = reader.readLine()) != null && count < maxLines) {
	            System.out.println(line);
	        
	    
            
                if(line.length() >= 2 ){
                        String[] inputs = line.split(" ");
                        int friends = Integer.parseInt(inputs[0]);
                        int pieces = Integer.parseInt(inputs[1]);
                        if(friends < 1 || friends > 10000 || pieces < 1 || pieces > 100000 );
                            System.out.println(checkChocoholateEquality(friends, pieces));
                 } 
             
                count++;
		    }
            
			
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
    
    public static String checkChocoholateEquality(int friends, int pieces){
        if(pieces % friends != 0)
            return "No";
        return "Yes";
    }
	
	/**
	 * Write a function itemInCommon(array1, array2) that takes two arrays as input and returns true if there is at least one common item between the two lists, false otherwise.

Use a HashMap to solve the problem that creates an O(n) time complexity.


	 * @param array1
	 * @param array2
	 * @return
	 */
	 public static boolean itemInCommon(int[] array1,int[] array2){
	        HashMap<Integer, Boolean> tempHashMap = new HashMap();
	        for(int i: array1){
	            tempHashMap.put(i, true);
	        }
	        
	        for(int j: array2) {
	        	if(tempHashMap.get(j) != null) return true;
	        }
	        return false;
	  }
	 
	 public static List<Integer> findDuplicates(int[] nums){
		 HashMap<Integer, Boolean> tempHashMap = new HashMap();  
		 Set<Integer> duplicates = new HashSet();
		 for(int i: nums){
			 if(tempHashMap.get(i) != null)
				 duplicates.add(i);
			 else
	            tempHashMap.put(i, true);
	     }
		 return new ArrayList<>(duplicates);
	 }
	 
	// public String firstNonRepeatingChar(String word){
	//	 char[] chars = word.toCharArray();
		 //for()
	// }

}
