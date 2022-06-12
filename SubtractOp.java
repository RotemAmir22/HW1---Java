public class SubtractOp extends BinaryOp{
    /**
     * subtraction is 3rd in precedence order
     * @return 3
     */
    @Override
    public double getPrecedence() {
        return 3;
    }

    /**
     *
     * @param left the left operand.
     * @param right the right operand.
     * @return the subtraction of left minus right
     */
    @Override
    public double operate(double left, double right) {
        return left - right;
    }

    /**
     * the sign for subtraction is a hyphen
     * @return -
     */
    @Override
    public String toString() {
        return "-";
    }
}
