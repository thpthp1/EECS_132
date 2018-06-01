/** class that represents the cos operand
  * @author <em>Phan Trinh Ha</em>
  * */
public class Cos extends Unary{
  
  /** the constructor of the Unary function cosine
    * @param operand the operand to be put inside
    * */
  public Cos(Calc operand){
    super(operand);
  }
  
  /**
   * return the String representation of the Sin funct
   * @return String
   * */
  @Override
  public String toString(){
    return "cos[" + getOperand().toString() + "]";
  }
  
  /**
   * return the value of type in number
   * @return the value of the function that contain anything but 
   * */
  public double value() throws UnsupportedOperationException{
    return Math.cos(getOperand().value());
  }
  
  /**
   * return the value of the function with an input
   * @param input the value of variable x
   * @return the value of the function with the value of x = input
   * */
  public double value(double input){
      return Math.cos(getOperand().value(input));
  }
  
  /**
   * return the derivative of the cosine, if the operand is a variable, this will return only a -1.0*cos[x]
   * else, the method will derive the whole operand inside
   * @return the object of type Calc, which will be usable in anyother classes constructor
   * */
  public Calc derivative(){
    if(this.getOperand() instanceof Variable){
      return new BinaryOp(BinaryOp.Op.MULT,new Number(-1),new Sin(this.getOperand()));
    }
    else{
      return new BinaryOp(BinaryOp.Op.MULT,new Number(-1),new BinaryOp(BinaryOp.Op.MULT,this.getOperand().derivative(),new Sin(this.getOperand())));
    }
  }
  
    /**
   * compare between the two objects
   * @param o the object that is being compared
   * @return true or false
   * */
  public boolean equals(Object o){
    if(o instanceof Cos){
      Cos c = (Cos)o;
      return c.getOperand().equals(this.getOperand());
    }
    else return false;
  }
  
}

  