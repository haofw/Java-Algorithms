package online_interview;
import java.util.*;
public class Test {
	public static void test(StringBuilder s) {
		//s = s+ "aaa";
		s.append("aaa");
		
	}
	public static List<int[]> test1(int[] a){
		List<int[]> t = new ArrayList<int[]>();
		int[] temp = {a[0], a[1]};
		t.add(temp);
		temp = new int[] {a[1],a[2]};
		t.add(temp);
		return t;
	}
	public static void main(String[] args) {
//		String s = "af";
//		StringBuilder sb = new StringBuilder(s);
//		test(sb);
//		System.out.println(sb);
		int[] a = {1,2,3};
		List<int[] >re = test1(a);
		for(int[] i : re) {
			System.out.println(i[0]);
			System.out.println(i[1]);
		}
	}
}
