/** class that represents the sin operand
  * @author <em>Phan Trinh Ha</em>
  * */
public class Sin extends Unary{
  // example of making the unary available to the other classes, so this would be one of those examples, remove after finish
  
  /**
   * the constructor for the function of sin
   * @param operand the operand of type Calc
   * */
  public Sin(Calc operand){
    super(operand);
  }
  /**
   * return the String representation of the Sin funct
   * @return String representation
   * */
  @Override
  public String toString(){
    return "sin[" + getOperand().toString() + "]";
  }
  
  /**
   * return the value of type in number, value will be interpreted as radians
   * @return double value of the number type 
   * */
  public double value() throws UnsupportedOperationException{
    return Math.sin(getOperand().value());
  }
  
  /**
   * return the value of the sin, with all Variables carrying the value type
   * @param input the input of type double, value interpreted as radians
   * @return sin valueafter replacing variable with the type value
   * */
  public double value(double input){
      return Math.sin(getOperand().value(input));
  }
  
  /**
   * compare an object to this instance
   * @param o the object being compared
   * @return equals or not equals
   * */
  @Override
  public boolean equals(Object o){
    if(o instanceof Sin){
      Sin s = (Sin)o;
      return s.getOperand().equals(this.getOperand());
    }
    else return false;
  }
  
  /**
   * return the derivative of the instance of sin
   * @return the derivative in Calc type, which will be usable in anyother classes' constructor
   * */
  @Override
  public Calc derivative(){
    if(this.getOperand() instanceof Variable){// added function
      return new Cos(this.getOperand());
    }
    else{
    return new BinaryOp(BinaryOp.Op.MULT, this.getOperand().derivative(), new Cos(this.getOperand()));
    }
  }
}

  