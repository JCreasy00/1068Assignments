package arraypractice;

import java.util.ArrayList;

public class ArrayPractice {
  /* sets every item in A[] to initialValue */
  public static void initialize(int A[], int initialValue) {
	  for (int i = 0; i < A.length; i++) {
		  A[i] = initialValue;
	  }
	  return;
  }

  
  /* returns the average of the items in A
   * Be careful: A[] is an array of int and the method returns
   * double. What do we do to handle this? */
  public static double average(int A[]) {
  // for each number in our list we add it to count
  // finally, we return the count / the length of A
	  double count = 0;
	  for (int number : A) {
		  count = count + (double) number;
	  }
	  return count / A.length;
  }

  
  /* returns the number of times that x appears in A[] */
  public static int numOccurrences(int A[], int x) {
  // for each number in our list of numbers check
  // if the number is equal to x, if it is increase the count
  // finally return the count which is the amount of 'x''s
	  int count = 0;
	  for (int number : A) {
		  if (number == x) {
			  count++;
		  }
	  }
	  return count;
  }


  /* returns the index of the first occurrence of
   * x in A[] or -1 if x doesn't exist in A[] */
  public static int find(int A[], int x) {
	  int index = 0;
	  for (int i = 0; i < A.length; i++) {
		  if (A[i] == x) {
			  index = i;
			  return index;
		  }
	  }
	  return -1;
  }

  
  /* Returns the index of the first occurrence of
   * item within the first n elements of A[] or -1
   * if item is not among the first n elements of A[] */
  public static int findN(int A[], int item, int n) {
  // use a for loop to begin looping through a by index
  // if A[i} == item AND i < n meaning its among the first n
  // then return that number.
	  for (int i = 0; i < A.length; i++) {
		  if (A[i] == item && i < n) {
			  return i;
		  }
	  }
	  return -1;
  }

  
  /* returns the index of the last occurrence of
   * x in A[] or -1 if x doesn't exist in A[] */
  public static int findLast(int A[], int x) {
  // this can be done the same way as the previous problem but we
  // will just iterate over the array backwards by starting
  // with the length of the array as the first index and 0 as the last with a step of i-- not i++
	  for (int i = A.length - 1; i > 0; i--) {
		  if (A[i] == x) {
		        return i;
		  }
	  }
	  return -1;
  }

  
  /* returns the largest item found in A */
  public static int largest(int A[]) {
	  int largestItem = 0;
	  for (int number : A) {
		  if (number > largestItem) {
			  largestItem = number;
		  }
	  }
	  return largestItem;
  }

  
  /* returns the index of the largest item found in A */
  public static int indexOfLargest(int A[]) {
	  int currentLarge = largest(A);
	  int index = 0; 
	  for (int i = 0; i < A.length; i++) {
		  if (A[i] == currentLarge) {
			  index = i;
		  }
	  }
	  return index;
  }

  
  /* returns the index of the largest odd number
   * in A[] or -1 if A[] contains no odd numbers */
  public static int indexOfLargestOdd(int A[]) {
	  int currentLargest = 0;
	  
	  for (int n : A) {
	      if (n > currentLargest && n % 2 == 1) {
	        currentLargest = n;
	      }
	  }
//	  for (int i = 0; i < A.length; i++) {
//		  if (A[i] == currentLargest) {
//			  index = i;
//		  }
//	  }
	  // returns the index of the second parameter from the list passed in the first parameter
	  return find(A, currentLargest);
}
// https://www.geeksforgeeks.org/system-arraycopy-in-java/
// System.arraycopy(array to copy from, index to start from in first array,
// third is the destination array, the fourth is the index to start copying to the destination array
// last is how many elements to copy to the destination array 
  
  
  /* inserts n into A[] at A[index] shifting all */
  /*  the previous items one place to the right. For example */
  /*  if A is  */
  /*   |---+---+---+---+---+---+---+---+---+---| */
  /*   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
  /*   |---+---+---+---+---+---+---+---+---+---| */
  /*   | 5 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | 0 | */
  /*   |---+---+---+---+---+---+---+---+---+---| */

