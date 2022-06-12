public class StackCalculator extends Calculator{
    /**
     * evaluates the expressions summary
     * @param expr valid postfix expression
     * @return double number
     */
    @Override
    public double evaluate(String expr) {
        if (expr.equals("")){return 0.0;} //if empty returns 0.0
        StackAsArray stack = new StackAsArray();
        ExpTokenizer input = new ExpTokenizer(expr) ;
        while (input.hasMoreElements()){ //not empty
            CalcToken token = (CalcToken) input.nextElement();
            if (token instanceof BinaryOp && !stack.isEmpty()){ //token is an operator
               ValueToken right = (ValueToken) stack.pop();
               ValueToken left = (ValueToken) stack.pop();
               stack.push(new ValueToken(((BinaryOp) token).operate(left.getValue(),right.getValue())));
            }
            else{ //token is a number
                stack.push(token);
            }
        }
        return ((ValueToken) stack.pop()).getValue();
    }

    /**
     * Converts infix expression to postfix
     * @param infix string with infix expression
     * @return expression in postfix
     */
    public String infixToPostfix(String infix){
        if (infix.equals("")){return infix;} //if empty
        StringBuilder str = new StringBuilder();
        StackAsArray stack = new StackAsArray();
        ExpTokenizer input = new ExpTokenizer(infix) ;
        while (input.hasMoreElements()) {
            CalcToken token = (CalcToken) input.nextElement();
            if (token instanceof OpenBracket){
                stack.push(token);
            }
            else if (token instanceof CloseBracket){
                Object temp = stack.pop();
                while (!(temp instanceof OpenBracket)){ // sub-expression in brackets
                    str.append(temp).append(" ");
                    if (stack.isEmpty()){break;} // cannot pop from an empty stack
                    temp = stack.pop();
                }
            }
            else if (token instanceof BinaryOp){
                if (!stack.isEmpty()) {
                    CalcToken fromStack = (CalcToken) stack.pop();
                    if (fromStack instanceof OpenBracket || fromStack instanceof CloseBracket){
                        stack.push(fromStack);
                    }
                    else {
                        while (((BinaryOp) fromStack).getPrecedence() <= ((BinaryOp) token).getPrecedence()) { // check precedence of operation
                            str.append(fromStack).append(" ");
                            fromStack = (CalcToken) stack.pop();
                            if (fromStack instanceof OpenBracket||fromStack instanceof CloseBracket || fromStack == null) { // end of sub-expression in brackets
                                break;
                            }

                        }
                        if (fromStack != null){stack.push(fromStack);}
                    }
                }
               stack.push(token);
        }
            else {
                str.append(token).append(" "); // add numbers to string
            }
        }
            while (!stack.isEmpty()){
                str.append(stack.pop().toString()).append(" "); //empty stack
            }

        return str.substring(0,str.length()-1); //remove extra space
    }

}
