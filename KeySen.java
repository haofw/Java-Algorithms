package intern;
import java.util.*;
 //import java.io.*;
public class KeySen {
	public static List<String> findKey(List<String> key, String senten){
		List<String> ret = new ArrayList<>();
		for(int i = 0; i< key.size(); i++) {
			if(senten.indexOf(key.get(i)) != -1)
				ret.add(key.get(i));
		}
		return ret;
	}
	public static List<String> findKeys(Map<String, List<String>> map, String sen){
		Set<String> ret = new HashSet<>();
		Map<String, List<String>> key = new HashMap<>();
		for(String s : map.keySet()) {
			List<String> temp = map.get(s);
			for(int i = 0; i< temp.size(); i++) {
				if(!key.containsKey(temp.get(i))) {
					key.put(temp.get(i), new ArrayList<String>());
				}
				key.get(temp.get(i)).add(s);
			}
		}
		for(String s : key.keySet()) {
			if(sen.indexOf(s) != -1) {
				List<String> temp = key.get(s);
				for(int i = 0; i< temp.size(); i++)
					ret.add(temp.get(i));
			}
		}
		return new ArrayList<>(ret);
	}
	public static void main(String[] args) {
//		List<String> key = new ArrayList<>();
//		Scanner sc = new Scanner(System.in);
//		String senten = sc.nextLine();
//		while(sc.hasNextLine()) {
//			key.add(sc.nextLine());
//		}
//		sc.close();
//		//MJ
//		//Tracy Mc
//		//I am a fan of MJ and Tracy Mc
		Map<String, List<String>> map = new HashMap<>();
		String[] t1 = {"MJ", "Michael Jeffrey Jordan"};
		String[] t2 = {"MJ", "Michael Joseph Jackson"};
		String[] t3 = {"T-Mac"};
		map.put("Michael Jordan", new ArrayList<String>(Arrays.asList(t1)));
		map.put("Michael Jackson", new ArrayList<String>(Arrays.asList(t2)));
		map.put("Tracy McGrady", new ArrayList<String>(Arrays.asList(t3)));
		String sen = "I am a fan of MJ and T-Mac";
		List<String> ret = findKeys(map, sen);
		for(int i = 0; i< ret.size(); i++){
			System.out.print(ret.get(i) + ", ");
		}
	}
	
}
