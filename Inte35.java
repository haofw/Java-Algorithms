package intern;
import java.util.*;
public class Inte35 {
//	给一堆投票和相应的timestamp，输出小于给定的时间T得票最多的candidate
//	follow1: 再给一个长度k，输出小于给定时间T得票前k的candidate list. from: 1point3acres.com/bbs 
//	follow2: 给一个candidate list，求出最小的T使得使用follow1的function能得到这个candidate list
	//原意是给一个top k的list，找到一个T值，使得小于这个T值得top k list和输入的top k list相等
	public static String candidate(List<String[]> vote, int T) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i< vote.size(); i++) {
			if(Integer.valueOf(vote.get(i)[1]) > T)
				continue;
			map.put(vote.get(i)[0], map.getOrDefault(vote.get(i)[0], 0) + 1);
		}
		String ret = "";
		int max = 0;
		for(String s:map.keySet()) {
			if(map.get(s) > max) {
				max = map.get(s);
				ret = s;
			}
		}
		return ret;
	}
	public static int getTime(List<String[]> vote, int k) {
		Collections.sort(vote, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return Integer.valueOf(s1[1]) - Integer.valueOf(s2[1]);
			}
		});
		int ret = 1;
		for(int i = 1; i< vote.size(); i++) {
			if(!(vote.get(i)[0]).equals(vote.get(i-1)[1])) {
				ret ++;
			}
			if(ret == k)
				return Integer.valueOf(vote.get(i)[1]);
		}
		return Integer.valueOf(vote.get(0)[1]);
	}
	public static List<String> candidate(List<String[]> vote, int T, int k) {
		List<String> ret = new ArrayList<>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i< vote.size(); i++) {
			if(Integer.valueOf(vote.get(i)[1]) > T)
				continue;
			map.put(vote.get(i)[0], map.getOrDefault(vote.get(i)[0], 0) + 1);
		}
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
				return m1.getValue() - m2.getValue();
			}
		});
		for(Map.Entry<String, Integer> m : map.entrySet()) {
			pq.offer(m);
			if(pq.size() > k)
				pq.poll();
		}
		if(pq.size() != k)
			return ret;
		for(int i = 0; i< k; i++) {
			ret.add(0,pq.poll().getKey());
		}
		return ret;
	}
	public static void main(String[] args) {
		String[][] re = {{"a","1"},{"b","2"},{"c","1"},{"e","3"},{"a","6"},{"a","5"},{"c","4"},{"c","3"}};
		List<String[]> ret = Arrays.asList(re);
		int T = 5;
		int k = 4;
		System.out.println(candidate(ret,T));
		System.out.println(candidate(ret,T,k));
		System.out.println(getTime(ret,k));
	}
}
