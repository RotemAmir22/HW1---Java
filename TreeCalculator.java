
public class TreeCalculator extends Calculator{
	private TreeNode e_tree_root = null; // in order to save the root of the corresponding expression tree.
	
	/**
	 * a helper function that evaluates the postfix expression with the expression tree.
	 * @param node : TreeNode, a pointer to the root node in the expression tree.
	 * @return the value of the tree's expression.
	 */
	private double wrapperEvaluateExpression(TreeNode node){
		double result;
		if (node.data instanceof BinaryOp){ // if the node contains an operator. 
			double operand1 = wrapperEvaluateExpression(node.left);
			double operand2 = wrapperEvaluateExpression(node.right);
			result = ((BinaryOp)node.data).operate(operand1, operand2);
		}
		else { // if the node contains an operand
			 result = ((ValueToken)node.data).getValue();
		}
		return result;
	}
	
	/**builds a corresponding expression tree and evaluates a postfix expression.
     * @param expr : a string representing a valid postfix expression.
     * @return computed numerical value of expr.
	 */
	public double evaluate(String expr){
		ExpressionTree e_tree = new ExpressionTree();
		e_tree.BuildExpressionTree(expr); // building the corresponding expression tree.
		this.e_tree_root = e_tree.root; 
		TreeNode tmp_root = this.e_tree_root;
		if (tmp_root == null) {
			return 0.0;
		}
		return wrapperEvaluateExpression(tmp_root);
	}
	
	/**a helper function that scans by inorder scan the expression tree and returns an infix expression of the tree.
	 * @param node : a pointer to a node in the expression tree.
	 * @return a String representing the infix expression of the tree.
	 */
	private String inorderScan(TreeNode node) {
		if (!node.isLeaf()) { //if node is leaf, it has to be a value token. Else, it's an operator.
			return "( "+ (String)inorderScan(node.left) + ((CalcToken)node.data).toString() + " " + (String)inorderScan(node.right)+ ") " ;
			}
		else {
			return ((CalcToken)node.data).toString() + " ";
		}
	}
	
	/**returns an infix expression using a helper function.
	 * @return String: an infix expression.
	 */
	public String getInfix(){
		TreeNode tmp_node = e_tree_root;
		if (tmp_node == null) {
			return "";
		}
		String str_infix_scan = (String)inorderScan(tmp_node);
		return str_infix_scan.substring(0,str_infix_scan.length()-1);				
	}
	
	/** a helper function that scans by postorder scan the expression tree and returns a postfix expression of the tree.
	 * @param node : a pointer to a node in the expression tree.
	 * @return a String representing the postorder expression of the tree.
	 */
	private String PostfixScan(TreeNode node) {
		if (!node.isLeaf()) {
			return (String)PostfixScan(node.left) + (String)PostfixScan(node.right) + ((CalcToken)node.data).toString() + " ";
			}
		else {
			return ((CalcToken)node.data).toString() + " ";
		}
	}
	
	/**returns a postfix expression using a helper function.
	 * @return String: a postfix expression.
	 */
	public String getPostfix() {
		TreeNode tmp_node = e_tree_root;
		if (tmp_node == null) {
			return "";
		}
		String str_postfix_scan = (String)PostfixScan(tmp_node);
		return str_postfix_scan.substring(0,str_postfix_scan.length()-1);
	}
	
	/** a helper function that scans by preorder scan the expression tree and returns a prefix expression of the tree.
	 * @param node : a pointer to a node in the expression tree.
	 * @return a String representing the preorder expression of the tree.
	 */
	public String PrefixScan(TreeNode node) {
		if (!node.isLeaf()) {
			return ((CalcToken)node.data).toString() + " " + (String)PrefixScan(node.left) + (String)PrefixScan(node.right);
			}
		else {
			return ((CalcToken)node.data).toString() + " ";
		}
	}
	
	/**returns a prefix expression using a helper function.
	 * @return String: a prefix expression.
	 */
	public String getPrefix() {
		TreeNode tmp_node = e_tree_root;
		if (tmp_node == null) {
			return "";
		}
		String str_prefix_scan = (String)PrefixScan(tmp_node);
		return str_prefix_scan.substring(0,str_prefix_scan.length()-1);
	}
	

}
