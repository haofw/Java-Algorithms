package intern;
import java.util.*;
//1<=>2<=>3<=>4<=>5
//再给一个List，存的是某些Node的指针，例如存的是1,3,4,5，要求找这些Node里有多少group，一个Group里的Node是连通的
//比如3,4,5是连通的，但是不和1直接连通，所以返回2个group 
public class Inte33 {
	static class Dll{
		int val;
		Dll next;
		Dll prev;
		public Dll(int val) {
			this.val = val;
			next = null;
			prev = null;
		}
	}
	public static int group(List<Dll> nodeList) {
		int ret = 0;
		Set<Dll> set = new HashSet<>(nodeList);
		Set<Dll> visited = new HashSet<>();
		for(Dll node : set) {
			if(visited.contains(node))
				continue;
			dfs(node, visited, set);
			ret ++;
		}
		return ret;
	}
	public static void dfs(Dll node, Set<Dll> visited, Set<Dll> set) {
		if(node == null || visited.contains(node) || !set.contains(node))
			return;
		visited.add(node);
		dfs(node.next, visited, set);
		dfs(node.prev, visited, set);
	}
	public static void main(String[] args) {
		Dll root = new Dll(1);
		Dll r1 = new Dll(2);
		Dll r2 = new Dll(3);
		Dll r3 = new Dll(4);
		Dll r4 = new Dll(5);
		root.next = r1;
		r1.prev = root;
		r1.next = r2;
		r2.prev = r1;
		r2.next = r3;
		r3.prev = r2;
		r3.next = r4;
		r4.prev = r3;
		Dll[] li = {root,r2,r3,r4};
		List<Dll> nodeList = Arrays.asList(li);
		System.out.println(group(nodeList));
		
	}
}
