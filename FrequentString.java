package online_interview;
import java.util.*;
public class FrequentString {
	public static String frequentstring(String[] st) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		for(String s : st) {
			map.put(s, map.getOrDefault(s,0) + 1);
		}
		String ret = "";
		int max = 0;
		for(String s : map.keySet()) {
			if(map.get(s) > max) {
				ret = s;
				max = map.get(s);
			}
		}
		return ret;
	}
	public static void main (String[] args) {
		String[] st = {"abcd", "yelp", "python", "Java" , "yelp"};
		System.out.println(frequentstring(st));
	}
}
