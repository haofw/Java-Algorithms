package intern;
//import java.util.*;
public class SmallArraySequence {
	public static boolean isSmallA(int[] nums, int x, int y) {
		int[] index = new int[y+1];
		for(int i = 0; i< nums.length; i++) {
			if(nums[i] >y || nums[i] < x)
				return false;
			index[nums[i]] ++;
		}
		for(int i = x; i<= y - 2; i++) {
			if(index[i] == 0)
				continue;
			if(index[i] != 0) {
				if(index[i+1] <index[i] || index[i+2] < index[i])
					return false;
				index[i+1] = index[i+1] - index[i];
				index[i+2] = index[i+2] - index[i];
				index[i] = 0;
			}
			
		}
		if(index[y-1] != 0 || index[y] != 0)
			return false;
		return true;
	}
	public static void main(String[] args) {
		int[] nums = new int[] {2,2,2,3,3,3,4,4,4};
		int x = 0; int y = 8;
		System.out.println(isSmallA(nums,x,y));
		
	}
}
