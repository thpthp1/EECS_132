/** class that represents the ln()
  * @author <em>Phan Trinh Ha</em>
  * */
public class Log extends Unary{
  
    /** the constructor of the Unary function ln()
    * @param operand the operand to be put inside
    * */
  public Log(Calc operand){
    super(operand);
  }
  /**
   * return the String representation of the Sin funct
   * @return String
   * */
  @Override
  public String toString(){
    return "log[" + getOperand().toString() + "]";
  }
  /**
   * return the value of type in number
   * @return double
   * */
  public double value() throws UnsupportedOperationException{
    return Math.log(getOperand().value());
  }
  /**
   * return the casted value of the log type
   * @param input the input in double type
   * @return the value of the log, after replacing var with a value
   * */
  public double value(double input){
      return Math.log(getOperand().value(input));
  }
  /**
   * compare the object to the instance of log type
   * @param o the object being compared
   * @return equal or not equals
   * */
  public boolean equals(Object o){
    if(o instanceof Log){
      Log l = (Log)o;
      return l.getOperand().equals(this.getOperand());
    }
    else return false;
  }
   /**
   * return the derivative of the instance of the natrual logarithmic function
   * @return the derivative in Calc type, which will be usable in anyother classes' constructor
   * */
  @Override 
  public Calc derivative(){
    if(this.getOperand() instanceof Variable){
      return new BinaryOp(BinaryOp.Op.DIV, new Number(1), this.getOperand());
    }
    else{
    return new BinaryOp(BinaryOp.Op.MULT, this.getOperand().derivative(), new BinaryOp(BinaryOp.Op.DIV, new Number(1), this.getOperand()));
    }
  }
}
