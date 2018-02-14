package intern;
import java.util.*;
public class LongIncreasePath {
	//最长连续递增子序列的长度    16
	public static int longSeqP(int[] num) {
		if(num == null || num.length == 0)
			return 0;
		int max = 1;
		int temp = 1;
		for(int i = 1; i< num.length; i++) {
			if(num[i] > num[i-1]) {
				temp ++;
			}
			else {
				max = Math.max(max, temp);
				temp = 1;
			}
		}
		max = Math.max(max, temp);
		return max;
	}
	
	
	public static List<Integer> path(int[][] ma) {
		//int ret = 0;
		int m = ma.length;
		int n = ma[0].length;
		//int[][] dp = new int[m][n];
		@SuppressWarnings("unchecked")  //????
		List<Integer>[][] dp = new List [m][n];
		for(int i = 0; i< m; i++) {
			for(int j = 0 ; j< n; j++) {
				dp[i][j] = new ArrayList<Integer>();
			}
		}
//		int[] index = new int[2];
//		index[0] = -1;
//		index[1] = -1;
		List<Integer> li = new ArrayList<>();
		for(int i = 0; i< m; i++) {
			for(int j = 0; j< n; j++) {
				List<Integer> temp = findP(i,j,ma, dp,ma[i][j] - 1);// 不是min value。
				if(temp.size() > li.size()) {
					li = new ArrayList<>(temp);
				}
			}
		}

		return li;
	}
	public static List<Integer> findP(int i, int j, int[][] ma, List<Integer>[][] dp, int prev) {
		if(i<0 || i>= ma.length || j < 0 || j>= ma[0].length || ma[i][j] <= prev || ma[i][j] - prev != 1)
			return new ArrayList<>();
		if(dp[i][j].size() != 0)
			return dp[i][j];
		//int ret = Math.max(Math.max(findP(i-1,j, ma, dp, ma[i][j]).size(), findP(i+1,j, ma, dp, ma[i][j]).size()), Math.max(findP(i,j-1, ma, dp, ma[i][j]).size(), findP(i,j+1, ma, dp, ma[i][j]).size()));
		//dp[i][j] = ret + 1;
		//return ret + 1;
		List<Integer> t1 = findP(i-1,j, ma, dp, ma[i][j]);
		List<Integer> t2 = findP(i+1,j, ma, dp, ma[i][j]);
		List<Integer> t3 = findP(i,j-1, ma, dp, ma[i][j]);
		List<Integer> t4 = findP(i,j+1, ma, dp, ma[i][j]);
		List<Integer> temp = new ArrayList<>();
		if(t1.size() > temp.size())
			temp = new ArrayList<>(t1);
		if(t2.size() > temp.size())
			temp = new ArrayList<>(t2);
		if(t3.size() > temp.size())
			temp = new ArrayList<>(t3);
		if(t4.size() > temp.size())
			temp = new ArrayList<>(t4);
		dp[i][j].add(ma[i][j]);
		for(int ii = 0; ii< temp.size(); ii++) {
			dp[i][j].add(temp.get(ii));
		}
		return new ArrayList<>(dp[i][j]);
	}
	
	public static int findPath(int i, int j, int[][] ma, int[][] dp, int prev) {
		if(i<0 || i>= ma.length || j < 0 || j>= ma[0].length || ma[i][j] <= prev || ma[i][j] - prev != 1)
			return 0;
		if(dp[i][j] != 0)
			return dp[i][j];
		int ret = Math.max(Math.max(findPath(i-1,j, ma, dp, ma[i][j]), findPath(i+1,j, ma, dp, ma[i][j])), Math.max(findPath(i,j-1, ma, dp, ma[i][j]), findPath(i,j+1, ma, dp, ma[i][j])));
		dp[i][j] = ret + 1;
		return ret + 1;
	}
	public static void main(String[] args) {
		// test matrix
//		int[][] ma = {{9,8,7}, {8,7,5},{7,6,5}};
//		List<Integer> ret = path(ma);
//		for(int i = 0 ; i< ret.size(); i++)
//			System.out.println(ret.get(i) + " ");
		// test nums
		int[] num = new int[] {1,3,5,2,4,6,8,3,4,5,6,7};
		System.out.println(longSeqP(num));
	}
	
}
