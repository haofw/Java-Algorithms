package online_interview;
import java.util.*;
public class MinQueue {
	Deque<Integer> minQueue;
	Queue<Integer> queue;
	public MinQueue() {
		minQueue = new ArrayDeque<>();
		queue = new LinkedList<>();
	}
	public void offer(int val) {
		queue.offer(val);
		while(!minQueue.isEmpty() && val < minQueue.peekLast()) {
			minQueue.pollLast();
		}
		minQueue.offer(val);
	}
	public int getMin() {
		return minQueue.peek();
	}
	public int peek() {
		return queue.peek();
	}
	public void poll() {
		int temp = queue.poll();
		if(minQueue.peek() == temp)
			minQueue.poll();
	}
	public boolean isEmpty() {
        return queue.isEmpty();
    }
	public static void main(String[] args) {
        MinQueue mq = new MinQueue();
        int[] input = new int[]{3, 3, 4, 5, 2, 4, 1, 3};
        for (int x : input) {
            mq.offer(x);
            System.out.print(mq.getMin());
        }
        System.out.println();
        while(!mq.isEmpty()) {
            mq.poll();
            if (!mq.isEmpty()) System.out.print(mq.getMin());
        }
    }
	
}
