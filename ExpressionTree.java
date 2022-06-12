public class ExpressionTree {
	public TreeNode root = null; // keeping the expression tree's root.
	/**
	 * building a corresponding expression tree according to a postfix expression.
	 * @param postfix : String, a valid postfix expression.
	 */
	public void BuildExpressionTree(String postfix) {
		if (postfix != "") {// if postfix is an empty string, we want the root node to stay null
		StackAsArray stack = new StackAsArray();
		ExpTokenizer exp = new ExpTokenizer(postfix);
		while (exp.hasMoreElements()) {
			CalcToken token = (CalcToken)exp.nextElement();
			if (token instanceof ValueToken) { // if token is an operand
				TreeNode node = new TreeNode(token); // a new leaf with token
				stack.push(node);
			}
			else if (token instanceof BinaryOp) { // if token is an operator
				TreeNode right = (TreeNode)stack.pop();
				TreeNode left = (TreeNode)stack.pop();
				TreeNode newNode = new TreeNode(token, left, right);
				stack.push(newNode);
			}
		}
		this.root = (TreeNode)stack.pop();
		}
}

}