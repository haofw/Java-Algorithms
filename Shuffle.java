package interview;
import java.util.*;
public class Shuffle {
	public static String shuffle(String s) {
		//String ret = "";
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i< s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> m1, Map.Entry<Character, Integer> m2) {
				return m2.getValue() - m1.getValue();
			}
		});
		for(Map.Entry<Character, Integer> m : map.entrySet()) {
			pq.offer(m);
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()) {
			Map.Entry<Character, Integer> m1 = pq.poll();
			Map.Entry<Character, Integer> m2 = null;
			if(!pq.isEmpty())
				m2 = pq.poll();
			if(m2 != null) {
				if(sb.length() == 0) {
					sb.append(m1.getKey());
					sb.append(m2.getKey());
				}
				else if(sb.charAt(sb.length()- 1) != m1.getKey()) {
					sb.append(m1.getKey());
					sb.append(m2.getKey());
				}
				else {
					sb.append(m2.getKey());
					sb.append(m1.getKey());
				}

//				sb.append(m1.getKey());
//				sb.append(m2.getKey());
				m1.setValue(m1.getValue() - 1);
				m2.setValue(m2.getValue() - 1);
				if(m1.getValue() > 0)
					pq.offer(m1);
				if(m2.getValue() > 0)
					pq.offer(m2);
			}
			else {
				if(sb.charAt(sb.length()- 1) == m1.getKey())
					return "";
				else
					sb.append(m1.getKey());
				//sb.append(m1.getKey());
				m1.setValue(m1.getValue() - 1);
				if(m1.getValue() > 0)
					return "";
			}
			
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s = "aaabc";
		String ret = shuffle(s);
		System.out.println(ret);
	}
	
}
