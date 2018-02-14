package intern;
import java.util.*;
public class SquareRec {
	public static int findMax(int[][] points) {
		Set<int[]> set = new HashSet<>();
		for(int i = 0; i< points.length; i++)
			set.add(points[i]);
		int maxA = 0;
		for(int i = 0; i< points.length; i++) {
			for(int j = 0; j< points.length; j++){
				if(i == j)
					continue;
				int x1 = points[i][0];
				int y1 = points[i][1];
				int x2 = points[j][0];
				int y2 = points[j][1];
				int[] p1 = new int[] {(x1+x2+y2-y1)/2,(y1+y2+x1-x2)/2};
				int[] p2 = new int[] {(x1+x2+y1-y2)/2,(y1+y2+x2-x1)/2};
				if(set.contains(p1) && set.contains(p2))
					maxA = Math.max(maxA, ((y2-y1)*(y2-y1) + (x2-x1)*(x2-x1))/2);
			}
		}
		return maxA;
	}
	//问这些坐标中能连成的长方形中，面积最大的那个是多大
	public static int findRec(int[][] points) {
		int min = Integer.MAX_VALUE;
		//Set<int[]> set = new HashSet<>();   ->  cannot work;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for(int i = 0; i< points.length; i++) {
			if(!map.containsKey(points[i][0]))
				map.put(points[i][0], new HashSet<>());
			map.get(points[i][0]).add(points[i][1]);
		}
		for(int i = 0; i< points.length; i++) {
			for(int j = 0; j < points.length; j++) {
				if(i == j || points[i][1] == points[j][1] || points[i][0] == points[j][0])
					continue;
				int[] t1 = new int[] {points[i][0], points[j][1]};
				int[] t2 = new int[] {points[j][0], points[i][1]};
				if(map.containsKey(t1[0]) && map.get(t1[0]).contains(t1[1]) && map.containsKey(t2[0]) && map.get(t2[0]).contains(t2[1])) {
					min = Math.min(min, Math.abs((points[i][0] - points[j][0]) * (points[i][1] - points[j][1])));
				}
			}
		}
		return min;
	}
	public static void main(String[] args) {
		int[][] points = {{2,2},{2,1},{4,2},{4,0},{2,0}, {8,1},{8,0}};
		System.out.println(findRec(points));
	}
}
