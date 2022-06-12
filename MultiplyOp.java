public class MultiplyOp extends BinaryOp{
    /**
     * multiply is second in precedence order
     * @return 2
     */
    @Override
    public double getPrecedence() {
        return 2;
    }

    /**
     *
     * @param left the left operand.
     * @param right the right operand.
     * @return returns left times right
     */
    @Override
    public double operate(double left, double right) {
        return left * right;
    }

    /**
     * the sign for multiplication is an asterisk
     * @return *
     */
    @Override
    public String toString() {
        return "*";
    }
}
