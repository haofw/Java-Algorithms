package online_interview;
import java.util.*;
public class Combination {
	public static List<List<Integer>> combinationsum(int[] nums, int target){
		List<List<Integer>> li = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		findcombi(nums,target,0,li,temp);
		//return temp;
		return li;
	} 
	public static void findcombi(int[] nums, int remain, int start, List<List<Integer>> li, List<Integer> temp) {
		if(remain < 0)
			return;
		if(remain == 0) {
			li.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i = start; i < nums.length; i++) {
			temp.add(nums[i]);
			if(remain - nums[i] >= 0)
				findcombi(nums, remain - nums[i], i, li,temp);
			temp.remove(temp.size() - 1);	
		}
	}
	public static void main(String[] args) {
		int[] nums = { 1,2,3};
		int target = 7;
		List<List<Integer>> out = combinationsum(nums,target);
		int minlen = Integer.MAX_VALUE;
		int minindex = -1;
		for(int i = 0; i< out.size(); i++) {
			if(out.get(i).size() < minlen) {
				minlen = out.get(i).size();
				minindex= i;
			}
		}
		for(int j = 0; j< out.get(minindex).size(); j++)
			System.out.print(out.get(minindex).get(j) + " ");
		
	}
}
