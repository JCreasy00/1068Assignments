package jawsTranslation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList; // --- https://www.w3schools.com/java/java_arraylist.asp
import java.util.Scanner;
// this lab was 100% easier using regex searches that we learned in 1051 python
import java.util.regex.Matcher; // --- https://www.w3schools.com/java/java_regex.asp
import java.util.regex.Pattern;


public class jaws {
	public static void main(String[] args) throws FileNotFoundException{
		File inFile = new File("./bin/jaws.txt");
		if (!inFile.exists()) {
			System.out.println("File non existent");
			System.exit(1);	// using to avoid error clashes		
		}
		// our rereadFile is made from sending the orig file through the fileReader function 
		String rereadFile = fileToString   (inFile);
		
		// call our translate function
		StringBuilder processedLines = new StringBuilder();
		processedLines.append(translate(rereadFile));
		
		// write to file
        String outFilePath = "./bin/jaws_processed.txt";
        File outFile = new File(outFilePath);
        
        try {
            if (outFile.createNewFile()) {
                FileWriter writer = new FileWriter("./bin/jaws_processed.txt");
                writer.write(processedLines.toString());
            } else {
                System.out.println("File already exists. Printing result instead.\n");
                System.out.println(processedLines.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	// function that takes in a file and returns a String
	// fileReader
	public static String fileToString(File path) throws FileNotFoundException {
		Scanner scan1 = new Scanner(path);
        StringBuilder sb = new StringBuilder();
        //scan1.useDelimiter(".");
        while (scan1.hasNextLine()) {
            String line = scan1.nextLine();
            sb.append(line + "\n"); // append the line as well as start a new one
           }
        scan1.close();
        return sb.toString();
    }
	// we will make the inputs strings so we can can then use
	// charArray again like in lab 5 for instances dealing with 
	// only characters and not whole words like the very/wicked instance
	public static String translate(String s) {
		
		// replace 'very' with 'wicked'...
		Pattern findVery = Pattern.compile("very", Pattern.CASE_INSENSITIVE);
		Matcher fvmatches = findVery.matcher(s);
		// boolean matchFound = matcher.find();
		while (fvmatches.find()) {
			s.replaceAll("very","wicked"); // still a ArrayList so can use replaceAll
		}
		
		// replace 'r' with 'h'
		Pattern replaceR = Pattern.compile("[a,e,i,o,u]r",Pattern.CASE_INSENSITIVE);
		Matcher rRMatches = replaceR.matcher(s);
		// while 'there is a match found' is true...
		while (rRMatches.find()) {
			// cant use .replaceAll() to sub out part of the regex pattern
			// we only want the r to be switched with an h but we start
			// doing that by detecting the first vowel of the pattern
			// then accessing the r by doing using the first vowel ++
			// as the index
			int startPos = rRMatches.start();
			char [] curArray = s.toCharArray();
			// we can now access array[start + 1] which is the r, and replace it
			curArray[startPos + 1] = 'h';
			//turn the array back into a string when done
			s = new String(curArray); // new to get rid of underfined for type error
		}
		
		// replace 'eer' with 'eeyah'
		Pattern replaceEER = Pattern.compile("e{2}r\\b", Pattern.CASE_INSENSITIVE); // /b allows us to search only the edges of words skipping things like 'deerwood'
		Matcher EERmatches = replaceEER.matcher(s);
		while (EERmatches.find()) {
			int endOfPat = EERmatches.end(); // want to start with the end this time
			StringBuilder sb = new StringBuilder();
			// for each char in the string if its equal to endOfPat-1 (after the second e before the r)
			for (int i = 0; i < s.length(); i ++) {// range is the length of the string
				if (i == endOfPat - 1 ) { // if i is equal to where the r is in the pattern
					sb.append("yah"); // append yah where the r would be in eer
				} else {
					sb.append(s.charAt(i));
				}
			}
			s = sb.toString();
		}
		
		// replace 'ir' with 'iyah'
		Pattern replaceIR = Pattern.compile("ir//b", Pattern.CASE_INSENSITIVE);
		Matcher IRmatches = replaceIR.matcher(s);
		while (IRmatches.find()) {
			int endOfPat = IRmatches.end();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				if (i == endOfPat - 1) {
					sb.append("iyah");
				} else {
					sb.append(s.charAt(i));
				}
			}
			s = sb.toString();
		}
		
		// replace 'oor' with 'oowah'
		Pattern replaceOOR = Pattern.compile("o{2}r//b", Pattern.CASE_INSENSITIVE);
		Matcher OORmatches = replaceOOR.matcher(s);
		while (OORmatches.find()) {
			int endOfPat = OORmatches.end();
			StringBuilder sb = new StringBuilder(); 
			for (int i = 0; i < s.length(); i++) {
				if (i == endOfPat - 1) {
					sb.append("wah");
				} else {
					sb.append(s.charAt(i)); 
				}
			}
			s = sb.toString();
		}
		
		// second h satisfaction
//		Pattern replaceR2 = Pattern.compile("[a,e,i,o,u]r", Pattern.CASE_INSENSITIVE);
//        Matcher Rmatches = replaceR2.matcher(s);
//        while (Rmatches.find()) {
//            int beginOfPat = Rmatches.start();
//            char[] array = s.toCharArray();
//            array[beginOfPat + 1] = 'h';
//            s = new String(array);
//        }
        
        // 'a' at the end of a word gets an 'r'
        Pattern AatEnd = Pattern.compile("[a-z]a\\b", Pattern.CASE_INSENSITIVE);
        Matcher Amatches = AatEnd.matcher(s);
        while (Amatches.find()) {
        	int beginPat = Amatches.start();
        	int endPat = Amatches.end();
        	s = Amatches.replaceAll(s.substring(beginPat, endPat - 1) + "ar");
        }
        return s;
	}
}

