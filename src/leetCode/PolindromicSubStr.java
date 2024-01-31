package leetCode;

public class PolindromicSubStr {

	public static void main(String[] args) {
		String str = "baabab";
		System.out.println(simplePolindromic(str));
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
