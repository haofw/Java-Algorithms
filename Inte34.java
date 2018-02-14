package intern;

public class Inte34 {
	public static boolean isWord(String s) {
//		if(s.equals("hat") || s.equals("ht")) {
//			return true;
//		}
		return false;
	}
	public static boolean reduceWord(String s){
		if(s.length() == 1)
			return true;
		if(!isWord(s))
			return false;
		for(int i = 0; i< s.length(); i++) {
			if(reduceWord(s.substring(0,i) + s.substring(i+1)))
				return true;
		}
		return false;
	}
	public static String palindrome(String s){
		StringBuilder sb = new StringBuilder();
		//String ret = "";
		StringBuilder suf = new StringBuilder();
		for(int i = 0; i<= s.length()/2; i++) {
			if(s.charAt(i) == s.charAt(s.length() - i - 1)) {
				if(i == s.length()/2)
					return s;
				sb.append(s.charAt(i));
				suf.append(s.charAt(i)); 
			}
			else {
				StringBuilder temp1 = new StringBuilder(sb);
				temp1.append(s.charAt(s.length() - i - 1));
				temp1.append(palindrome(s.substring(i,s.length() - i - 1)));
				temp1.append(s.charAt(s.length() - i - 1));
				StringBuilder temp2 = new StringBuilder(sb);
				temp2.append(s.charAt(i));
				temp2.append(palindrome(s.substring(i+1,s.length() - i)));
				temp2.append(s.charAt(i));
				sb = (temp1.length() < temp2.length() ? temp1 : temp2);
				sb.append(suf);
				break;
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s = "h";
		System.out.println(palindrome(s));
		String ss = "hat";
		System.out.println(reduceWord(ss));
	}
}
