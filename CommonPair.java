package intern;
import java.util.*;
public class CommonPair {
	//给出一个同义词的列表，如{great,   fine},   {acting,   drama},   {skills,   talent}
	//问两个句子是否同义，如"great acting skills",   "fine drama talent"是同义的，"great great"和"fine great"也是同义的
	public static boolean commonPair(String s1, String s2, String[][] syno){
		Map<String, Set<String>> map = new HashMap<>();
		String[] sen1 = s1.split(" ");
		String[] sen2 = s2.split(" ");
		if(sen1.length != sen2.length)
			return false;
		for(int i = 0; i< syno.length; i++) {
			if(!map.containsKey(syno[i][0]))
				map.put(syno[i][0], new HashSet<String>());
			if(!map.containsKey(syno[i][1]))
				map.put(syno[i][1], new HashSet<String>());
			map.get(syno[i][0]).add(syno[i][1]);
			map.get(syno[i][1]).add(syno[i][0]);
		}
		for(int i = 0; i< sen1.length; i++) {
			if(!sen1[i].equals(sen2[i])) {
				if(!map.containsKey(sen2[i]) || !map.containsKey(sen1[i]) )
					return false;
//				if(!map.get(sen1[i]).contains(sen2[i]) && !map.get(sen2[i]).contains(sen1[i]))
//					return false;
				if(!findPair(map,sen1[i], sen2[i]))
					return false;
			}
		}
		return true;
	}
	public static boolean findPair(Map<String, Set<String>> map, String s1, String s2) {
		if(map.get(s1).contains(s2))
			return true;
		List<String> temp = new ArrayList<>(map.get(s1));
		for(int i = 0; i< temp.size(); i++) {
			if(findPair(map, temp.get(i), s2))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String s1 = "great acting skills good back";
		String s2 = "fine drama talent great good";
		String[][] syno = new String[][] {{"great", "fine"}, {"acting", "drama"}, {"skills", "talent"},{"fine", "good"},{"better","fine"},{"back", "great"}};
		System.out.println(commonPair(s1,s2,syno));
		s1 = "great  acting      skills";
		String[] a = s1.split("\\s+");
		for(int i = 0; i< a.length; i++)
			System.out.print(a[i] + ",");
	}
}
