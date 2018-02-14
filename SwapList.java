package interview;

public class SwapList {
	public static class LinkedNode {
		int val;
		LinkedNode next;
		public LinkedNode(int val) {
			this.val = val;
			next = null;
		}
	}
	public static LinkedNode swap(LinkedNode head, int m, int n) {
		LinkedNode temp1 = null;
		LinkedNode temp2 = null;
		LinkedNode s1 = null;
		LinkedNode prev = new LinkedNode(0);
		prev.next = head;
		//temp = prev;
		s1 = prev;
		LinkedNode s2 = null;
		s2 = prev;
		for(int i = 0; i< m-1; i++)
			s1 = s1.next;
		for(int i = 0; i< n - 1; i++) {
			s2 = s2.next;
		}
		temp1 = s1.next;
		temp2 = s2.next;
		LinkedNode next = temp2.next;
		s1.next = temp2;
		temp2.next = temp1.next;
		s2.next = temp1;
		temp1.next = next;
		return prev.next;
	}
	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(0);
		LinkedNode temp = head;
		for(int i = 1; i< 6; i++) {
			temp.next = new LinkedNode(i);
			temp = temp.next;
		}
		int m = 1;
		int n = 6;
		temp = head;
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.println("");
		System.out.println("swap");
		temp = swap(head,m,n);
		while(temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
	}
}
