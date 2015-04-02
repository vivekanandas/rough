package rough;

import java.util.LinkedList;

public class KMPLinkedList {
	private int[] getPMT(LinkedList<Character> ptrn) {
		int ptrnLen = ptrn.size();
		//partial match table
		int[] PMT = new int[ptrnLen + 1];
		PMT[0] = -1;
		PMT[1] = 0;
		for (int i = 2; i <= ptrnLen; i++) {
			PMT[i] = (ptrn.get(i - 1) == ptrn.get(PMT[i - 1])) ? (PMT[i - 1] + 1) : 0;
			//System.out.println(i + ": " + PMT[i]);
		}
		return PMT;
		
	    
	   
	}
	public int findKMP(String text, LinkedList<Character> pattern) {
		if (text == null || pattern == null)
			throw new NullPointerException("Null String(s)!");
		int rst = -1;
		if (pattern.size() == 0) {
			return rst;
		}
		if (text.length() == 0 || text.length() < pattern.size()) {
				return rst;
		}
		
		int indexT = 0;
		int indexP = 0;
		int ptrnLen = pattern.size();
		int txtLen = text.length();
		int[] PMT = getPMT(pattern);
		while (indexT < txtLen) {
			while (indexP >= 0 && text.charAt(indexT) != pattern.get(indexP)) {
				indexP = PMT[indexP];
			}
			indexP++;
			indexT++;
			if (indexP == ptrnLen) {
				rst = indexT - ptrnLen;
				indexP = PMT[indexP];
			}
		}
		return rst;
	}
	 
}
