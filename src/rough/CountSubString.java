package rough;

import java.io.*;
import java.util.*;

public class CountSubString {

	/*
	 * Returns the lowest index at which substring pattern begins in text (or
	 * else -1).
	 */
	private static int findBrute(List<Character> text, List<Character> pattern) {
		int n = text.size();
		int m = pattern.size();
		for (int i = 0; i <= n - m; i++) { // try every starting index within
											// text
			int k = 0; // k is index into pattern
			while (k < m && text.get(i + k) == pattern.get(k))
				// kth character of pattern matches
				k++;
			if (k == m) // if we reach the end of the pattern,
				return i; // substring text[i..i+m-1] is a match
		}
		return -1; // search failed
	}
	public static int readAndMatchDocument(String filename,
			List<Character> pattern, List<Character> Input)
			throws FileNotFoundException {
		StringTokenizer tokens;
		String line, textword;
		int count = 0;
		// open file anew to ensure we start at the first character
		BufferedReader inFileReader = new BufferedReader(new FileReader(
				filename));

		try {
			while (true) {
				line = inFileReader.readLine();
				if (line == null)
					break;
				tokens = new StringTokenizer(line);
				// for all the words in the line
				while (tokens.hasMoreTokens()) {
					textword = tokens.nextToken();
					convertStringToList(textword, Input);
					if (findBrute(Input, pattern) != -1)
						count = count + 1;
				} // end while tokens
			} // end while true
		} catch (IOException e) {
			System.out.println(e);
		} // catch I/O exception}
		try {
			inFileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	/*
	 * Repeatedly prompt user for filename until a file with such a name exists
	 * and can be opened.
	 */

	private static String openFile() {

		BufferedReader keyboardReader = new BufferedReader(
				new InputStreamReader(System.in));

		String inFilePath = "";
		BufferedReader inFileReader;
		boolean pathsOK = false;

		while (!pathsOK) {
			try {
				System.out.print("Please enter the path for the input file: ");
				inFilePath = keyboardReader.readLine();
				inFileReader = new BufferedReader(new FileReader(inFilePath));
				pathsOK = true;
				inFileReader.close();
			} // try
			catch (IOException e) {
				System.out.println(e);
			} // catch I/O exception
		} // while
		return inFilePath;
	} // method openFiles

	/*
	 * Helper method to convert a string to a List. Loops over all characters in
	 * the string and may not be all that efficient - may be better to read in
	 * the file character by character until we hit whitespace.
	 */

	private static void convertStringToList(String in, List<Character> out) {
		char[] input_chars = in.toCharArray();
		out.clear();
		for (int i = 0; i < input_chars.length; i++) {
			out.add(input_chars[i]);
		}
	}

	/*
	 * Iterate over all strings in input file to determine whether the input
	 * string is a substring in any of these strings. Returns the number of
	 * times such a match exists.
	 */

	public static int findByBoyerMoore(String filename,
			String pattern)
			throws FileNotFoundException {
		StringTokenizer tokens;
		String line, textword;
		int count = 0;
		// open file anew to ensure we start at the first character
		BufferedReader inFileReader = new BufferedReader(new FileReader(
				filename));
		BM bm = new BM();
		try {
			while (true) {
				line = inFileReader.readLine();
				if (line == null)
					break;
				tokens = new StringTokenizer(line);
				// for all the words in the line
				while (tokens.hasMoreTokens()) {
					textword = tokens.nextToken();
					//convertStringToList(textword, Input);
					if (bm.findBoyerMoore(textword, pattern) != -1)
						count = count + 1;
				} // end while tokens
			} // end while true
		} catch (IOException e) {
			System.out.println(e);
		} // catch I/O exception}
		try {
			inFileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public static int findByBoyerMooreAL(String filename,
			ArrayList<Character> pattern)
			throws FileNotFoundException {
		StringTokenizer tokens;
		String line, textword;
		int count = 0;
		// open file anew to ensure we start at the first character
		BufferedReader inFileReader = new BufferedReader(new FileReader(
				filename));
		BMArrayList bm = new BMArrayList();
		try {
			while (true) {
				line = inFileReader.readLine();
				if (line == null)
					break;
				tokens = new StringTokenizer(line);
				// for all the words in the line
				while (tokens.hasMoreTokens()) {
					textword = tokens.nextToken();
					//convertStringToList(textword, Input);
					if (bm.findBoyerMoore(textword, pattern) != -1)
						count = count + 1;
				} // end while tokens
			} // end while true
		} catch (IOException e) {
			System.out.println(e);
		} // catch I/O exception}
		try {
			inFileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public static int findByBoyerMooreLL(String filename,
			LinkedList<Character> pattern)
			throws FileNotFoundException {
		StringTokenizer tokens;
		String line, textword;
		int count = 0;
		// open file anew to ensure we start at the first character
		BufferedReader inFileReader = new BufferedReader(new FileReader(
				filename));
		BMLinkedLists bm = new BMLinkedLists();
		try {
			while (true) {
				line = inFileReader.readLine();
				if (line == null)
					break;
				tokens = new StringTokenizer(line);
				// for all the words in the line
				while (tokens.hasMoreTokens()) {
					textword = tokens.nextToken();
					//convertStringToList(textword, Input);
					if (bm.findBoyerMoore(textword, pattern) != -1)
						count = count + 1;
				} // end while tokens
			} // end while true
		} catch (IOException e) {
			System.out.println(e);
		} // catch I/O exception}
		try {
			inFileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public static int findByKnuthMorrisPrattAL(String filename,
			ArrayList<Character> pattern)
			throws FileNotFoundException {
		StringTokenizer tokens;
		String line, textword;
		int count = 0;
		// open file anew to ensure we start at the first character
		BufferedReader inFileReader = new BufferedReader(new FileReader(
				filename));
		KMPArrayList kmp = new KMPArrayList();
		try {
			while (true) {
				line = inFileReader.readLine();
				if (line == null)
					break;
				tokens = new StringTokenizer(line);
				// for all the words in the line
				while (tokens.hasMoreTokens()) {
					textword = tokens.nextToken();
					//convertStringToList(textword, Input);
					if (kmp.findKMP(textword, pattern) != -1)
						count = count + 1;
				} // end while tokens
			} // end while true
		} catch (IOException e) {
			System.out.println(e);
		} // catch I/O exception}
		try {
			inFileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public static int findByKnuthMorrisPrattLL(String filename,
			LinkedList<Character> pattern)
			throws FileNotFoundException {
		StringTokenizer tokens;
		String line, textword;
		int count = 0;
		// open file anew to ensure we start at the first character
		BufferedReader inFileReader = new BufferedReader(new FileReader(
				filename));
		KMPLinkedList kmp = new KMPLinkedList();
		try {
			while (true) {
				line = inFileReader.readLine();
				if (line == null)
					break;
				tokens = new StringTokenizer(line);
				// for all the words in the line
				while (tokens.hasMoreTokens()) {
					textword = tokens.nextToken();
					//convertStringToList(textword, Input);
					if (kmp.findKMP(textword, pattern) != -1)
						count = count + 1;
				} // end while tokens
			} // end while true
		} catch (IOException e) {
			System.out.println(e);
		} // catch I/O exception}
		try {
			inFileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public static void main(String[] args) {
		BufferedReader keyboardReader = new BufferedReader(
				new InputStreamReader(System.in));

		ArrayList<Character> pattern1 = new ArrayList<Character>();
		LinkedList<Character> pattern2 = new LinkedList<Character>();

		ArrayList<Character> input_string1 = new ArrayList<Character>();
		LinkedList<Character> input_string2 = new LinkedList<Character>();

		String file_name = openFile();
		String pattern = new String();

		// read in substring pattern, catching any exceptions
		try {
			while (true) {
				System.out.print("Enter the pattern to look for: ");
				pattern = keyboardReader.readLine();
				break;
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		convertStringToList(pattern, pattern1);
		convertStringToList(pattern, pattern2);

		// finally run the program and measure execution time
		try {
			double startTime = System.currentTimeMillis();
			
			int final_count1 = readAndMatchDocument(file_name, pattern1,input_string1);
			double middleTime1 = System.currentTimeMillis();
			
			int final_count2 = readAndMatchDocument(file_name, pattern2,input_string2);
			double middleTime2 = System.currentTimeMillis();
			
			int final_count3 = findByBoyerMooreAL(file_name, pattern1);
			double middleTime3 = System.currentTimeMillis();

			int final_count4 = findByBoyerMooreLL(file_name, pattern2);
			double middleTime4 = System.currentTimeMillis();
			
			int final_count5 = findByKnuthMorrisPrattAL(file_name, pattern1);
			double middleTime5 = System.currentTimeMillis();
			
			int final_count6 = findByKnuthMorrisPrattLL(file_name, pattern2);
			double middleTime6 = System.currentTimeMillis();
			
			double endTime = System.currentTimeMillis();
			
			System.out.println("Using Brute AL(: " + final_count1 + " matches, derived in "
					+ (middleTime1 - startTime) + " milliseconds.");
			System.out.println("Using Brute LL: " + final_count2 + " matches, derived in "
					+ (middleTime2 - middleTime1) + " milliseconds.");
			System.out.println("Using BoyerMooreAL: " + final_count3 + " matches, derived in "
					+ (middleTime3 - middleTime2) + " milliseconds.");
			System.out.println("Using BoyerMooreLL: " + final_count4 + " matches, derived in "
					+ (middleTime4 - middleTime3) + " milliseconds.");
			System.out.println("Using findByKnuthMorrisPrattAL: " + final_count5 + " matches, derived in "
					+ (middleTime5 - middleTime4) + " milliseconds.");
			System.out.println("Using findByKnuthMorrisPrattLL:: " + final_count6 + " matches, derived in "
					+ (endTime - middleTime5) + " milliseconds.");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
