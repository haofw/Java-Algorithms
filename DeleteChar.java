package intern;
//1. 字符串 删指定字母
//2. 给定一个单词前缀和一个字典序排序的字典， 找到第一个前缀不符合条件的单词
public class DeleteChar {
	public static String deleteC(String s, Character c) {
//		char[] ss = s.toCharArray();
//		char[] ret = new char[ss.length];
//		int index = 0;
//		for(int i = 0 ; i < s.length(); i++) {
//			if(s.charAt(i) == c)
//				continue;
//			ret[index++] = s.charAt(i);
//		}
//		return String.valueOf(ret);
		char[] ret = s.toCharArray();
		int p1 = 0;
		int p2 = 0;
		while(p2 < ret.length) {
			if(ret[p2] == c) {
				p2 ++;
			}
			else {
				//char temp = ret[p2];
				ret[p1] = ret[p2];
				p1 ++;
				p2 ++;
			}
		}
		return String.valueOf(ret).substring(0,p1);
	}
	public static String word(String[] st,String pre){
//		for(int i = 0; i< st.length; i++) {
//			if(!st[i].startsWith(pre))
//				return st[i];
//		}
		int start = 0;
		int end = st.length - 1;
		while(start < end) {
			int mid = (start + end)/2;
			if(st[mid].startsWith(pre))
				start = mid + 1;
			else
				end = mid;
		}
		
		return st[start];
	}
	public static void main(String[] args) {
		String s = "aaaadaaaaaaddaacca";
		char c = 'a';
		System.out.println(deleteC(s,c));
		String[] st = {"ad","adc","add","ajd", "afew"};
		String pre = "ab";
		System.out.println(word(st, pre));
		boolean a = "abs".startsWith("ab");
		System.out.print(a);
	}
}
