package interview;
import java.util.*;
public class Ladder {
//	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//        Set<String> set = new HashSet<String>(wordList);
//        List<List<String>> ret = new ArrayList<>();
//        
//        if(!set.contains(endWord))
//            return ret;
//        // if(beginWord.equals(endWord)){
//        //     temp.add(endWord);
//        //     ret.add(temp);
//        //     return ret;
//        // }
//        Map<String, List<String>> record = new HashMap<>();
//        set.remove(beginWord);
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        //int len = 1;
//        boolean flag = false;
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i = 0; i< size; i++){
//                String temp = queue.poll();
//                List<String> next = findNext(temp, set);
//                for(String s: next){
//                    if(s.equals(endWord))
//                        flag = true;
//                    if(!record.containsKey(s))
//                        record.put(s, new ArrayList<String>());
//                    record.get(s).add(temp);
//                    queue.offer(s);
//                }
//            }
//            if(flag)
//                break;
//            //len ++;
//        }
//        List<String> temp = new ArrayList<>();
//        //LinkedList<String> result = new LinkedList<String>();
// 	    backTrace(endWord,beginWord,temp, record, ret);     
//        return ret;
//        
//    }
//    private static void backTrace(String word,String start,List<String> list, Map<String, List<String>> map, List<List<String>> ret){
//        if (word.equals(start)){
//            list.add(0,start);
//            ret.add(new ArrayList<String>(list));
//            list.remove(0);
//            return;
//        }
//        list.add(0,word);
//        if (map.get(word)!=null)
//            for (String s:map.get(word))
//                backTrace(s,start,list,map, ret);
//        list.remove(0);
//    }
//	
//	
//    public static List<String> ladderLength(String beginWord, String endWord, List<String> wordlist) {
//        Set<String> set = new HashSet<String>(wordlist);
//        List<String> ret = new ArrayList<>();
//        if(beginWord.equals(endWord)) {
//        		ret.add(beginWord);
//            return ret;
//        }
//        if(!set.contains(endWord))
//            return ret;
//        Map<String, String> record = new HashMap<>();
//        set.remove(beginWord);
//        Queue<String> queue = new LinkedList<>();
//        queue.offer(beginWord);
//        //int len = 1;
//        //boolean canGet = false;
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i = 0; i< size; i++){
//                String temp = queue.poll();
//                List<String> next = findNext(temp, set);
//                for(String s: next){
//                    if(s.equals(endWord))
//                        //canGet = true;
//                    record.put(s,temp);
//                    queue.offer(s);
//                }
//            }
//            //len ++;
//        }
//        String tt = endWord;
//        ret.add(endWord);
//        while(record.containsKey(tt)) {
//        		ret.add(record.get(tt));
//        		tt = record.get(tt);
//        }
//        return ret;
//    }
//    
//    public static List<String> findNext(String word, Set<String> set){
//        List<String> ret = new ArrayList<>();
//        char[] ch = word.toCharArray();
//        for(int i = 0; i< ch.length; i++){
//            char ori = ch[i];
//            for(char temp = 'a'; temp<'z'; temp ++){
//                ch[i] = temp;
//                if(set.contains(String.valueOf(ch))){
//                    set.remove(String.valueOf(ch));
//                    ret.add(String.valueOf(ch));
//                }
//            }
//            ch[i] = ori;
//        }
//        return ret;
//    }
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<String>(wordList);
        Map<String, Integer> layer = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        queue.offer(beginWord);
        int la = 1;
        layer.put(beginWord, 0);
        List<List<String>> ret = new ArrayList<>();
        boolean quit = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i = 0; i< size; i++){
            		String s = queue.poll();
                List<String> neigh = findNeigh(set, s);
                for(String temp : neigh){
                    if(temp.equals(endWord))
                        quit = true;
                    if(!layer.containsKey(temp)){
                        queue.offer(temp);
                        layer.put(temp, la);
                    }
                    if(!map.containsKey(temp))
                        map.put(temp, new ArrayList<String>());
                    map.get(temp).add(s);
                }
            }
            if(quit)
                break;
            la ++;
        }
        dfs(ret, new ArrayList<String>(), map, layer, beginWord, endWord);
        return ret;
    }
    public static void dfs(List<List<String>> ret, List<String> temp, Map<String, List<String>> map, Map<String, Integer> layer, String s, String e){
        temp.add(0,e);
        if(e.equals(s)){
            ret.add(new ArrayList<String> (temp));
            return;
        }
        List<String> li = map.get(e);
        for(String te : li){
            if(layer.get(e) - layer.get(te) == 1){
                dfs(ret, temp, map, layer, s, te);
            }
            temp.remove(temp.size() - 1);
        }
        
    }
    
    public static List<String> findNeigh(Set<String> set, String s){
        List<String> ret = new ArrayList<>();
        char[] ch = s.toCharArray();
        for(int i = 0; i< ch.length; i++){
            char temp = ch[i];
            for(char c = 'a'; c<= 'z'; c++){
                if(c != temp){
                    ch[i] = c;
                    String t = String.valueOf(ch);
                    if(set.contains(t)){
                        ret.add(t);
                    }
                }
            }
            ch[i] = temp;
        }
        return ret;
    }
    public static void main(String[] args) {
    		String begin = "hit";
    		String end = "cog";
    		String[] list = new String[] {"hot","dot","dog","lot","log","cog"};
    		List<String> wordlist = Arrays.asList(list);
    		List<List<String>> ret = findLadders(begin,end,wordlist);
    		for(int i = 0; i< ret.size(); i++) {
    			for(int j = 0; j< ret.get(i).size(); j++)
    				System.out.println(ret.get(i).get(j));
    			
    		}
    			
    	
    }
}
