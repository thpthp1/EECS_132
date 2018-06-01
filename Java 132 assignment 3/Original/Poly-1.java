/** class that represents the polynomial getOperand()
  * @author <em>Phan Trinh Ha</em>
  * */
public class Poly extends Unary{
  private double power;
  /**
   * constructor that takes the operand amd the power
   * @param operand the operand of any type belonging to calc
   * @param power the power of the polynomial
   * */
  public Poly(Calc operand,double power){
    super(operand);
    this.power = power;
  }
  /**
   * return the String representation of the Sin funct
   * @return in format operand^power or (binaryOp)^power
   * */
  @Override
  public String toString(){
    if((getOperand() instanceof BinaryOp) || (getOperand() instanceof Unary)){// consider to unary or not to unary
      return "("+getOperand().toString()+")^" + getPower();
    }
    else{
      return getOperand().toString()+ "^" + getPower();
    }
  }
  /**
   * return the value of type in number
   * @return double
   * */
  public double value() throws UnsupportedOperationException{
    return Math.pow(getOperand().value(),getPower());
  }
  /**
   * the method that gives the power of the polynomial
   * @return the power of the polynomial
   * */
  public double getPower(){
    return this.power;
  }
  /**
   * return the value of the poly with a variable inside
   * @param input variable value of type double
   * @return value of the poly
   * */
  public double value(double input){
    return Math.pow(getOperand().value(input),getPower());
  }
  /**
   * compare an object to this instance 
   * @param o the object being compared
   * @return equals or not equals
   * */
  @Override
  public boolean equals(Object o){
    if(o instanceof Poly){
      Poly p = (Poly)o;
      return p.getOperand().equals(this.getOperand()) && p.getPower() == this.getPower();
    }
    else return false;
  }
  /**
   * return the derivative of the instance of the polynomial
   * @return the derivative in Calc type, which will be usable in anyother classes' constructor
   * */
  @Override
  public Calc derivative(){
    if(this.getPower() != 0){
      if( this.getOperand() instanceof Variable ){
        return new BinaryOp(BinaryOp.Op.MULT, new Number(this.getPower()), new Poly((Variable)this.getOperand(), this.getPower() -1 ));
      }
      else{
        return new BinaryOp(BinaryOp.Op.MULT, new Number(this.getPower()), new BinaryOp(BinaryOp.Op.MULT, this.getOperand().derivative(), new Poly(this.getOperand(),this.getPower() -1)));
      }
    }
    else{
      return new Number(0);
    }
  }
}
