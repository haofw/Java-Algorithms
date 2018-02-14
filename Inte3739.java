package intern;
import java.util.*;
//A.  给你一堆横着的竖着的线条， 自己定义data structure， 找出可以组成的最大面积长方形。
//B.  给你两个vector a, b, 告诉你b是a的permutation， 让你返回这个permutation， 具体返回啥自己定义， 反正你返回的这个东西， 还得能用到别的vector 上，
//比如你返回个P， 如果我再给你个c, 你能用这个P把c变成相应的permutation d， 还让写了test。 感觉大哥题目表述的不是很清楚， 问他是不是想要这个， 
//他就支支吾吾的反正感觉他自己都不知道想要问什么。。
//C. 国人小哥， 很给力， 第一题 找 x 的square root， x 是float number。
//D. 先摔了一个 add two string, 就是给你两个string， 代表两个数，求他们和， 秒了之后大哥问我这题是不是做过， 我说做过类似的吧， 然后大哥又给了我一道题：
//有个n 个村庄， 在一条线上， 现在要在这些村庄里建K个医院， 求这些村庄到这K个医院的最小距离
public class Inte3739 {
	public int sqrt(int x) {
		if (x == 0 || x == 1)
		       return x; 
//	    // Staring from 1, try all numbers until
//	    // i*i is greater than or equal to x.
//	    int i = 1, result = 1;
//	    while (result < x)
//	    {
//	       if (result == x)
//	          return result;
//	       i++;
//	       result = i*i;
//	    }
//	    return i-1;   // O(√ n)
	    int start = 1;
	    int end = x;
	    while(start < end) {
	    		int mid = (start + end)/2;
	    		if(mid == x / mid)
	    			return mid;
	    		else if(mid > x / mid) {
	    			end = mid -1;
	    		}
	    		else
	    			start = mid + 1;
	    }
	    return start;   //O(Log x)
	}
	public static float sqrt(float n, float pre) {
		float x = n;
		float y = 1;
		float e = 0.0001f;
		while(x - y > e) {
			x = (x+y)/2;
			y = n/x;
		}
		return x;
	}
	public static void main(String[] args) {
		float n = 7.0f;
		float pre = 0.001f;
		System.out.print(sqrt(n,pre));
	}
	static class Line{
		int[] p1;
		int[] p2;
		boolean isRow;
		public Line(int p1, int p2, int p3, int p4, boolean isRow) {
			this.p1 = new int[]{p1,p2};
			this.p2 = new int[]{p3,p4};
			this.isRow = isRow;
		}
	}
	public static int maxArea(List<Line> li) {
		int ret = 0;
		
		return ret;
	}
}
