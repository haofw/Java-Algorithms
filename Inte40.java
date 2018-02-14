package intern;

import java.util.*;

//魂斗罗的作弊码，上上下下左左右右BBAA，
//给一连串输入判断是否调用konami作弊
public class Inte40 {
	static String code;
	static int index = 0;  //why static
	public static boolean read(char c) {
		if(code.charAt(index) == c)
			index ++;
		else
			index =0;
		if(index == code.length())
			return true;
		return false;
	}
	public static void main(String[] args) {
		code = "uuddllrrbbaa";
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			System.out.print(read(sc.next().charAt(0)));
		}
		sc.close();
	}
}
