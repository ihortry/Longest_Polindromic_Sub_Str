package leetCode;

import java.util.ArrayList;

public class PolindromicSubStr {

	public static void main(String[] args) {
		String str = "madamnfgs";
		//System.out.println(simplePolindromic(str));
		System.out.println(largestPolindromicSubStr(str));
		
		System.out.println(largestStrWithNoRepetiotions(str));
		  
	}

	private static char[] largestStrWithNoRepetiotions(String str) {
		HashSet<Character>
		return null;
	}

	private static String largestPolindromicSubStr(String str) {
		if(str.equals(new StringBuilder(str).reverse().toString()))
			return str;
		
		int maxLength = 1; 
		String maxStr = str.substring(0,maxLength);
		
		for(int i=0; i<str.length();i++) {
			for(int j = i + maxLength; j <= str.length(); j++) {
				if(j - i > maxLength && simplePolindromic(str.substring(i,j))) {
					maxLength = j-i;
					maxStr = str.substring(i,j);
				}
			}
		}
		return maxStr;
	}

	public static boolean simplePolindromic(String str) {
		int start = 0;
		int end = str.length()-1;
		char[] c = str.toCharArray();
		
		while(start < end) {
			if(c[start] != c[end]) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
