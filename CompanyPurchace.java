package intern;
//给出公司并购的关系列表，比如
//[
//["baidu", "ofo"],
//["mobike", "alibaba"],
//]
//表示baidu并购了ofo，摩拜并购了阿里巴巴
//求最长的一个并购链。保证无环。
import java.util.*;
public class CompanyPurchace {
	public static List<String> buyPath(String[][] comp){
		List<String> ret = new ArrayList<>();
		Map<String, List<String>> graph = new HashMap<>();
		Map<String, Integer> degree = new HashMap<>();
		
		for(int i = 0; i< comp.length; i++) {
			if(!graph.containsKey(comp[i][0]))
				graph.put(comp[i][0], new ArrayList<String>());
			graph.get(comp[i][0]).add(comp[i][1]);
			degree.put(comp[i][1], degree.getOrDefault(comp[i][1], 0) + 1);
		}
		List<String> root = new ArrayList<>();
		for(int i = 0; i< comp.length; i++) {
			if(!degree.containsKey(comp[i][0]))
				root.add(comp[i][0]);
		}
		List<String> temp = new ArrayList<>();
		for(int i = 0; i< root.size(); i++) {
			temp = findP(graph, root.get(i));
			if(ret.size() < temp.size())
				ret = new ArrayList<>(temp);
		}
		return ret;
	}
	public static List<String> findP(Map<String, List<String>> graph, String root) {
		List<String> ret = new ArrayList<>();
		ret.add(root);
		if(!graph.containsKey(root))
			return ret;
		List<String> children = graph.get(root);
		List<String> temp = new ArrayList<>();
		for(int i = 0; i< children.size(); i++) {
			if(findP(graph, children.get(i)).size() > temp.size()) {
				temp = findP(graph, children.get(i));
			}
		}
		for(int i = 0; i< temp.size(); i++)
			ret.add(temp.get(i));
		return ret;
	}
	public static void main(String[] args) {
		String[][] comp = new String[][] {{"apple", "google"},{"google", "yelp"}, {"yelp", "baidu"}, {"Zillow","facebook"}, {"facebook","twitter"},{"facebook","whatupp"},{"facebook","pad"}, {"twitter","ofo"},{"ofo","mobai"}};
		List<String> ret = buyPath(comp);
		for(int i = 0; i< ret.size(); i++) {
			System.out.print(ret.get(i) + " ");
		}
	}
	
}
