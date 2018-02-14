package interview;
import java.util.*;
public class MissingNum {
	public static List<Integer> miss(int[] nums){
		List<Integer> ret = new ArrayList<>();
		int size = Integer.MAX_VALUE/8;
		Byte[] save = new Byte[size];
		//Arrays.fill(save, 0);
		int block = 0;
		int index = 0;
		for(int i = 0; i< nums.length; i++) {
			block = nums[i]/8;
			index = nums[i] % 8;
			try {
				save[block] = (byte) (save[block] | (byte) (1<<index));
			}
			catch (Exception e) {
				save[block] = (byte) (1<<index);
			}
//			if(save[block] == null)
//				save[block] = (byte) (1<<index);
//			else
//				save[block] = (byte) (save[block] | (byte) (1<<index));
		}
		for(int i = 0; i< save.length; i++) {
//			if(save[i] == 0)
//				break;
			try {
				if(save[i] != 127) {
					String two = toTwo(save[i]);
					for(int j = two.length() - 1; j>= 0; j--) {
						if(two.charAt(j) =='0')
							ret.add(i*8 + (two.length()-j-1));
					}
				}
			}
			catch (Exception e) {
				break;
			}
		}
		return ret;
	}
	public static String toTwo(int num) {
		StringBuilder sb = new StringBuilder();
		while(num != 0) {
			sb.append(num%2);
			num = num/2;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Byte[] a = new Byte[2];
		a[0] = (byte) 1 << 2;
		//a[1] = (byte) (a[0] | (byte) (1<<1));
		a[1] = 127;
		System.out.println(a[1]);
		//int index = 0;
		int[] nums = new int[96];
		for(int i= 3; i< 95; i++)
			nums[i] = i;
		nums[95] = 1;
		nums[0] = 2;
		nums[1] = 99;
		nums[2] = 100;
		System.out.println(miss(nums));
		System.out.println(toTwo(22));
	}
}
