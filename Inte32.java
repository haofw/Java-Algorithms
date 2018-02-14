package intern;
import java.util.*;
//給一個String 用outbound spiral方式輸出 (ex. abcde -> cdbae
//解法：找中點然後兩個指針左右擴張 -》 比如abcd -》 bacd  b中点然后两边
//3. 給一個String 找出最長的包含k個不同字母的substring
//2. Regular Expression Match
public class Inte32 {
	public static String longSub(String s, int k) {
		int st = 0;
		int en = 1;
		Map<Character,Integer> map = new HashMap<>();
		char[] ch = s.toCharArray();
		String ret = "";
		int count = 1;
		map.put(ch[0],1);
		while(en < s.length()) {
			if(count > k) {
				while(map.get(ch[st]) != 1) {
					map.put(ch[st], map.get(ch[st]) - 1);
					st ++;
				}
				st ++;
				count --;
			}
			if(count == k) {
				String temp = new String(s.substring(st, en));  // string can be changed???
				if(ret.length() < temp.length()) 
					ret = temp;
			}
			if(map.containsKey(ch[en])) {
				map.put(ch[en], map.get(ch[en]) + 1);
				en ++;
			}
			else {
				count ++;
				map.put(ch[en],1);
				en ++;
			}
		}
		if(count == k) {
			String temp = new String(s.substring(st, en));  // string can be changed???
			if(ret.length() < temp.length()) 
				ret = temp;
		}
		return ret;
	}
	public static String spiral(String ori) {
		char[] or = ori.toCharArray();
		int len = or.length;
		int root = len/2;
		StringBuilder sb = new StringBuilder();
		sb.append(or[root]);
		int left = root - 1;
		int right = root + 1;
		int bound = 1;
		int count = 0;
		boolean dirR = true;
		while(left >= 0 && right < len) {
			if(dirR) {
				sb.append(or[right]);
				right ++;
				count ++;
				if(count == bound) {
					dirR = false;
					count = 0;
					bound ++;
				}
			}
			else {
				sb.append(or[left]);
				left --;
				count ++;
				if(count == bound) {
					dirR = true;
					count = 0;
					bound ++;
				}
			}
		}
		while(left >= 0) {
			sb.append(or[left --]);
		}
		while(right < len)
			sb.append(right ++);
		return new String(sb);
	}
	public static void main(String[] args) {
		String s = "abcd";
		System.out.println(spiral(s));
		String ss = "abbaccdddee";
		int k = 3;
		System.out.println(longSub(ss,k));
	}
}
