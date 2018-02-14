package intern;
import java.util.*;
public class LetterLocation {
	public static int[] leL(String target, String guess) {
		int[] ret = new int[2];
		char[] ta = target.toCharArray();
		char[] gu = guess.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		int right = 0;
		int in = 0;
		for(int i = 0; i< target.length(); i++) {
			map.put(ta[i],i);
		}
		for(int i = 0; i< ta.length; i++) {
			if(i>= gu.length) {
				break;
			}
			if(ta[i] == gu[i])
				right ++;
			else {
				if(map.containsKey(gu[i]))
					in ++;
			}
		}
		if(ta.length < gu.length) {
			for(int i = ta.length; i< gu.length; i++) {
				if(map.containsKey(gu[i]))
					in ++;
			}
		}
		ret[0] = right;
		ret[1] = in;
		return ret;
	}
	public static void main(String[] args) {
		String tar = "goodmorning";
		String gu = "goodnight";
		System.out.println(leL(tar,gu)[0] + "," + leL(tar,gu)[1]);
		System.out.println((int) 2.7);
	}
}
