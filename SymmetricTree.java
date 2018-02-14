package intern;
import java.util.*;
public class SymmetricTree {
	static class TreeNode{
		int val;
		List<TreeNode> children;
		public TreeNode(int val) {
			this.val = val;
			children = new ArrayList<>();
		}
	}
	
	public boolean isSymmetric(TreeNode root) {
		List<TreeNode> chil = root.children;
		if(chil.size() == 0)
			return true;
		if(chil.size() % 2 != 0) {
			//判断中间的那个是不是完全相等的
			if(!isSymmetric(root.children.get(chil.size() / 2)))
				return false;
		}
		//List<TreeNode> left = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		for(int i = 0; i< chil.size()/2; i++) {
			stack.push(chil.get(i));
			stack.push(chil.get(chil.size() - i - 1));
		}
		while(!stack.isEmpty()) {
			TreeNode left = stack.pop();
			TreeNode right = stack.pop();
			if(left == null && right == null)
				continue;
			if(left == null || right == null || right.val != left.val)
				return false;
			if(left.children.size() != right.children.size())
				return false;
			for(int i = 0; i< left.children.size(); i++) {
				stack.push(left.children.get(i));
				stack.push(right.children.get(left.children.size() - 1 - i));
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.print(null == null);
	}
}
