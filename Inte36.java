package intern;
import java.util.*;
//给一棵树（不一定是二叉树）和一个节点（保证存在），按层次遍历顺序查询该节点的上一个节点，每层第一个节点的上一个节点规定为NULL。
//Follow up1：经常查询的话如何优化
//Follow up2：给定父节点，如何支持插入操作
public class Inte36 {
	static class TreeNode{
		List<TreeNode> chil;
		int val;
		public TreeNode(int val) {
			chil = new ArrayList<>();
			this.val = val;
		}
	}
	public static TreeNode getPre(TreeNode root, TreeNode target) {
		Queue<TreeNode> layer = new LinkedList<>();
		//HashMap<TreeNode,TreeNode> map = new HashMap<>();
		if(root == null)
			return null;
		layer.offer(root);
		//TreeNode pre = null;
		if(root.equals(target))
			return null;
		TreeNode pre = null;
		TreeNode next = null;
		//1   2345    67890
		while(!layer.isEmpty()) {
			int size = layer.size();
			for(int iter = 0; iter < size; iter ++) {
				pre = iter == 0? null: next;
				next = layer.poll();
				//map.put(next, pre);
				if(next.equals(target))
					return pre;
				for(int i = 0; i< next.chil.size(); i++) {
					layer.offer(next.chil.get(i));
				}
			}
		}	
		return null;
	}
	public static TreeNode addNode(TreeNode root, TreeNode father, TreeNode insert) {
		Queue<TreeNode> layer = new LinkedList<>();
		//HashMap<TreeNode,TreeNode> map = new HashMap<>();
		if(root == null)
			return null;
		layer.offer(root);
		//TreeNode pre = null;
//		if(root.equals(target))
//			return null;
		TreeNode son = null;
		TreeNode fa = null;
		//1   2345    67890
		while(!layer.isEmpty()) {
			int size = layer.size();
			for(int iter = 0; iter < size; iter ++) {
				fa = son;
				son = layer.poll();
				//map.put(next, pre);
				if(fa.equals(father)) {
					fa.chil.add(insert);
					return root;
				}
				for(int i = 0; i< son.chil.size(); i++) {
					layer.offer(son.chil.get(i));
				}
			}
		}	
		return null;
	}
	public static List<TreeNode> getPre(TreeNode root, List<TreeNode> target) {
		Queue<TreeNode> layer = new LinkedList<>();
		HashMap<TreeNode,TreeNode> map = new HashMap<>();
		if(root == null)
			return null;
		layer.offer(root);
		//TreeNode pre = null;
//		if(root.equals(target))
//			return null;
		TreeNode pre = null;
		TreeNode next = null;
		//1   2345    67890
		while(!layer.isEmpty()) {
			int size = layer.size();
			for(int iter = 0; iter < size; iter ++) {
				pre = iter == 0? null: next;
				next = layer.poll();
				map.put(next, pre);
//				if(next.equals(target))
//					return pre;
				for(int i = 0; i< next.chil.size(); i++) {
					layer.offer(next.chil.get(i));
				}
			}
		}
		List<TreeNode> ret = new ArrayList<>();
		for(int i = 0; i< target.size(); i++) {
			ret.add(map.get(target.get(i)));
		}
		return ret;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode r1 = new TreeNode(2);
		TreeNode r2 = new TreeNode(3);
		TreeNode r3 = new TreeNode(4);
		TreeNode r4 = new TreeNode(5);
		TreeNode r11 = new TreeNode(6);
		TreeNode r12 = new TreeNode(7);
		TreeNode r13 = new TreeNode(8);
		TreeNode r14 = new TreeNode(9);
		TreeNode r21 = new TreeNode(10);
		TreeNode r22 = new TreeNode(11);
		TreeNode r23 = new TreeNode(12);
		TreeNode r31 = new TreeNode(13);
		TreeNode r41 = new TreeNode(14);
		TreeNode[] ch1 = {r1,r2,r3,r4};
		List<TreeNode> c = Arrays.asList(ch1);
		root.chil = c;
		TreeNode[] ch2 = {r11,r12,r13,r14};
		TreeNode[] ch3 = {r21,r22,r23};
		TreeNode[] ch4 = {r31};
		TreeNode[] ch5 = {r41};
		List<TreeNode> c1 = Arrays.asList(ch2);
		List<TreeNode> c2 = Arrays.asList(ch3);
		List<TreeNode> c3 = Arrays.asList(ch4);
		List<TreeNode> c4 = Arrays.asList(ch5);
		r1.chil = c1;
		r2.chil = c2;
		r3.chil = c3;
		r4.chil = c4;
		TreeNode targe = r12;
		TreeNode ret = getPre(root, targe);
		System.out.println(ret == null ? 0 : ret.val);
		List<TreeNode> target = new ArrayList<TreeNode>();
		target.add(r1);
		target.add(r3);
		target.add(r4);
		target.add(r11);
		target.add(r13);
		target.add(r23);
		target.add(r31);
		target.add(r41);
		List<TreeNode> re = getPre(root,target);
		for(int i = 0; i<re.size(); i++)
			System.out.print((re.get(i) == null ? 0 : re.get(i).val) + " ");
	}
	
}
