package intern;
//然后老印让我写二叉树的定义，树的定义
import java.util.*;
public class BinaryTree {
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	TreeNode root;
	BinaryTree(int val) {
		root = new TreeNode(val);
	}
	BinaryTree(){
		root = null;
	}
	public static int[] badEdge(BinaryTree tree) {
		Set<Integer> set = new HashSet<>();
		int[] ret = new int[2];
		TreeNode node = tree.root;
		//set.add(node.val);
		inorder(node, set, ret);
		return ret;
	}
	public static void inorder(TreeNode node, Set<Integer> set, int[] ret) {
		if(node == null)
			return;
		set.add(node.val);
		if(node.left == null && node.right == null)
			return;
		if(node.right != null) {
			if(set.contains(node.right.val)) {
				ret[0] = node.val;
				ret[1] = node.right.val;
				return;
			}
		}
		if(node.left != null) {
			if(set.contains(node.left.val)) {
				ret[0] = node.val;
				ret[1] = node.left.val;
				return;
			}
		}
//		if(set.contains(node.left.val)) {
//			ret[0] = node.val;
//			ret[1] = node.left.val;
//			return;
//		}
//		if(set.contains(node.right.val)) {
//			ret[0] = node.val;
//			ret[1] = node.right.val;
//			return;
//		}
		inorder(node.left, set, ret);
		inorder(node.right, set, ret);
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(2);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(6);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(5);
		int[] ret = badEdge(tree);
		System.out.print(ret[0] + " " + ret[1]);
	}
}
