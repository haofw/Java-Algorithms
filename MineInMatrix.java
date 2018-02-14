package online_interview;
import java.util.*;
public class MineInMatrix {
	public static int[][] setMine(int[][] matrix, int k) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0)
			return matrix;
		int[][] ret = new int [matrix.length][matrix[0].length];
		Map<Integer, Integer> map = new HashMap<>();
		int m = matrix.length;
		int n = matrix[0].length;
		Random ran = new Random();
		int index = m*n ;
		while(k -- > 0) {
			int temp = ran.nextInt(index);
			if(!map.containsKey(temp)) {
				map.put(temp, map.getOrDefault(index - 1, index - 1));
				//map.put(temp, index - 1);
				ret[temp/n][temp%n] = 1;
			}
			else {
				int swap = map.get(temp);
				ret[swap/n][ swap%n] = 1;
				map.put(temp, map.getOrDefault(index - 1, index - 1));
				//map.put(temp, index - 1);
			}
			index --;
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[3][4];
		int k = 12;
		int[][] ret = setMine(matrix, k);
		for(int i = 0; i< ret.length; i++) {
			for(int j = 0; j< ret[i].length; j++) {
				System.out.print(ret[i][j] );
			}
			System.out.println();
		}
		
	}
}
