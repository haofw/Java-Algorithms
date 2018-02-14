package intern;
//一串排好序的只有大写字母的字符串找出其中字母B的个数
public class CharacterB {
	public static int numB(String s) {
		int count = 0;
		char[] ch = s.toCharArray();
		int start = 0;
		int end = ch.length - 1;
		while(start < end) {
			int mid = (start + end)/2;
			if(ch[mid] - 'B'> 0) {
				end = mid;
			}
			else if(ch[mid] - 'B' < 0) {
				start = mid + 1;
			}
			else{
				for(int i = start; i <= end; i++) {
					if(ch[i] == 'B')
						count ++;
				}
				return count;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		String s = "ABFFFFSS";
		System.out.print(numB(s));
	}
}
