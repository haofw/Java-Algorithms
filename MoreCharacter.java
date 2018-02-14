package intern;

public class MoreCharacter {
	public static char moreChar(String s1, String s2) {
		int[] ret = new int[26];
		for(int i = 0; i< s1.length(); i++) {
			ret[s1.charAt(i) - 'a'] ++;
		}
		for(int i = 0; i< s2.length(); i++) {
			if(-- ret[s2.charAt(i) - 'a'] < 0)
				return s2.charAt(i);
		}
		
		return ' ';
	}
	public static void main(String[] args) {
		String s1 = "aabc";
		String s2 = "aabac";
		System.out.print(moreChar(s1, s2));
	}
}
