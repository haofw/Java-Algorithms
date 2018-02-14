package intern;
import java.util.*;
public class Match {
	//输入“abcdefg”和“acg”，输出true
	public static boolean isMatch(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i< s1.length(); i++) {
			if(!map.containsKey(s1.charAt(i)))
				map.put(s1.charAt(i), i);
		}
		int temp = -1;
		for(int i = 0; i< s2.length(); i++) {
			if(!map.containsKey(s2.charAt(i)))
				return false;
			if(map.get(s2.charAt(i)) < temp)
				return false;
			else {
				temp = map.get(s2.charAt(i));
			}
		}
		int p1 = 0;
		int p2 = 0;
		int count = 0;
		while(p1< s1.length() && p2<s2.length()) {
			if(s1.charAt(p1) != s2.charAt(p2)) {
				p1 ++;
			}
			else {
				p1++;
				p2++;
				count ++;
			}
		}
		return count == s2.length();
	}
	public static void main(String[] args) {
		String s1 = "abcdefg";
		String s2 = "agc";
		System.out.print(isMatch(s1,s2));
	}
	
}
