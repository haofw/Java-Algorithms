package intern;
//第一轮只有一道题：给定若干个区间以及一个数，返回这个数对应的区间序号。
//例如区间为[1,10],[11,20],[21,30]，给了数字15，那么就应该返回1 (对应的是第二个区间[11,20])。
//官之后让设计几个test case测一下，然后发现存在一些问题，后来纠正过来了。
//之后问如果要scale up的话可以怎么做，我就说可以用多线程，然后把代码改了一下。
//后面问了要怎么处理corner cases。
//最后问还可以如何改进我写的代码，我没太明白他说的改进是什么意思，就问他加注释、统一代码风格这些算不算，然后他说可以
//第二轮有两道题：第一题是给一个int，返回它的二进制的最高位1的Index。比如，对于int 4,二进制是100，最高位1的index就是2；
//对于int 1，二进制是1，最高位的index是0；对于0，返回-1；对于负数，因为最高位都是符号位，所以返回1。
//第二题是lc 652 find duplicate subtrees。写完之后问了一下时间、空间复杂度。
import java.util.*;
public class Inte31 {
	public static int getIndex(int num) {
		if(num < 0)
			return 31;
//		if(num == 0)
//			return -1;
		int t = num;
		int ret = -1;
		while(t != 0) {
			t = t/2;
			ret++;
		}
		
		return ret;
	}
	public static int findInterval(List<int[]> intervals, int target) {
		Collections.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[0] - i2[0];
			}
		});
		int start = 0;
		int end = intervals.size() - 1;
		while(start < end) {
			int mid = (start + end) /2;
			if(intervals.get(mid)[0] <= target && intervals.get(mid)[1] >= target)
				return mid;
			if(intervals.get(mid)[0] > target)
				end = mid;
			else
				start = mid + 1;
		}
		if(intervals.get(start)[0] <= target && intervals.get(start)[1] >= target)
			return start;
		return -1;
	}
	public static void main(String[] args) {
		int[][] inp = {{1,2},{4,4},{6,7},{8,10}, {13,15}};
		List<int[]> intervals = Arrays.asList(inp);
		int target = 7;
		System.out.println(findInterval(intervals,target));
		System.out.println(getIndex(4));
	}
}
