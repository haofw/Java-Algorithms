package intern;
import java.util.*;
//给一个树 根节点Node root
//			＊
//		／  		\
//		+   		  -
//	  /  \  		 /  \
//   1  	  2  	3 	 4
//返回(1+2)＊(3－4).
//如果（1+2）＋（3＋4）不用去括号
//只有叶结点才是数字
public class CalculateTree {
	interface Node {
        Node getLeft();
        Node getRight();
        String toString();
	}
	static class TreeNode implements Node{
		String val;
		TreeNode left;
		TreeNode right;
		public TreeNode(String s) {
			val = s;
			left = null;
			right = null;
		}
		@Override
		public TreeNode getLeft() {
			// TODO Auto-generated method stub
			
			return left;
		}

		@Override
		public TreeNode getRight() {
			// TODO Auto-generated method stub
			return right;
		}
		
		@Override
		public String toString() {
			return val;
		}
	}
	public static String calT(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sd = new StringBuilder();
		StringBuilder ret = new StringBuilder();
		inorder(root.left, sb);
		inorder(root.right, sd);
		ret.append(sb);
		ret.append(root.toString());
		ret.append(sd);
		return ret.toString();
	}
	public static void inorder (TreeNode root, StringBuilder sb) {
		if(root == null)
			return;
		if(root.getLeft() == null && root.getRight() == null) {
//			sb.append('(');
			sb.append(root.toString());
			return;
		}
		//StringBuilder ret = new StringBuilder();
		//ret.append("(");
		sb.append('(');
		inorder(root.getLeft(), sb);
		sb.append(root.toString());
		inorder(root.getRight(),sb);
		sb.append(')');
		//ret.append(sb);
		//ret.append(")");//string or char
		//sb = ret;
	}
	//给你＊＋12-34 把这个树返回了
	//preorder
	public static TreeNode returnT(String s) {
//		TreeNode root = new TreeNode(String.valueOf(s.charAt(0)));
//		TreeNode node = root;
//		
		List<String> ret = new ArrayList<>();
		for(int i = 0; i< s.length(); i++) {
			ret.add(String.valueOf(s.charAt(i)));
		}
		return pre(ret);
	}
	public static TreeNode pre(List<String> ret) {
		String ele = ret.get(0);
		ret.remove(ele);
		if(Character.isDigit(ele.charAt(0))) {
			return new TreeNode(ele);
		}
		TreeNode node = new TreeNode(ele);
		node.left = pre(ret);
		node.right = pre(ret);
		//*+34-56
		return node;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode("*");
		root.left = new TreeNode("+");
		root.right = new TreeNode("-");
		root.left.left = new TreeNode("1");
		root.left.right = new TreeNode("2");
		root.right.left = new TreeNode("3");
		root.right.right = new TreeNode("4");
		System.out.println(calT(root));
		String s = "*+34-56";
		TreeNode ret = returnT(s);
		System.out.println(calT(ret));
	}
}
