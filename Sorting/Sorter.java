/*
Author: Mr. Guglielmi
Date: 19/03/2024
Description: This class implements a sorting algorithm that can sort integer data in an array which is either provided when the class is instantiated
or using the setter. The sort() method can then be called on the instance to sort the data. 
Generally I prefer to use static methods for sorting, but figured I should provide an example of using an object for this as well.
*/
/**
Sorter implements a sorting algorithm that can sort integer data in an array which is either provided when the class is instantiated
or using the setter. The sort() method can then be called on the instance to sort the data. 
This class provides sorting by both static and object methods.
@author Mr. Guglielmi
@author Tristan Cao
@version 1.0
*/
public class Sorter{
   /** The data that is/is to be sorted */
	private int[] data;
	
	/**
   Empty constructor if we need a sorter but don't yet have the array to be sorted
   */
	Sorter(){
	
	}
	
	/**
   Constructor that is made with the array to be sorted
   @param a  The filled array that is to be sorted
   */
	Sorter (int[] a){
		this.data = a;
	}
	
	/**
   Sorts the data currently in the instance by using a comb sort
   */
	public void sort(){
		int n = this.data.length; //get the length
		
		int gap = n; //start the gap being the size of the array
		
		boolean swapped = true; //flag for if elements have swapped
		
		//while we're not at a gap of 1 and swaps have been made
		while (gap != 1 || swapped){
			
			gap = nextGap(gap); //get the next gap value
			
			swapped = false; //set the swapped flag
			
			for (int i = 0; i < n-gap; i++){ //iterate through the array by the gap size
				if (data[i] > data[i + gap]){ //if the current element is larger than the element 1 gap ahead 
					swap (data, i, i+gap); //swap them
					swapped = true;
				}
			}
		}
		
		
	}
	/**
   A utility method used for calculating the gap size in the comb sort
   @param g  The value of the old gap, used to calculate the size of the new gap
   @return The integer value of the size of the new gap, the size of the gap will always be 1 or greater
   */
	private int nextGap (int g){
		g = (g*10)/13; //calculate the gap shrink factor (1.3)
		if (g < 1){ //if we're below 1, the gap is 1
			return 1;
		}
		else{
			return g;
		}
	}
	
   /**
   Utility method for swapping elements
   @param a  The array in which the swap will happen in
   @param i  The index of the first element to be swaped
   @param j  The index of the second element to be swaped
   */
	private void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
   /**
   Sorts the array with comb sort and times how long (in ms) it takes. Prints time to console
   */
	public void timedSort(){
		Timer t = new Timer();
		t.start(); //start the timer
		sort(); //sort
		int time = t.getTime(); //get the elapsed time
		t.endTimer(); //end the timer
		
		System.out.printf ("The sort time was: %d%n", time);
	}
	
   /**
   Setter method to allow for new data to be sorted
   @param a  The array that the object's data array is being set to
   */
	public void setData(int[] a){
		this.data = a;
	}
	
   /**
   Display the contents of the array in a formatted way. Prints to consol
   */
	public void display(){
		String temp = "";
		for (int i : data){
			temp = temp +  i + " | ";
		}
		
				System.out.println (temp.substring (0, temp.length() - 2)); //trim the trailing |
	}
			
}
	