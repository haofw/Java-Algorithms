package intern;
import java.util.*;
public class Interval {
	public static List<String> findIn(int[] arr){
		List<String> ret= new ArrayList<>();
		if(arr == null || arr.length == 0)
			return ret;
//		if(arr.length == 1) {
//			if(arr[0] == 0)
//				ret.add("1-99");
//			else if(arr[0] == 1) {
//				ret.add("0");
//				ret.add("2-99");
//			}
//			else if(arr[0] == 99)
//				ret.add("0-98");
//			else if(arr[0] == 98) {
//				ret.add("0-97");
//				ret.add("99");
//			}
//			else {
//				ret.add("0-" + String.valueOf(arr[0]-1));
//				ret.add(String.valueOf(arr[0]+1 + "-99"));
//			}
//			return ret;
//		}
		//int temp = 0;
		if(arr[0] == 1)
			ret.add("0");
		else if(arr[0] >=2)
			ret.add("0-" + String.valueOf(arr[0]));
		for(int i = 1; i< arr.length; i++) {
			if(arr[i] != arr[i-1] +1) {
				if(arr[i] - arr[i-1] == 2)
					ret.add(String.valueOf(arr[i] - 1));
				else
					ret.add(String.valueOf(arr[i-1] + 1) +"-" + String.valueOf(arr[i] -1));
			}
		}
		if(arr.length != 1 && arr[arr.length-1] != 99) {
			if(arr[arr.length-1] == 98)
				ret.add("99");
			else
				ret.add(String.valueOf(arr[arr.length-1] + 1) + "-99");
		}
		for(int i = 0; i<= 99; i++) {
			//？
			
		}
		return ret;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,50,51,89};
		List<String> ret = findIn(arr);
		for(int i = 0; i<ret.size(); i++)
			System.out.print(ret.get(i) + " ");
	}
}
