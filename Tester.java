/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester { 

	private static boolean testPassed = true;
	private static int testNum = 0;
	
	/**
	 * This entry function will test all classes created in this assignment.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
	
	/* TODO - write a function for each class */
	// Each function here should test a different class. You should test ExpTokenizer as well.

	// ExpTokenizer
		testExpTokenizer();
		//...

	//CalcTokens
		testOpenBracket();
		testCloseBracket();
		//...

	//BinaryOp
		testAddOp();
		testSubtractOp();
		testMultiplyOp();
		testDivideOp();
		testPowOp();
		//...

	//Calculators
		testStackCalculator();
		testTreeCalculator();
		//...
		
		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}

	/**
	 * This utility function will count the number of times it was invoked. 
	 * In addition, if a test fails the function will print the error message.  
	 * @param exp The actual test condition
	 * @param msg An error message, will be printed to the screen in case the test fails.
	 */
	private static void test(boolean exp, String msg) {
		testNum++;
		
		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}

	/**
	 * Checks the ExpTokenizer class
	 */
	private static void testExpTokenizer(){
		ExpTokenizer et = new ExpTokenizer("2.0 4.0 ^");
		test(et.hasMoreElements(),"The ExpTokenizer has more elements");
		test(et.countTokens()== 3,"The expression should have 3 tokens");
		test(et.nextToken().equals("2.0"), "The next token should be 2.0");
		et.nextToken();
		test(et.nextElement()instanceof PowOp,"The next element should be ^");
	}
	/**
	 * Checks OpenBrackets class
	 */
	private static void testOpenBracket(){
		OpenBracket ob = new OpenBracket();
		test(ob.toString().equals("("), "The string ( should be printed");
	}

	/**
	 * Checks CloseBrackets class
	 */
	private static void testCloseBracket(){
		CloseBracket oc = new CloseBracket();
		test(oc.toString().equals(")"), "The string ) should be printed");
	}
	/**
	 * Checks the AddOp class.
	 */
	private static void testAddOp() {
		AddOp op = new AddOp();
		test((op.toString().equals("+")), "The string + should be printed.");
		test((op.operate(1.0 , 2.5) == 3.5), "The answer should be 3.5 .");
		test((op.operate(-11.0 , 5.75) == -5.25), "The answer should be -5.25 .");
	}
	/**
	 * Checks the SubtractOp class.
	 */
	private static void testSubtractOp() {
		SubtractOp op = new SubtractOp();
		test((op.toString().equals("-")), "The string - should be printed.");
		test((op.operate(1.5 , 5.0) == -3.5), "The answer should be -3.5 .");
		test((op.operate(8.0 , -5.0) == 13.0), "The answer should be 13.0 .");
	}
	/**
	 * Checks the MultiplyOp class.
	 */
	private static void testMultiplyOp() {
		MultiplyOp op = new MultiplyOp();
		test((op.toString().equals("*")), "The string * should be printed.");
		test((op.operate(12.0 , 2.5) == 30.0), "The answer should be 30.0 .");
		test((op.operate(-3.5 , 2.5) == -8.75), "The answer should be -8.75 .");
	}
	/**
	 * Checks the DivideOp class.
	 */
	private static void testDivideOp() {
		DivideOp op = new DivideOp();
		test((op.toString().equals("/")), "The string / should be printed.");
		test((op.operate(12.0 , 3.0) == 4.0), "The answer should be 4.0 .");
		test((op.operate(5.0 , -2.5) == -2.0), "The answer should be -2.0 .");
	}
	/**
	 * Checks the PowOp class.
	 */
	private static void testPowOp() {
		PowOp op = new PowOp();
		test((op.toString().equals("^")), "The string ^ should be printed.");
		test((op.operate(1.0 , 2.0) == 1.0), "The answer should be 1.0 .");
		test((op.operate(13.0 , 0.0) == 1.0), "The answer should be 1.0 .");
		test((op.operate(-3.0 , 2.0) == 9.0), "The answer should be 9.0 .");
	}
	/**
	 * Checks the StackCalculator class.
	 */
	private static void testStackCalculator() {

		StackCalculator pc = new StackCalculator();

		//Addition
		String postExp1 = pc.infixToPostfix("2 + 3");
		test(postExp1.equals("2.0 3.0 +") , "The output of \"2 3 -\" should be  2.0 3.0 +");
		double result1 = pc.evaluate(postExp1);
		test(result1 ==  5.0, "The output of \"2 3 -\" should be 5.0");

		//Power
		String postExp2 = pc.infixToPostfix("2 ^ 3");
		test(postExp2.equals("2.0 3.0 ^") , "The output of \"2 3 -\" should be  2.0 3.0 ^");
		double result2 = pc.evaluate(postExp2);
		test(result2 ==  8.0, "The output of \"2 3 -\" should be 8.0");

		//More than one Power
		String postExp3 = pc.infixToPostfix("2 ^ 2 ^ 3");
		test(postExp3.equals("2.0 2.0 ^ 3.0 ^") , "The output of \"2 2 3 -\" should be  2.0 2.0 ^ 3.0 ^");
		double result3 = pc.evaluate(postExp3);
		test(result3 ==  64.0, "The output of \"2 3 -\" should be 64.0");

		//Negative Numbers and Division
		String postExp4 = pc.infixToPostfix("-16 / 4.5");
		test(postExp4.equals("-16.0 4.5 /") , "The output of \"-16 4.5 -\" should be  -16.0 4.5 /");
		double result4 = pc.evaluate(postExp4);
		test(result4 ==  -3.5555555555555554, "The output of \"-16 4.5 -\" should be -3.5555555555555554");

		//Brackets
		String postExp5 = pc.infixToPostfix("( 2 + 15 ) * ( 12 - 7 ) / -2");
		test(postExp5.equals("2.0 15.0 + 12.0 7.0 - * -2.0 /") , "The output of \"2 15 12 7 -2 -\" should be  2.0 15.0 + 12.0 7.0 - * -2.0 /");
		double result5 = pc.evaluate(postExp5);
		test(result5 ==  -42.5, "The output of \"2 15 12 7 -2 -\" should be -42.5");

		//Negative Power
		String postExp6 = pc.infixToPostfix("4.5 ^ -2 ^ 6");
		test(postExp6.equals("4.5 -2.0 ^ 6.0 ^") , "The output of \"4.5 -2 6 -\" should be  4.5 -2.0 ^ 6.0 ^");
		double result6 = pc.evaluate(postExp6);
		test(result6 ==  1.450273243738992E-8, "The output of \"2 3 -\" should be 1.450273243738992E-8");

		//Test Precedence
		String postExp7 = pc.infixToPostfix("4 ^ 3 ^ -2 + 100 ^ 0");
		test(postExp7.equals("4.0 3.0 ^ -2.0 ^ 100.0 0.0 ^ +") , "The output of \"4 3 2 100 0 -\" should be  4.0 3.0 ^ -2.0 ^ 100.0 0.0 ^ +");
		double result7 = pc.evaluate(postExp7);
		test(result7 == 1.000244140625, "The output of \"4 3 2 100 0 -\" should be  1.000244140625");

		//Empty Expression
		String postExp8 = pc.infixToPostfix("");
		test(postExp8.equals(""), "The output of \"-\" should be");
		double result8 = pc.evaluate(postExp8);
		test(result8 == 0.0, "The output of \"-\" should be  0.0");
	}

	/**
	 * Checks the TreeCalculator class.
	 */
	private static void testTreeCalculator(){
		TreeCalculator tc = new TreeCalculator();

		double result1 = tc.evaluate("2 3 +");
		test(result1 == 5.0, "The output of \"2 3 -\" should be 5.0");
		//Infix
		test(tc.getInfix().equals("( 2.0 + 3.0 )"),"The output of \"2 3 -\" should be (2.0 + 3.0)");
		//Postfix
		test(tc.getPostfix().equals("2.0 3.0 +"),"The output of \"2 3 -\" should be 2.0 3.0 +");
		//Prefix
		test(tc.getPrefix().equals("+ 2.0 3.0"),"The output of \"2 3 -\" should be + 2.0 3.0");

		double result2 = tc.evaluate("6 2 3 + ^");
		test(result2 == 7776.0, "The output of \"6 2 3 -\" should be 7776.0");
		//Infix
		test(tc.getInfix().equals("( 6.0 ^ ( 2.0 + 3.0 ) )"),"The output of \"6 2 3 -\" should be (6.0 - (2.0 + 3.0))");
		//Postfix
		test(tc.getPostfix().equals("6.0 2.0 3.0 + ^"),"The output of \"6 2 3 -\" should be 6.0 2.0 3.0 + ^");
		//Prefix
		test(tc.getPrefix().equals("^ 6.0 + 2.0 3.0"),"The output of \"6 2 3 -\" should be ^ 6.0 + 2.0 3.0");

		double result4 = tc.evaluate("4 1 2 + 2 2 3 ^ ^ * -");
		test(tc.getPostfix().equals("4.0 1.0 2.0 + 2.0 2.0 3.0 ^ ^ * -"),"the output should be : 4.0 1.0 2.0 + 2.0 2.0 ^ 3.0 ^ * -");
		test(result4 == -764.0, "The output should be -764.0");

		double result5 = tc.evaluate("4 3 -2 ^ ^ 100 0 ^ +");
		test(tc.getPostfix().equals("4.0 3.0 -2.0 ^ ^ 100.0 0.0 ^ +"),"the output should be : 4.0 3.0 -2.0 ^ ^ 100.0 0.0 ^ +");
		test(tc.getInfix().equals("( ( 4.0 ^ ( 3.0 ^ -2.0 ) ) + ( 100.0 ^ 0.0 ) )"),"the output should be :( ( 4.0 ^ ( 3.0 ^ -2.0 ) ) + ( 100.0 ^ 0.0 ) )");
		test(tc.getPrefix().equals("+ ^ 4.0 ^ 3.0 -2.0 ^ 100.0 0.0"),"the output should be : + ^ 4.0 ^ 3.0 -2.0 ^ 100.0 0.0");
		test(result5 == 2.1665290395761163, "The output should be 2.1665290395761163");

		/**
		in order to check if we built a correct corresponding expression tree, we'll build a new expression tree,
		according to a postfix expression. If the postfix scanning returns the same expression, meaning the expression tree is correct.
		** in the evaluate method we call the buildExpressionTree method.
		*/

		double result6 = tc.evaluate("4 2 3 * + 9 -");
		test(tc.getPostfix().equals("4.0 2.0 3.0 * + 9.0 -"),"the output should be : 4.0 2.0 3.0 * + 9.0 -");

		//empty string
		double result7 = tc.evaluate("");
		test(tc.getInfix().equals(""),"the output should be :");

	}


}