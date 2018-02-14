package intern;
import java.util.*;
//find the minimum number in the array.
public class GraphThings {
	static class graph1{
		List<List<Integer>> map;
		public graph1() {
			
		}
		
	}
	static class Graph{
		Map<Integer,Node> map;
		public Graph() {
			map = new HashMap<>();
		}
		public void addNode(Node n) {
			map.put(n.val, n);
		}
		public void addEdge(Node n1, Node n2) {
			map.get(n1.val).neighbor.add(n2);
		}
		
	}
	static class Node{
		List<Node> neighbor;
		int val;
		public Node( int val) {
			this.val = val;
			neighbor = new ArrayList<>();
		}
	}
	public static int recipEdges(Graph graph) {
		boolean[] visited = new boolean[graph.map.size()];
		Map<Integer, Node> map = graph.map;
		int count = 0;
		for(int i : map.keySet()) {
			if(!visited[i]) {
				List<Node> temp = map.get(i).neighbor;
				count += dfs(temp, visited, map.get(i));
				
			}
		}
		return count;
	}
	
	public static int dfs(List<Node> list, boolean[] visited, Node target) {
		int ret = 0;
		for(int i = 0; i<list.size(); i++) {
			if(visited[list.get(i).val])
				continue;
			if(list.get(i).val == target.val) {
				ret ++;
			}
			else {
				if(list.get(i).neighbor.contains(target)) {
					ret++;
				}
				visited[i] = true;
				ret += dfs(list.get(i).neighbor, visited, list.get(i));
			}
		}
		return ret;
	}
	
	public static List<int[]> findPath(Graph graph,int target){
		List<int[]> ret = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		Map<Integer, Integer> re = new HashMap<>();
		queue.offer(target);
		boolean findT = false;
		while(!queue.isEmpty() && !findT) {
			int temp = queue.poll();
			List<Node> iter = graph.map.get(temp).neighbor;
			for(int i = 0; i< iter.size(); i++) {
				queue.offer(iter.get(i).val);
				re.put(iter.get(i).val, temp);
				if(iter.get(i).val == target) {
					findT = true;
					break;
				}
			}
			
		}
		int temp = target;
		while(re.get(temp) != target) {
			ret.add(new int[] {temp, re.get(temp)});
			temp = re.get(temp);
		}
		return ret;
	}
	
	
}
