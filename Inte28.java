package intern;
import java.util.*;
//给一个integer list in ascending order，把每个数都平方，返回排好序的平方数组。例子：[-2, -1, 0, 2]，返回[0, 1, 4, 4]。
public class Inte28 {
	public static List<Integer> square(List<Integer> ori){
		LinkedList<Integer> neg = new LinkedList<Integer>();
		List<Integer> pos = new ArrayList<Integer>();
		for(int i = 0; i< ori.size(); i++) {
			int temp = ori.get(i);
			if(temp<0)
				neg.addFirst(temp*temp);
			else
				pos.add(temp*temp);
		}
		List<Integer> ret = new ArrayList<>();
		int n = 0;
		int p = 0;
		while(n < neg.size() && p < pos.size()) {
			if(neg.get(n) < pos.get(p)) {
				ret.add(neg.get(n));
				n++;
			}
			else {
				ret.add(pos.get(p));
				p++;
			}
		}
		if(neg.size() < pos.size()) {
			for(int i = p; i< pos.size(); i++)
				ret.add(pos.get(i));
		}
		else {
			for(int i = n; i< neg.size(); i++) {
				ret.add(neg.get(i));
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		Integer[] ar = {-2,-1,0,1,2,4};
		List<Integer> ori = Arrays.asList(ar);
		List<Integer> ret = square(ori);
		for(int i = 0; i<ret.size(); i++) {
			System.out.print(ret.get(i)+" ");
		}
	}
}