  /*   and we call insert(A, 15, 1), A then becomes */

  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*   | 0 |  1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | */
  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*   | 5 | 15 | 7 | 6 | 9 | 4 | 3 | 0 | 0 | 0 | */
  /*   |---+----+---+---+---+---+---+---+---+---| */
  /*  the element in A[] that's in the right-most */
  /*    position is removed.                      */
  /*                                              */
  /*  if index < 0 or index >= A.length-1, the method */
  /*                                    does nothing */
  public static void insert(int A[], int n, int index) {
	  // allocating memory and declaring array in same line
	  int[] current = new int[A.length];
	  // we copy 'A' from index 0 to 'current'at index 0 up until index
	  // meaning everything index of the number that we want to replace is copied
	  System.arraycopy(A, 0, current, 0, index);
	  // here we copy everything from after the index
	  // from array A copy at index index copy to current at index + 1, the amount of elements is total
	  // elements minus the index (already copied) - 1
	  System.arraycopy(A, index, current, index + 1, A.length - index - 1);
	  //insert our n at index
	  current[index] = n;
	  // a loop to rebuild the string in A
	  for (int i = 0; i < A.length; i++) {
		  A[i] = current[i] ;
	  }
	  return;
  }
  
  /* returns a new array consisting of all of the
   * elements of A[] */
  public static int[] copy(int A[]) {
	  int[] newArray = new int[A.length]; // array with memory
	  // copy entire array A to newArray
	  System.arraycopy(A, 0, newArray, 0, A.length);
	  return newArray;
	  }

  
  /* Returns a new array consisting of all of the
     first n elements of A[]. If n>A.length, returns a
     new array of size n, with the first A.length elements
     exactly the same as A, and the remaining n-A.length elements
     set to 0. If n<=0, returns null. */
  public static int[] copyN(int A[], int n) {
	  // check if n <= 0
	  if (n <= 0) { 
		  return null; 
	  }
	  int[] newArray = new int[n];
	  // for i in range n
	  for (int i = 0; i < n; i++) {
		  // check if i is less than the length of A
		  // if i > A.length than a zero needs to be added
		  // this also means that n was larger than the length of the number
		  if (i < A.length) {
			  newArray[i] = A[i];
		  } else {
			  newArray[i] = 0;
		  }
	  }
	  return newArray;
  }

  
  /* returns a new array consisting of all of the
   * elements of A[] followed by all of the
   * elements of B[]. For example, if 
   A[] is: {10,20,30} and 
   B[] is: {5, 9, 38}, the method returns the
   array : {10,20,30,5,9,38} */
  public static int[] copyAll(int A[], int B[]) {
	  // our new array will be the length of arrays A and B combined
	  int[] newArray = new int[A.length + B.length];
	  // add array B to newArray
	  System.arraycopy(A, 0, newArray, 0, A.length);
	  // starting at the end of array A add array B
	  System.arraycopy(B, 0, newArray, A.length, B.length);
	  
	  return newArray;
  }

 
/* reverses the order of the elements in A[].
   * For example, if A[] is:
   {10,20,30,40,50}, after the method, A[] would
   be {50,40,30,20,10} */
  public static void reverse(int A[]) {
// swap A[i] with A[A.length - i - 1] in a for loop will give us a reversed string
	  			
	  		// first try \\
//	  int[] newArray = new int[A.length];
//	  int length = A.length;
//	  for (int i = 0; i < A.length; i++) {
//		  newArray[length - 1] = A[i];
//		  length = length - 1;
//	  }
//	  return;
	  
	  int holder = 0;
	  for (int i = 0; i<A.length / 2; i++) {
		  // our holder becomes A[i]
		  holder = A[i];
		  // A[i] gets set to the elements of set A at the length - i - 1
		  // this leads us to the elements at the end of our array
		  A[i] = A[A.length - i - 1];
		  // then A[i] gets set to what AA[A.length - i - 1] was
		  // so they are basically swapped becasuew we not make that ending elements equal to A[i]
		  A[A.length - i - 1] = holder;
	  }
	  return;
  }

  
  /* Extra credit:
   *
   * Returns a new array consisting of all of the
   * elements of A, but with no duplicates. For example,
   * if A[] is {10,20,5,32,5,10,9,32,8}, the method returns
   * the array {10,20,5,32,9,8} */
  public static int[] uniques(int A[]) {
    return null;
  }

  
  
  public static void main(String[] args) {
    return;
  }
}
