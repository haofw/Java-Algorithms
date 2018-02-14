package intern;
import java.util.*;
public class Inte27 {
	public static char firstSingle(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i<s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		for(int i = 0; i< s.length(); i++) {
			if(map.get(s.charAt(i)) == 1)
				return s.charAt(i);
		}
		return ' ';
	}
//第一道， merge 两个sorted的数组。第二道，look and say序列 就是 1， 11， 21， 1211， 111221。。。。。每个数都描述了前一个数的构成 两个1这样子，然后问第k个数。
	public static String lookAndSay(int k) {
		if(k < 1)
			return "";
		String[] dp = new String[k+1];
		dp[1] = "1";
		for(int i = 2; i<= k; i++) {
			String temp = dp[i-1];
			StringBuilder sb = new StringBuilder();
			int count = 1;
			//char f = temp.charAt(0);
			for(int j = 1; j< temp.length(); j++) {
				if(temp.charAt(j) == temp.charAt(j-1)) {
					count ++;
				}
				else {
					sb.append(count);
					sb.append(temp.charAt(j-1));
					count = 1;
				}
			}
			sb.append(count);
			sb.append(temp.charAt(temp.length() -1));
			dp[i] = new String (sb);
		}
		return dp[k];
	}
	public static String lookAndSay1(int k) {
		if(k == 1)
			return "1";
		return help("1", k-1);
	}
	public static String help(String s, int remain) {
		if(remain == 0)
			return s;
		char[] ar = s.toCharArray();
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i<s.length(); i++) {
			if(ar[i] == ar[i-1]) {
				count ++;
			}
			else {
				sb.append(count);
				sb.append(ar[i-1]);
				count = 1;
			}
		}
		sb.append(count);
		sb.append(ar[ar.length - 1]);
		return help(new String(sb), remain - 1);
	}
	public static int[] mergeArray(int[] a1, int[] a2) {
		int[] ret = new int[a1.length + a2.length];
		int i = 0;
		int j = 0;
		int index = 0;
		
		while(i<a1.length && j<a2.length) {
			if(a1[i] < a2[j]) {
				ret[index++] = a1[i];
				i++;
			}
			else {
				ret[index++] = a2[j];
				j++;
			}
		}
		if(a1.length > a2.length) {
			for(int t = i; t < a1.length; t++) {
				ret[index ++] = a1[t];
			}
		}
		else {
			for(int t = j; t < a2.length; t++) {
				ret[index ++] = a2[t];
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		String s = "aasdfasfsv";
		System.out.println(firstSingle(s));
		int[] a = {1,2,3,5,7,8};
		int[] b = {3,4,5,6,8,9,10};
		int[] ret = mergeArray(a, b);
		for(int i : ret)
			System.out.print(i + " ");
		System.out.println();
		int k =3;
		System.out.println(lookAndSay(k));
		System.out.println(lookAndSay1(k));
	}
}
