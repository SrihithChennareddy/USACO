package silver;

import java.util.*;

public class DataStructures {

	public static void main(String[] args) {
		int n=10;
		
		// Array
		int[] nums = new int[n];
		// Array contains the square of i
		for(int i=0; i<nums.length; i++) {
			nums[i] = i*i;
		}
		// Print Array
		System.out.println("Square of numbers in Array");
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		
		
		// ArrayList
		ArrayList<Integer> even = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			if(i%2 == 0){
				even.add(i);
			}
		}
		System.out.println("\nEven numbers up to 10 in ArrayList");
		for(int i=0; i<even.size(); i++) {
			System.out.print(even.get(i) + " ");
		}
		
		
		// LinkedList
		LinkedList<String> foods = new LinkedList<String>();
		foods.add("Pizza");
		foods.add("Sandwitch");
		foods.add("Chips");
		foods.remove("Sandwitch");
		System.out.println("\nFoods in a Linked List");
		for(int i=0; i<foods.size(); i++) {
			System.out.print(foods.get(i) + " ");
		}
		
		
		// HashSet - maintains unsorted order
		HashSet<Integer> odds = new HashSet<Integer>();
		for(int i=0; i<n; i++) {
			if(i%2 != 0) {
				odds.add(i);
			}
		}
		System.out.println("\nOdd numbers in HashSet");
		for(Integer i : odds) {
			System.out.print(i + " ");
		}
		
		
		// TreeSet - maintains Sorted order
		TreeSet<Integer> oddsDesc = new TreeSet<Integer>();
		for(int i=n; i>0; i--) {
			if(i%2 != 0) {
				oddsDesc.add(i);
			}
		}
		System.out.println("\nOdd numbers in TreeSet");
		for(Integer i : oddsDesc) {
			System.out.print(i + " ");
		}
		
		
		// HashMap
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "John");
		map.put(2, "Bill");
		map.put(3, "Joe");
		
		map.remove(2);
		System.out.println("\nHashMap Operations");
		System.out.println("Keys");
		for(Integer key: map.keySet()) {
			System.out.print(key + " ");
		}
		System.out.println("\nValues");
		for(String value : map.values()) {
			System.out.print(value + " ");
		}
		System.out.println("\nKey Value Pairs");
		for(Integer key : map.keySet()) {
			System.out.print(key + ":"+ map.get(key) + " ");
		}
		
		
		// Stack
		Stack<Integer> mul = new Stack<>();
		for(int i=0; i<n; i++) {
			mul.push(i*5);
		}	
		System.out.println("\nStack Operations");
		int len = mul.size();
		for(int i=0; i<len; i++) {
			System.out.print(mul.peek() + " ");
			mul.pop();
		}

		
		// Queue
		Queue<Integer> mult = new LinkedList<>();
		for(int i=0; i<n; i++) {
			mult.add(i*5);
		}	
		System.out.println("\nQueue Operations");
		for(int i=0; i<len; i++) {
			System.out.print(mult.remove() + " ");
		}
	}
}
