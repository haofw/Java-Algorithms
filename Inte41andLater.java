package intern;
import java.util.*;
//第一题是给你一个函数，可以返回指定区间内的随机整数，让你写一个返回三个整数的，还要求所有可能的three tuple概率一致。然后更改了题目要求，要求三者不同，我写了两个版本，一个while loop的，一个不需要while loop的
//第二题是给定一些source 到 target的映射，要求找到那些target有三个source （原始题目没有提到source target之类的，是我给他们起的名字，反正意思差不多），把映射反过来就行。然后要求随机返回，恰好用到了第一题的函数. 
//第一題是給你一個 string ，讓你寫個 function，看看是否可以"洽"刪除一個 char ，使得剩下的 string 是個 valid palindrome。刪除0個 or 多於1個都不行。
public class Inte41andLater {
	
	public static boolean getP(String s) {
		char[] ch = s.toCharArray();
		int start = 0;
		int end = s.length() - 1;
		while(start < end) {
			if(ch[start] != ch[end]) {
				return isP(s.substring(0, start) + s.substring(start + 1)) || isP(s.substring(0, end) + s.substring(end + 1));
			}
			start ++;
			end --;
		}
		return true;
	}
	public static boolean isP(String s) {
		int start = 0;
		int end = s.length() -1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end))
				return false;
			start ++;
			end --;
		}
		return true;
	}
	public static int getR(int s, int e) {
		Random rnd = new Random();
		return rnd.nextInt(e-s+1) + s;
	}
	public static int[] get3R(int s, int e) {
		int[] ret = new int[3];
//		ret[0] = getR(s,e);
//		ret[1] = getR(s,e);
//		ret[2] = getR(s,e);
		Map<Integer, Integer> map = new HashMap<>();
		int index = e + 1;
		int re = 0;
		for(int i = 0; i< 3; i++) {
			int rnd = getR(s,index);
			if(!map.containsKey(rnd)) {
				map.put(rnd, map.getOrDefault(index - 1, index - 1));
				re = rnd;
			}
			else {
				re = map.get(rnd);
				map.put(rnd, map.getOrDefault(index - 1, index - 1));
			}
			ret[i] = re;
			index --;
		}
		return ret;
	}
//	一个什么游戏，大概意思是，有一个source string，一个target string。二者都只包含"L","R","_" 三种字符，L可以往左移，R可以往右移，不能jump over。. visit 1point3acres.com for more.
//    让设计一个函数，判断能否从source走到target，返回boolean;.鏈枃鍘熷垱鑷�1point3acres璁哄潧
//			比如
//	"_L_R" ,"L__R"---> true
//	"_L_R_" ,"L___R"---> true
//	"_R_L_" ,"_R__L"---> false
	// 双指针！。
	public static boolean  canG(String s1, String s2) {
		int i = 0;
		int j = 0;
		while(i< s1.length() && j<s2.length()) {
			if(s1.charAt(i) != '_' && s2.charAt(j) != '_' ) {
				if(s1.charAt(i) != s2.charAt(j))
					return false;
				else if(s1.charAt(i) == 'L'){
					if(i < j)
						return false;
				}
				else {
					if(i>j)
						return false;
				}
				i ++;
				j ++;
			}
			else {
				if(s1.charAt(i) == '_')
					i++;
				if(s2.charAt(j) == '_')
					j++;
			}
		}
		if(i < s1.length()) {
			for(int a = i; a<s1.length(); a++) {
				if(s1.charAt(a) != '_')
					return false;
			}
		}
		else if(j < s1.length()) {
			for(int a = j; a< s2.length(); a++) {
				if(s2.charAt(a) != '_')
					return false;
			}
		}
		return true;
	}
//给你一串数据 <key, value, expiredTime>，设计一个数据结构存储。
//	然后实现三个函数get(), put(), expire()。
//	问了什么时候调用expire().
//	问是否还能有提升，回到可以用priorityQueue存储expiredTime，然后代码实现了。 大哥表示happy。
	static class expiredMap{
		Map<Integer, Integer> value; // store key-value
		Map<Integer, Integer> time; //store key-expiredTime
		PriorityQueue<int[]> pq = new PriorityQueue<>();
		public expiredMap() {
			value = new HashMap<Integer, Integer>();
			time = new HashMap<Integer, Integer>();
		}
		public int get(int k, int t) {
			expire(t);//...
			if(expire(k,t) || !value.containsKey(k))
				return -1;
			else
				return value.get(k);
		}
		public void put(int k, int v, int ext) {
			value.put(k, v);
			time.put(k, ext);
			pq.offer(new int[] {k,ext});
		}
		public void expire(int t) {
			while(!pq.isEmpty()) {
				if(pq.peek()[1] < t)
					value.remove(pq.poll()[0]);
			}
		}
		public boolean expire(int k, int t) {
			return time.get(k) < t;
		}
	}
	//有一串流数据<Symbol, timestamp, price>，并且还有可能有修正数据（Correction Data）<Symbol, timestamp, price>，
	//然后实现addData(symbol, timestamp, price)和correctData(symbol, timestamp, price)，在这两个函数里面更新minPrice, maxPrice, recentPrice。
	static class Commodity{
		PriorityQueue<int[]> minP = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i1[1] - i2[1];
			}
		});
		int min;
		int max;
		int rec;
		PriorityQueue<int[]> maxP = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] i1, int[] i2) {
				return i2[1] - i1[1];
			}
		});
		Map<Integer, Integer> oriP = new HashMap<>();
		Map<Integer, Integer> recP = new HashMap<>();
		public Commodity() {
			min = -1;
			max = -1;
			rec = -1;
		}
		public void addData(int s, int t, int p, int tn) {
			minP.offer(new int[]{s,p});
			maxP.offer(new int[] {s,p});
			recP.put(t, p);
			min = minP.peek()[1];
			max = maxP.peek()[1];
			rec = recP.get(tn);
			oriP.put(s, p);
		}
		public void correctDate(int s, int t, int p, int tn) {
			int[] pa = {s, oriP.get(s)};
			minP.remove(pa);
			minP.offer(new int[] {s,p});
			maxP.remove(pa);
			maxP.offer(new int[] {s,p});
			oriP.put(s, p);
			recP.put(t, p);
			min = minP.peek()[1];
			max = maxP.peek()[1];
			rec = recP.get(tn);
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		String s1 = "_L_R__";
		String s2 = "L_R___";
		System.out.println(canG(s1,s2));
//		int s = 1;
//		int e = 3;
//		int[] ret = get3R(s,e);
//		for(int i = 0; i< ret.length; i++)
//			System.out.println(ret[i]);
//		String ss = "acca";
//		System.out.println(getP(ss));
	}
}
