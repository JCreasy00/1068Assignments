public class StringPractice {
  /* returns true if c is a punctuation mark or false otherwise
   * 
   * Punctuation mark is defined as:
   * apostrophe '
   * comma ,
   * period .
   * semicolon ;
   * colon :
   * exclamation point !
   * question mark ? 
   * 
   * (You don't have to worry about any others)
   */
  public static boolean isPunct(char c) {
	  if (c == '\'' || c == ',' || c == '.' || c == ';' || c == ':' || c == '!' || c == '?') {
		  return true;
	  } else {
		  return false;
	  }
  }
  
  
  /*
   * returns the number of punctuation marks
   * found in s.
   *
   * call your isPunct( ) method. Do not copy and paste
   * the same logic into this function */
  
  // toCharArray syntax found at: https://www.javatpoint.com/java-string-tochararray
  // super easy to iterate through with int for loop
  public static int numPunct(String s) {
	  int pMarks = 0;
      char[] charList = s.toCharArray();
      for (int i = 0; i < charList.length; i++) {
          if (isPunct(charList[i])) {
              pMarks++;
          }
      }
      return pMarks;
  }
  
  /*
   * returns the number of punctuation marks
   * found in s starting at the given index.
   *
   * call your isPunct( ) method. Do not copy and paste
   * the same logic into this function */
  
  // learned how to avoid IndexOutOfBoundsException error with try catch here... https://www.educative.io/edpresso/what-is-the-arrayindexoutofbounds-exception-in-java and https://www.w3schools.com/java/java_try_catch.asp 
  // can not figure out why this does not work 
  public static int numPunct(String s, int startIndex) {
	  int pMarks = 0;
	  String slicedS;
	  //try to slice the string, catch the IndexOutOfBoundsException and return 0
	  try {
		  slicedS = s.substring(startIndex);
	  } catch (IndexOutOfBoundsException e) {
		  return 0;
	  }
	  char[] charList = slicedS.toCharArray();  
	  for (int i = 0; i < charList.length; i++) {
          if (isPunct(charList[i])) {
              pMarks++;
          }
      }	  
	  return pMarks;
  }

  /*
   * returns the index of the first occurrence
   * of a punctuation mark in s starting
   * from index startPosition or -1 if there are
   * none at index startPosition or later.
   *
   * When implementing this function, call your isPunct( ) method.
   * Do not simply copy and paste the body of isPunct( ) into this method.
   */
  
  // is there a way to use the .indexOf() method here?
  public static int indexOfFirstPunct(String s, int startPosition) {
	 String slicedS;
	 
	 try {
		 slicedS = s.substring(startPosition);
	 } catch (IndexOutOfBoundsException y) {
		 return -1;
	 }
	 char[] charList = slicedS.toCharArray();  
	 for (int i = 0; i < charList.length; i++) {
         if (isPunct(charList[i])) {
             return i + startPosition;
         }
     }
	 return -1;
  }	
	 /*
   * returns the index of the first punctuation mark in s or
   * -1 if s contains no punctuation marks
   *
   * use your solution to indexOfFirstPunct(String s, int startPosition)
   * in this function. Do not repeat the same logic.
   * 
   * Notice that this method has the same name as the
   * previous one, but that it takes a different number of arguments. This is
   * perfectly legal in Java. It's called "method overloading"
   *
   */
  public static int indexOfFirstPunct(String s) {
	  char[] charList = s.toCharArray();  
	  for (int i = 0; i < charList.length; i++) {
	         if (isPunct(charList[i])) {
	             return i;
	         }
	     }
	  return -1;
}

  /*
   * returns the index of the last occurrence of a punctuation
   * mark in s or -1 if s contains no punctuation
   * 
   * When implementing this function, call your isPunct( ) method.
   * Do not simply copy and paste the body of isPunct( ) into this method.
   */
  
  // is there a way to loop backwards with the for (< int x > : <iterating through>)
  // looping backwards faster? https://mkyong.com/java/reverse-loop-versus-forward-loop-in-performance-java/
  // yes because one of the bounds is always zero instead of being defined or 'fetched'
  public static int indexOfLastPunct(String s) { 
	  char[] charList = s.toCharArray();
	  for (int i = charList.length - 1; i >= 0; i--) {
		  if(isPunct(charList[i])) {
			  return i;
		  }
	  }
	  return -1;
  }

  /*
   * returns a new String which is the same as s but with
   * each instance of oldChar replaced with newChar
   */
  // same eaxct body to iterate through just with an if == old char put new char at that location
  // not sure how to use
  public static String substitute(String s, char oldChar, char newChar) {
	  char[] charList = s.toCharArray();
	  for (int i = 0; i < charList.length; i++) {
		  if (charList[i] == oldChar) {
			  charList[i] = newChar;
		  }
	  }
	  return new String(charList);
  }

  /*
   * returns a new String which is the same as s, but
   * with each instance of a punctuation mark replaced
   * with a single space character
   *
   * Use at least one of your other functions in your
   * solution to this.
   *
   */
  public static String substitutePunct(String s) {
	  char[] charList = s.toCharArray();
	  
	  for (int i = 0; i < charList.length; i++) {
		  if (isPunct(charList[i])) {
			  charList[i] = ' ';
		  }
	  }
	  return new String(charList);
  }
  
  /*
   * returns a new String which is the same as s,
   * but with all of the punctuation
   * marks removed.
   *
   * Use at least one of your other functions
   * in your solution to this one.
   * 
   */
  // tried using deleteCharAt initially but could not satisfy Junit
  public static String withoutPunct(String s) {
	  char[] charList = s.toCharArray();
	  StringBuilder sb = new StringBuilder();
	  
	  for (int i = 0; i < charList.length; i++) {
		  if (!isPunct(charList[i])) {
			  sb.append(charList[i]);
		  }
	  }
	  return sb.toString();
  }

  /* returns true if c is found in s or false otherwise */
  public static boolean foundIn(String s, char c) {
   		char[] charList = s.toCharArray();
   		
   		for (int i = 0; i < charList.length; i++) {
   			if (charList[i] == c) {
   				return true;
   			}		
   		}
   		return false;
  }

  /*
   * Returns true of s contains none of the characters
   * found in chars or false otherwise.
   */
  // right off the bat we know we need two for loops
  public static boolean containsNone(String s, String chars) {
	  char[] charList = s.toCharArray();
	  char[] charArray = chars.toCharArray();
	  
	  // for each letter in charList we check if it matches any characters in chars with a second for loop
	  for(int i = 0; i < charList.length; i++) {
		  for (int j = 0; j < charArray.length; j++) {
			  if (charList[i] == charArray[j]) {
				  return false;
			  }
		  }
	  }
	  
	  return true;
  }
  
  /*
   * Returns true of s is comprised of only punctuation or
   * false otherwise
   *
   * Use at least one of your other
   * functions in this one.
   */
  public static boolean onlyPunct(String s) {
	  char[] charList = s.toCharArray();
	  
	  for (int i = 0; i < charList.length; i++) {
		  if (!isPunct(charList[i])) {
			  return false;
		   }
	  }	
	  return true;
  }

  /*
   * Returns true of s contains no punctuation or
   * false otherwise
   *
   * Use at least one of your other
   * functions in this one.
   */
  public static boolean noPunct(String s) {
	  char[] charList = s.toCharArray();
	  
	  for (int i = 0; i < charList.length; i++) {
		  if (isPunct(charList[i])) {
			  return false;
		  }
	  }
	  return true;
  }

  /*
   * returns true if s has two punctuation marks
   * right next to each other or false otherwise
   *
   * use at least one of your other methods
   * in your solution to this method
   */
  // by setting i to 1 instead of 0 and having our count start at 0 we now can increase the count by one everytime
  // the loop is fired, this gives us two different, but adjacent, numbers to test for punctuation marks
  public static boolean consecutivePuncts(String s) {
      char[] charList = s.toCharArray();
      int count = 0;
      
      for (int i = 1; i < charList.length; i++) {
    	  if (isPunct(charList[i]) && isPunct(charList[count])) {
    		  return true;
    	  }
    	  count++;
      }
	  return false;
  } 
}
