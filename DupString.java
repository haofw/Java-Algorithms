package intern;
//import java.util.*;
//一共两部分，要找一个string重复子串的字母个数
//比如ABCABCABCABC, 重复子串可以是ABCABC (* 2)也可以是ABC (* 4)
//第一部分是写一个Helper function判断数字i是不是一个符合条件的重复子串个数， 比如上面那个例子6, 3都应该是true 
//第二部分是写一个function找最短的重复子串的字符数，比如上面的例子返回3

public class DupString {
	public static boolean isDup(int num, String s) {
		if(num > s.length() || num == 0 || s.length() % num != 0)
			return false;
		String pattern = s.substring(0, num);
		for(int i = 0; i<= s.length() - num; i = i+ num) {
			if(!s.substring(i, i+ num).equals(pattern))
				return false;
		}
		return true;
	}
	public static int findMin(String s) {
		int ret = -1;
		for(int i = 0; i<= s.length() /2 ; i++) {
			if(isDup(i,s))
				return i;
		}
		return ret;
	}
	public static void main(String[] args) {
		String s = "ABCABCABCABC";
		int num = 3;
		System.out.println(isDup(num,s));
		System.out.println(findMin(s));
	}
	
}
