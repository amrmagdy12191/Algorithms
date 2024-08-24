package udemy.data.structure.algorithms.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class StreamMax {
	
	public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
        System.out.println("Test case 1:");
        System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
        System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
        System.out.println("Actual output: " + streamMax(nums1));
        System.out.println("Actual output Priority Queue: " + streamMaxPriorityQueue(nums1));
        System.out.println();
    
        // Test case 2
        int[] nums2 = {10, 2, 5, 1, 0, 11, 6};
        System.out.println("Test case 2:");
        System.out.println("Input: [10, 2, 5, 1, 0, 11, 6]");
        System.out.println("Expected output: [10, 10, 10, 10, 10, 11, 11]");
        System.out.println("Actual output: " + streamMax(nums2));
        System.out.println("Actual output Priority Queue: " + streamMaxPriorityQueue(nums2));
        System.out.println();
    
        // Test case 3
        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println("Test case 3:");
        System.out.println("Input: [3, 3, 3, 3, 3]");
        System.out.println("Expected output: [3, 3, 3, 3, 3]");
        System.out.println("Actual output: " + streamMax(nums3));
        System.out.println("Actual output Priority Queue: " + streamMaxPriorityQueue(nums3));
        System.out.println();
        
        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1:
            Input: [1, 5, 2, 9, 3, 6, 8]
            Expected output: [1, 5, 5, 9, 9, 9, 9]
            Actual output: [1, 5, 5, 9, 9, 9, 9]
            
            Test case 2:
            Input: [10, 2, 5, 1, 0, 11, 6]
            Expected output: [10, 10, 10, 10, 10, 11, 11]
            Actual output: [10, 10, 10, 10, 10, 11, 11]
            
            Test case 3:
            Input: [3, 3, 3, 3, 3]
            Expected output: [3, 3, 3, 3, 3]
            Actual output: [3, 3, 3, 3, 3]

        */
        
    }
	
	public static List<Integer> streamMax(int[] nums){
		List<Integer> maxStream = new ArrayList<>();
		
		for(int i=0; i<nums.length; i++) {
			Heap heap = new Heap();
			for(int j=0; j<=i; j++) {
				heap.insert(nums[j]);
			}
			maxStream.add(heap.remove());
		}
		return maxStream;
	}
	
	public static List<Integer> streamMaxPriorityQueue(int[] nums){
		List<Integer> maxStream = new ArrayList<>();
		
		for(int i=0; i<nums.length; i++) {
			PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
			for(int j=0; j<=i; j++) {
				priorityQueue.add(nums[j]);
			}
			maxStream.add(priorityQueue.remove());
		}
		return maxStream;
	}
	
	
	
	

}