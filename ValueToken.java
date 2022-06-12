public class ValueToken extends CalcToken{
    private double val;

    /**
     * constructor of ValueToken, inherits from CalcToken
     * @param val - number the token represents
     */
    public ValueToken(double val){
        super();
        this.val = val;
    }

    /**
     * val is private
     * @return value of token (val)
     */
    public double getValue(){
        return val;
    }

    /**
     *
     * @return string version of val
     */
    @Override
    public String toString() {
        return ""+val+"";
    }
}
