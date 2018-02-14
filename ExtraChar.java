package intern;
import java.util.*;
//输入是两个string s1 和 s2，之间就差一个extra character，要求输出这个extra char，地里原题，利用XOR就能做了。.鏈枃鍘int3acres璁哄潧
//2）follow up是shuffle其中一个string，但是已经是用XOR了，所以这个题目就直接pass了
//3）再follow up就是说数据量太大怎么办，答MapReduce，又问bottleneck在哪儿，思考了一下说是如果只有一个reducer的话那个reducer就是bottleneck，解决方法就是multi-layer mapreduce.
public class ExtraChar {
	public static char extraC(String s1, String s2) {
		int len = Math.min(s1.length(), s2.length());
		for(int i = 0; i< len; i++) {
			if(s1.charAt(i) != s2.charAt(i))
				return s1.length() > s2.length() ? s1.charAt(i): s2.charAt(i);
		}
		return s1.length() > s2.length() ? s1.charAt(s1.length() -1): s2.charAt(s2.length() - 1);
	}
	public static char extraC1(String s1, String s2) {
		//using xor
		int ret = 0;
		for(int i = 0 ;i< s1.length(); i++)
			ret = ret ^ s1.charAt(i);
		for(int i = 0; i< s2.length(); i++)
			ret = ret^ s2.charAt(i);
		return (char)ret;
	}
	public static char extraC2(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i< s1.length();i++) {
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
		}
		for(int i = 0; i< s2.length(); i++) {
			if(!map.containsKey(s2.charAt(i)))
				return s2.charAt(i);
			map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
		}
		for(char c : map.keySet()) {
			if(map.get(c) != 0)
				return c;
		}
		return ' ';
	}
	public static void main(String[] args) {
		String s1 = "aabbbbc";
		String s2 = "aabbbbcb";
		System.out.println(extraC(s1,s2));
		System.out.println(extraC1(s1,s2));
		System.out.println(extraC2(s1,s2));
	}
}
