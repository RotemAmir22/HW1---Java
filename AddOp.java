public class AddOp extends BinaryOp{
    /**
     *
     * @param left the left operand.
     * @param right the right operand.
     * @return sum of left and right operands
     */
    @Override
    public double operate(double left,double right){
        return left+right;
    }

    /**
     * the sum operator is 3rd in precedence order
     * @return 3
     */
    @Override
    public double getPrecedence() {
        return 3;
    }

    /**
     * Add sign is plus
     * @return +
     */
    @Override
    public String toString() {
        return "+";
    }
}
