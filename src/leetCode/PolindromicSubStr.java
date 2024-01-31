package leetCode;

import java.util.ArrayList;
import java.util.HashSet;

public class PolindromicSubStr {

	public static void main(String[] args) {
		String str = "aadcccd";
		//System.out.println(simplePolindromic(str));
		System.out.println(largestPolindromicSubStr(str));
		
		System.out.println(largestStrWithNoRepetiotions(str));
		  
	}


	private static int largestStrWithNoRepetiotions(String str) {
	
	  
			
		HashSet<Character> c = new HashSet<>();
		int maxLength = 0;
		int left = 0;
		int n = str.length()-1;
		
		for(int right = 0; right <= n; right++) {
			if(!c.contains(str.charAt(right))) {
				c.add(str.charAt(right));
				maxLength = Math.max(maxLength, right-left+1);
			}else {
				while(c.contains(str.charAt(right))) {
					System.out.println("right "+ right);
					System.out.println("1 left "+ left);
					System.out.println("1: "+ c);
					c.remove(str.charAt(left));
					System.out.println("2: "+ c);
					left++;
					System.out.println("2++ left "+ left);
				}
			}
			c.add(str.charAt(right));
		}
		System.out.println(c);
		return maxLength;
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
