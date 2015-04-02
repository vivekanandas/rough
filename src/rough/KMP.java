package rough;

import java.util.*;
public class KMP {
	private int[] getPMT(String ptrn) {
		int ptrnLen = ptrn.length();
		//partial match table
		int[] PMT = new int[ptrnLen + 1];
		PMT[0] = -1;
		PMT[1] = 0;
		for (int i = 2; i <= ptrnLen; i++) {
			PMT[i] = (ptrn.charAt(i - 1) == ptrn.charAt(PMT[i - 1])) ? (PMT[i - 1] + 1) : 0;
			//System.out.println(i + ": " + PMT[i]);
		}
		return PMT;
		
	    
	   
	}
	public int findKMP(String text, String ptrn) {
		if (text == null || ptrn == null)
			throw new NullPointerException("Null String(s)!");
		int rst = -1;
		if (ptrn.length() == 0) {
			return rst;
		}
		if (text.length() == 0 || text.length() < ptrn.length()) {
				return rst;
		}
		
		int indexT = 0;
		int indexP = 0;
		int ptrnLen = ptrn.length();
		int txtLen = text.length();
		int[] PMT = getPMT(ptrn);
		while (indexT < txtLen) {
			while (indexP >= 0 && text.charAt(indexT) != ptrn.charAt(indexP)) {
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