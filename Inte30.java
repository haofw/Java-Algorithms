package intern;
import java.util.*;
public class Inte30 {
	//static private ?
	static class MazeNode{
		List<MazeNode> path;
		int val;
		MazeNode key;
		boolean needKey;
		boolean hasTre;
		public MazeNode(int val, boolean needKey, MazeNode key, boolean hasTre) {
			this.val = val;
			this.needKey = needKey;
			this.key = key;
			path = new ArrayList<>();
			this.hasTre = hasTre;
		}
	}
	public boolean canGetT(MazeNode root) {
		Set<MazeNode> canReach = new HashSet<>();
		Set<Integer> hasKey = new HashSet<>();
		Queue<MazeNode> bfs = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		bfs.offer(root);
		while(!bfs.isEmpty()) {
			MazeNode temp = bfs.poll();
			if(temp.hasTre)
				return true;
			visited.add(temp.val);
			List<MazeNode> path = temp.path;
			MazeNode tempK = temp.key;
			boolean useKey = false;
			for(int i = 0; i< path.size(); i++) {
				if(visited.contains(path.get(i).val))
					continue;
				if(tempK.val == path.get(i).val)
					useKey = true;
				if(!path.get(i).needKey || useKey || hasKey.contains(path.get(i).val)) {
					bfs.offer(path.get(i));
					visited.add(path.get(i).val);
				}
				else{
					canReach.add(path.get(i)); //hashmap
				}
			}
			if(!useKey) {
				if(canReach.contains(tempK)) {
					bfs.offer(tempK);
				}
				hasKey.add(tempK.val);
			}
			
		}
		return false;
	}
	public static void main(String[] args) {
		
	}
}
