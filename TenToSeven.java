package intern;

public class TenToSeven {
	public static String tenSeven(int num) {
		String ret = new String();
		StringBuilder re = new StringBuilder();
		while(num != 0) {
			String temp = String.valueOf(num%7);
			StringBuilder sb = new StringBuilder(temp);
			re = sb.append(re);
			ret = String.valueOf(num%7) + ret;
			num = num/7;
		}
		return new String(re);
	}
	public static int threeTen(String th) {
		int num = 0;
		for(int i = 0; i< th.length(); i++) {
			num = num * 3 + th.charAt(i) - '0';
		}
		return num;
	}
	public static void main(String[] args) {
		int num = 241;
		System.out.println(tenSeven(num));
		String th = "10010";
		System.out.print(threeTen(th));
	}
}