package intern;
import java.util.*;
//给一堆区间，比如 [-1.1, 1.0], [-0.5, 3.5], [3.6, 4.0], ...，再给一个点target，比如0.1，要返回所有包含了这个点的区间。
public class ContainIntervals {
	public static List<double[]> containInte(double[][] intervals, double target){
		List<double[]> ret = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<double[]> () {
			public int compare(double[] d1, double[] d2) {
				return (int )(d1[0] - d2[0]);
			}
		});
		for(int i = 0; i< intervals.length; i++) {
			if(target >= intervals[i][0] && target<= intervals[i][1])
				ret.add(new double[] {intervals[i][0], intervals[i][1]});
			else if(target < intervals[i][0])
				break;
		}
		return ret;
	}
	public static void main(String[] args) {
		double[][] inte = new double[][] {{-1.1,1.0},{3.6,4.0},{-0.5,3.5},{0.0, 2}};
		List<double[]> ret = containInte(inte, 0.1);
		for(int i = 0; i< ret.size(); i++) {
			System.out.println(ret.get(i)[0] + "," + ret.get(i)[1]);
		}
	}
}
