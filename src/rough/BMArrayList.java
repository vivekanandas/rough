package rough;

import java.util.ArrayList;

public class BMArrayList {
	
	private final int SIZE = 256;
	private int lastOccurrence[] = new int[SIZE];
	
	private void buildIndex(ArrayList<Character> pattern) {
		
		int length = pattern.size();
		
		for (int i = 0; i < SIZE; i++)
			lastOccurrence[i] = -1;
		
		for (int i = 0; i < length; i++)
			lastOccurrence[pattern.get(i)] = i;
	}
	
	private int findLast(char aChar) {
		
		return lastOccurrence[aChar];
	}
	
	public int findBoyerMoore(String content, ArrayList<Character>  pattern) {
		
		//validate, null or empty string is not allowed
		if (content == null || content.length() == 0)
			return -1;
		
		if (pattern == null || pattern.size() == 0)
			return -1;
		
		// search pattern
		if (content.length() < pattern.size())
			// impossible match
			return -1;

		// build last occurrence index
		buildIndex(pattern);
		
		// searching
		int start = pattern.size() - 1;
		int end = content.length();
		int position, j;
		
		// search from left to right
		while (start < end) {
			
			position = start;
			
			for (j = pattern.size() - 1; j >= 0; j--) {
				
				// if not match a character
				if (pattern.get(j) != content.charAt(position)) {
					
					// check the last occurrence index
					if (findLast(content.charAt(position)) != -1) {
						
						if (j - findLast(content.charAt(position)) > 0)
							// case 1
							start += j - findLast(content.charAt(position));
						else
							// case 2
							start += 1;
						
					} else {
						
						// case 3
						start += j + 1;
					}
					
					break;
				}
				
				if (j == 0) {
					
					// found pattern
					return position;
				}
				
				position--;
			}
		}
		
		// not found
		return -1;
	}
	
}
