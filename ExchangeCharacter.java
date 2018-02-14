package intern;
//import java.util.*;
public class ExchangeCharacter {
	public static boolean canSwap(String s1, String s2) {
		if(s1.length() != s2.length())
			return false;
		int len = s1.length();
		int count = 0;
		char[] a = new char[4];
		for(int i = 0; i< len; i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(count >= 4)
					return false;
				a[count ++] = s1.charAt(i);
				a[count ++] = s2.charAt(i);
			}
		}
		if(a[1] == a[2] && a[0] == a[3]) {
			System.out.print(true);
			return true;
		}
		else {
			System.out.print(false);
			return false;
		}
	}
	public static void main(String[] args) {
		String s1 = "goodmorning";
		String s2 = "gogdmornino";
		canSwap(s1,s2);
	}
	
}
