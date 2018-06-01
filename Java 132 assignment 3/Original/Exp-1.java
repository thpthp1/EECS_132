/** class that represents the exponent (e^x) getOperand()
  * @author <em>Phan Trinh Ha</em>
  * */
public class Exp extends Unary{
  
  /** 
   * the constructor of the function of type exponent e^x
   * @param operand operand of Calc type
   * */
  public Exp(Calc operand){
    super(operand);
  }
  
  /**
   * return the String representation of the exp funct
   * @return String
   * */
  @Override
  public String toString(){
    return "EXP[" + getOperand().toString() + "]";
  }
  
  /**
   * return the value of type in number
   * @return double
   * */
  @Override
  public double value() throws UnsupportedOperationException{
    return Math.exp(getOperand().value());
  }
  
  /**
   * return the value of assigned x
   * @param input double input
   * @return double
   * */
  @Override
  public double value(double input){
    return Math.exp(getOperand().value(input));
  }
  /**
   * compare the object with the instance
   * @param o the object being compared
   * @return equal or not equal
   * */
  @Override
  public boolean equals(Object o){
    if(o instanceof Exp){
      Exp e = (Exp)o;
      return e.getOperand().equals(this.getOperand());
    }
    else return false;
  }
  
   /**
   * return the derivative of the instance of exponent
   * @return the derivative in Calc type, which will be usable in anyother classes' constructor
   * */
  @Override
  public Calc derivative(){
    if(this.getOperand() instanceof Variable){
      return this;
    }
    else{
    return new BinaryOp(BinaryOp.Op.MULT, this.getOperand().derivative(), this);
    }
  }
  
}
