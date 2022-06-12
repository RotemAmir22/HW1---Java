public class PowOp extends BinaryOp{

    /**
     * power is first in preference order
     * @return 1
     */
    @Override
    public double getPrecedence() {
        return 1;
    }

    /**
     *
     * @param left the left operand.
     * @param right the right operand.
     * @return left to the power of right
     */
    @Override
    public double operate(double left, double right) {
        return Math.pow(left, right);
    }

    /**
     * the sign for power is a circumflex
     * @return
     */
    @Override
    public String toString() {
        return "^";
    }
}
