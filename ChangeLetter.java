package intern;
//import java.util.*;
public class ChangeLetter {
	public static boolean exchange(String s1, String s2){
		if(s1.length() != s2.length())
			return false;
		if(s1.length() <= 1)
			return false;
//		if(s1.equals(s2)) {
//			int[] times = new int[26];
//			for(int i = 0; i< s1.length(); i++) {
//				times[s1.charAt(i) - 'a'] ++;
//				if(times[s1.charAt(i) - 'a'] > 1)
//					return true;
//			}
////			if(n%2 == 0)
////				return true;
//			return false;
//		}
		int count = 0;
		char[] change = new char[4];
		for(int i = 0; i< s1.length(); i++){
			if(count >2)
				return false;
			if(s1.charAt(i) != s2.charAt(i)){
				change[count ] = s1.charAt(i);
				change[count + 2] = s2.charAt(i);
				count ++;
			}
		}
		if(change[0] == change[3] && change[2] == change[1]) {
			return true;
		}
		return false;
	}
	public static boolean isMeta(String s1, String s2, int n) {
		if(s1.equals(s2) && n >= 0)
			return true;
		if(n <= 0)
			return false;
		if(s1.length() != s2.length())
			return false;
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		char temp = ch1[0];
		// optimize:
		int index = 0;
		for(int i = 0; i< ch1.length; i++) {
			if(ch1[i] != ch2[i]) {
				temp = ch1[i];
				index = i;
				break;
			}
		}
		
		for(int i = index; i<ch1.length; i++ ) {
			if(ch2[i] == temp) {
				ch2[i] = ch2[index];
				ch2[index] = temp;
				if(isMeta(s1.substring(index +1), String.valueOf(ch2).substring(index +1), n - 1))
					return true;
			}
		}
		return false;
	}
	//abcd     acdb    123    312
	public static void main(String[] args) {
		String s1 = "aabb";
		String s2 = "abab";
		int n = 1;
		boolean ret = isMeta(s1,s2,n);
		System.out.print(ret);
	}
	
}
