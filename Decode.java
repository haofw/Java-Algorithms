package intern;
import java.util.*;
public class Decode {
	// Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< strs.size(); i++){
            sb.append(strs.get(i).length()).append('/').append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        int i = 0;
        List<String> ret = new ArrayList<>();
        while(i < s.length()){
            int slash = s.indexOf('/',i);
            int lenth = Integer.valueOf(s.substring(i,slash));
            String temp = s.substring(slash+1, slash + lenth + 1);
            ret.add(temp);
            i = slash + lenth + 1;
        }
        return ret;
    }
    public static void main(String[] args) {
    		String[] s = {""};
    		List<String> li = Arrays.asList(s);
    		List<String> ret = decode(encode(li));
    		for(String ss : ret)
    			System.out.println(ss);
    }
}
