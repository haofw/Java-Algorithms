package online_interview;
import java.io.*;
import java.util.*;
public class Combination_One {
	  static int size = Integer.MAX_VALUE;
	  public static List<Integer> combinationSum(int[] nums, int target) {
	        //List<List<Integer>> ret = new ArrayList<List<Integer>>();
	        List<Integer> temp = new ArrayList<Integer>();
	        //int size = Integer.MAX_VALUE;
	        List<Integer> re = new ArrayList<Integer>();
	        findCombine(re,temp, target, nums, 0);
	        
//	         int nu = 0;
//	         for(int i = 0; i< ret.size(); i++){
//	             if(ret.get(i).size() < size){
//	                 size = ret.get(i).size();
//	                 nu = i;
//	             }
//	         }
	        return re;
	    }
	    public static void findCombine(List<Integer> re, List<Integer> temp, int remain, int[] nums, int index){
	        if(remain <0)
	            return;
	        if(remain == 0){
	            if(temp.size() < size){
	                size = temp.size();
	                re.clear();
	                for(int i = 0; i< temp.size(); i++)
	                		re.add(temp.get(i));
	            }
	            return;
	        }
	        for(int i = index; i< nums.length; i++){
	            temp.add(nums[i]);
	            findCombine(re, temp, remain - nums[i],nums, i);
	            
	            temp.remove(temp.size() - 1);
	        }
	        
	        
	    }
	  public static void main (String[] args) {
	    int[] nums = new int[]{1,2,3,4};
	    int target = 7;
	    List<Integer> small = combinationSum(nums, target);

	      System.out.print(target + " ");
	    for(int i = 0; i< small.size(); i++)
	      System.out.print(small.get(i) + " ");
	  }
}
