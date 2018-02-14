package interview;
import java.util.*;
public class TwosumPairs {
	//You are given an array of integers and a sum. Find all pairs of integers that equal that sum.
	public static List<int[] > findP(int[] nums, int target){
		List<int[]> ret = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int i = 0; i< nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				List<Integer> temp = map.get(target - nums[i]);
				for(int j : temp)
					ret.add(new int[] {i,j});
			}
			if(!map.containsKey(nums[i]))
				map.put(nums[i], new ArrayList<Integer> ());
			map.get(nums[i]).add(i);
		}
		return ret;
	}
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,1,2,3,2,3,1,2};
		int target = 2;
		List<int[]> ret = findP(nums, target);
		for(int i = 0; i< ret.size(); i++) {
			System.out.println(ret.get(i)[0] + "," + ret.get(i)[1]);
		}
	}
}
