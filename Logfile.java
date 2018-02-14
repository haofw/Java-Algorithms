package interview;
import java.util.*;
//给你一个log file，每一行都有一条记录，包括三个数据：访问时间，user id，访问的page id。
//然后让你找出访问次数最多的10组3个连续访问page。就是如果user A访问了page 1 2 3，这样 1 2 3 就算被访问了一次。
//不用考虑时间间隔所以我昨天访问1，今天2，后天3，也能算作连续访问page。
public class Logfile {
	public static class logFile{
		int time;
		int userid;
		int pageid;
		public logFile(int t, int ui, int pi) {
			time = t;
			userid = ui;
			pageid = pi;
		}
	}
	public static int[] maxFrequencyPage(List<logFile> file) {
		int[] ret = new int[10];
		
		
		return ret;
	}
	public static void main(String[] args) {
		Queue<String> a = new LinkedList<>();
		Queue<String> b = new LinkedList<>();
		a.offer("a");
		a.offer("b");
		b.offer("a");
		b.offer("b");
		a.offer("c");
		Map<Queue<String>, Integer> map = new HashMap<>();
		map.put(a,1);
		System.out.println(map.containsKey(b));
		System.out.println(a.equals(b));
	}
	
}
