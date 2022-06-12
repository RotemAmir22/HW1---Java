public class DivideOp extends BinaryOp{
    /**
     * division is second in preference order
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
     * @return left operand divided by right operand
     */
    @Override
    public double operate(double left, double right) {
        return left/right;
    }

    /**
     * the sight for division is a forward-slash
     * @return /
     */
    @Override
    public String toString() {
        return "/";
    }
}
