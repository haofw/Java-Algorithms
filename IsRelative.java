package intern;
//import java.util.*;
//每个孩子出生，记录其个人和父母信息。输入两个人的名字，判断是否是亲戚
public class IsRelative {
	static class PN{
		int id;
		PN fa;
		PN ma;
		public PN(int id) {
			this.id = id;
			fa = null;
			ma = null;
		}
	}
	public static boolean isRelative(PN p1, PN p2) {
		if(p1 == null || p2 == null)
			return false;
		if(p1.id == p2.id)
			return true;
		return isRelative(p1.fa, p2) || isRelative(p1.ma, p2) || isRelative(p1, p2.fa) || isRelative(p1, p2.ma);
	}
	public static void main(String[] args) {
		PN p1 = new PN(1);
		PN p2 = new PN(2);
		PN f1 = new PN(3);
		PN m1 = new PN(4);
		PN f2 = new PN(5);
		PN m2 = new PN(6);
		PN ff1 = new PN(7);
		p1.fa = f1;
		p1.ma = m1;
		p2.fa = f2;
		p2.ma = m2;
		f1.fa = ff1;
		f2.fa = f1;
		f2.ma = m1;
		System.out.println(isRelative(p1,p2));
	}
}
