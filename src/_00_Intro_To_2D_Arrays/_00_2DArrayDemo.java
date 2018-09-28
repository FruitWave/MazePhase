package _00_Intro_To_2D_Arrays;

import java.util.Map;
import java.util.function.Function;

public class _00_2DArrayDemo {
	
	
	public static void main(String[] args) {
		// A two-dimensional array is simply an array of arrays.
		// The syntax for a two dimensional array is two square brackets [][]
		
		// array2d is an array of an array of ints. Or a 2D array.
		int[][] array2D;
		
		// A 2D array can be initialized with constant values like so:
		int[][] newArray2D = {{1,2,3}, {4, 5, 6}, {7, 8, 9}};
		
		// If the value of the arrays is not known at the time the array
		// is created, you can define the size of the array like this:
		int[][] anotherArray2D = new int[5][5];
		// anotherArray2d is an array of 5 integer arrays, with each  
		// integer array containing 5 integers. 
		
		// Accessing elements of the 2D array works the same as a 1D array
		anotherArray2D[0][1] = 4;
		System.out.println(anotherArray2D[0][1]);
		
		
		// Iterating through a 2D array usually involves 2 for loops like this:
		for(int i = 0; i < newArray2D.length; i++) {
			for(int j = 0; j < newArray2D[i].length; j++) {
				System.out.print(newArray2D[i][j]); //printing the elements
			}
			System.out.println(); //for formatting
		}
	
	}
	
	
}
