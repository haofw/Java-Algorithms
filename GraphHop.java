package intern;
import java.util.*;
//上来直接做题 给一个graph和一个node 返回从这个node开始最多n个hop能到达的所有点的list 
//followup是excat n个hop能到达点的list 中间要考虑各种情况，比如有cycle的时候
public class GraphHop {
	static class Graph{
		int V; // # of nodes
		LinkedList<Integer>[] adjArray;   // LinkedList<Integer> adjArray[]
		@SuppressWarnings("unchecked")
		Graph(int V){
			this.V = V;
			adjArray = new LinkedList[V];
			for(int i = 0; i< V; i++)
				adjArray[i] = new LinkedList<Integer>();
		}
	}
	static void addEdge(Graph graph, int src, int dest)
    {
        // Add an edge from src to dest. 
        graph.adjArray[src].addFirst(dest);
         
        // Since graph is undirected, add an edge from dest
        // to src also
        graph.adjArray[dest].addFirst(src);
    }
	public static List<Integer> hop(Graph g, int n, int start){
		List<Integer> ret = new ArrayList<>();
		//bfs
		boolean[] visited = new boolean[g.V];
		visited[start] = true;
		ret.add(start);
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		int layer = 1;
		while(!queue.isEmpty() && layer <= n) {
			int size = queue.size();
			for(int t = 0 ; t< size; t++) {
				int temp = queue.poll();
				LinkedList<Integer> children = g.adjArray[temp];
				for(int i = 0; i< children.size(); i++) {
					if(visited[children.get(i)])
						continue;
					queue.offer(children.get(i));
					ret.add(children.get(i));
					visited[children.get(i)] = true;
				}
			}
			layer ++;
		}
		return ret;
	}
	public static void main(String[] args) {
		Graph g = new Graph(7);
		addEdge(g, 1,2);
		addEdge(g, 2,5);
		addEdge(g, 3,4);
		addEdge(g, 2,4);
		addEdge(g, 1,3);
		addEdge(g, 1,6);
		addEdge(g, 4,6);
		List<Integer> ret = hop(g,3,1);
		for(int i = 0; i< ret.size(); i++)
			System.out.print(ret.get(i) + " ");
	}
}
