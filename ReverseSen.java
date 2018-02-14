package interview;
//import java.util.*;
public class ReverseSen {
	public static String reverseWords(String s) {
        s.trim();
        String rev = reverse(s);
        String[] temp = rev.split("\\s+");
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i< temp.length; i++){
            ret.append(reverse(temp[i]));
            ret.append(" ");
        }
        return ret.toString().trim();
        
    }
    public static String reverse(String s){
        char[] ch = s.toCharArray();
        for(int i = 0; i< ch.length/2; i++){
            char temp = ch[i];
        		ch[i] = ch[ch.length - i - 1];
            ch[ch.length - i - 1] = temp;
        }
        return String.valueOf(ch);
    }
    public static void main(String[] args) {
    		String s = " 1";
    		System.out.println(reverse(s));
    		System.out.println(reverseWords(s));
    }
}
