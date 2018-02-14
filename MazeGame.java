package intern;
import java.util.*;
public class MazeGame {
	static class Maze{
		boolean[][] m;
		public Maze(boolean[][] m) {
			this.m = m;
		}
	}
	static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static List<Point> minPath(Maze m, Point start, Point end){
		LinkedList<Point> ret = new LinkedList<>();
		int r = m.m.length;
		int c = m.m[0].length;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(start);
		Set<Point> visited = new HashSet<>();
		Map<Point, Point> path = new HashMap<>();
		visited.add(start);
		while(!queue.isEmpty()) {
			Point father = queue.poll();
			List<Point> neigh = getNeigh(m, father, r,c);
			for(int i = 0; i< neigh.size(); i++) {
				if(visited.contains(neigh.get(i)))
					continue;
				visited.add(neigh.get(i));
				path.put(neigh.get(i), father);
				if(neigh.get(i).equals(end)) {
					break;
				}
				queue.offer(neigh.get(i));
			}
		}
		Point temp = end;
		ret.addFirst(end);
		while(!temp.equals(start)) {
			temp = path.get(temp);
			ret.addFirst(temp);
		}
		return ret;
	}
	public static List<Point> getNeigh(Maze m, Point a, int r, int c){
		List<Point> ret = new ArrayList<>();
		for(int i = a.y + 1; i< c; i++) {
			if(isObstacle(new Point(a.x,i), r, c, m)) {
				ret.add(new Point(a.x, i-1));
				break;
			}
		}
		for(int i = a.y - 1; i>= -1; i--) {
			if(isObstacle(new Point(a.x,i), r, c, m)) {
				ret.add(new Point(a.x, i+1));
				break;
			}
		}
		for(int i = a.x + 1; i< r; i++) {
			if(isObstacle(new Point(i,a.y), r, c, m)) {
				ret.add(new Point(i-1, a.y));
				break;
			}
		}
		for(int i = a.x - 1; i>= -1; i--) {
			if(isObstacle(new Point(i,a.y), r, c, m)) {
				ret.add(new Point(i+1, a.y));
				break;
			}
		}
		return ret;
	}
	public static boolean isObstacle(Point p, int r, int c, Maze m) {
		if(p.x == -1 || p.y == -1 || p.x == r || p.y == c || !m.m[p.x][p.y])
			return true;
		return false;
	}
}
