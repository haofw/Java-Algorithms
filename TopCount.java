package intern;
import java.util.*;
//输入是一个List<Message>，每个Message由<usr, text>组成，问top n word count usr，也就是输出List<String>，list里面是n个usr。
public class TopCount {
	static class Message{
		String usr;
		String text;
		public Message(String u, String t) {
			usr = u;
			text = t;
		}
	}
	public static List<String> topC(List<Message> me, int n){
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i< me.size(); i++) {
			map.put(me.get(i).usr, map.getOrDefault(me.get(i).usr, 0) + 1);
		}
		// normal way
//		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
//			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
//				return m2.getValue() - m1.getValue();
//			}
//		});
//		for(Map.Entry<String, Integer> m : map.entrySet()) {
//			pq.offer(m);
//		}
//		List<String> ret = new ArrayList<>();
//		for(int i= 0; i< n; i++) {
//			ret.add(pq.poll().getKey());
//		}
		// optimize
		PriorityQueue<Map.Entry<String, Integer>> pqo = new PriorityQueue<Map.Entry<String, Integer>>(new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
				return m1.getValue() - m2.getValue();
			}
		});
		for(Map.Entry<String, Integer> m : map.entrySet()) {
			pqo.offer(m);
			if(pqo.size() > n)
				pqo.poll();
		}
		LinkedList<String> reto = new LinkedList<>();
		while(!pqo.isEmpty()) {
			reto.addFirst(pqo.poll().getKey());
		}
		return reto;
	}
	public static void main(String[] args) {
		Message m1 = new Message("whf","aa");
		Message m2 = new Message("whf","aa");
		Message m3 = new Message("whf","aa");
		Message m4 = new Message("sp","aa");
		Message m5 = new Message("sp","aa");
		Message m6 = new Message("ls","aa");
		Message m7 = new Message("ls","aa");
		Message m8 = new Message("ls","aa");
		Message m10 = new Message("ls","aa");
		Message m9 = new Message("wxy","aa");
		List<Message> me = new ArrayList<>();
		me.add(m1); me.add(m2);me.add(m3); me.add(m4);me.add(m5); me.add(m6);me.add(m7); me.add(m8);me.add(m9);me.add(m10);
		List<String> ret = topC(me, 2);
		for(int i = 0; i< ret.size(); i++)
			System.out.print(ret.get(i) + " ");
	}
}
