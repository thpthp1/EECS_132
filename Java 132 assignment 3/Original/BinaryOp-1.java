/**
 * This class represents the binary operation
 * @author <em>Phan Trinh Ha</em>
 * */
public class BinaryOp extends Calc{
  /**
   *  Operators that can be used
   *  PLUS
   *  MINUS
   *  MULT
   *  DIV
   */
  enum Op{
    PLUS("+"),MINUS("-"),MULT("*"),DIV("/");
    
    private String operator;// the operator's string representation
    /** 
     * the constructor of the operator
     * @param operator the operator in String type
     * */
    private Op(String operator){
      this.operator = operator;
    }
    /**
     * method that return the string representation of the operator
     * @return the String representation
     * */
    @Override
    public String toString(){
      return this.operator;
    }
  }
  
  private Op operator;
  private Calc leftOp;
  private Calc rightOp;
  
  /**
   * The constructor of the BinaryOp type
   * @param operator the operator of type Op
   * @param leftOp the left operand of type Calc
   * @param rightOp the right operand of type Calc
   * */
  public BinaryOp(Op operator, Calc leftOp, Calc rightOp){
    super();
    this.leftOp = leftOp;
    this.rightOp = rightOp;
    this.operator = operator;
  }
  
  /**
   * get the operator
   * @return Op
   * */
  public Op getOperator(){
    return this.operator;
  }
  
  /**
   * get the left operand
   * @return Variable
   * */
  public Calc getLeftOperand(){
    return this.leftOp;
  }
  
  /** get the right operand
    * @return Variable
    * */
  public Calc getRightOperand(){
    return this.rightOp;
  }
  
  /**
   * Return the string of the Binary operation
   * @return String representation
   * */
  @Override
  public String toString(){
    if((getLeftOperand() instanceof BinaryOp) && (getRightOperand() instanceof BinaryOp)){
      return "("+getLeftOperand().toString() +") "+ getOperator().toString() + " (" + getRightOperand().toString() + ")";
    }
    if((getLeftOperand() instanceof BinaryOp) && !(getRightOperand() instanceof BinaryOp)){
      return "("+getLeftOperand().toString() +") "+ getOperator().toString() + " " + getRightOperand().toString();
    }
    if(!(getLeftOperand() instanceof BinaryOp) && (getRightOperand() instanceof BinaryOp)){
      return  getLeftOperand().toString() +" "+ getOperator().toString() + " (" + getRightOperand().toString() + ")";
    }
    else{
      return getLeftOperand().toString() +" "+ getOperator().toString() + " " + getRightOperand().toString();
    }
  }
  
  /** 
   * return the value of the calculation, if there is no variables
   * throw exception if there is a variable
   * @return the value in type double
   * */
  @Override 
  public double value() throws UnsupportedOperationException{
    double output = 0;
    switch(getOperator()){
      case PLUS: 
        output = getLeftOperand().value() + getRightOperand().value();
        break;
      case MINUS:
        output = getLeftOperand().value() - getRightOperand().value();
        break;
      case MULT:
        output = getLeftOperand().value()*getRightOperand().value();
        break;
      case DIV:
        output = getLeftOperand().value()/getRightOperand().value();
        break; 
    }
    return output;
  }
  
  /**
   * return the value of the function, with every variable replaced to the value of the input
   * @param input the doubel to replace
   * @return the value of the function
   * */
  @Override 
  public double value(double input){
    double output = 0;
    switch(getOperator()){
      case PLUS: 
        output = getLeftOperand().value(input) + getRightOperand().value(input);
        break;
      case MINUS:
        output = getLeftOperand().value(input) - getRightOperand().value(input);
        break;
      case MULT:
        output = getLeftOperand().value(input)*getRightOperand().value(input);
        break;
      case DIV:
        output = getLeftOperand().value(input)/getRightOperand().value(input);
        break; 
    }
    return output;
  }
  /**
   * compare an object to the current instance of type BinaryOp
   * @param o the object being compared to
   * @return equal if operands 
   * */
  @Override
  public boolean equals(Object o){
    if(o instanceof BinaryOp){
      BinaryOp b = (BinaryOp)o;
      switch(b.getOperator()){
      case PLUS:
      case MULT: 
      if(b.getRightOperand().equals(this.getRightOperand())){
        return b.getOperator().equals(this.getOperator()) && b.getLeftOperand().equals(this.getLeftOperand());
      }
      else{
        if(b.getRightOperand().equals(this.getLeftOperand())){
          return b.getOperator().equals(this.getOperator()) && b.getLeftOperand().equals(this.getRightOperand());
        }
      }
      case DIV:
      case MINUS:
        return b.getRightOperand().equals(this.getRightOperand()) && b.getOperator().equals(this.getOperator()) && b.getLeftOperand().equals(this.getLeftOperand());
    }
  }
    return false;
  }
  /**
   * return the derivative of the instance of the binary operation
   * @return the derivative in Calc type, which will be usable in anyother classes' constructor
   * */
  @Override
  public Calc derivative(){
    Calc output = null;
    Calc leftDerivative;
    Calc rightDerivative;
    Calc top;
    Calc bottom;
    switch(getOperator()){
      case PLUS: 
        output = new BinaryOp(BinaryOp.Op.PLUS, this.getLeftOperand().derivative(), this.getRightOperand().derivative());
        break;
      case MINUS:
        output = new BinaryOp(BinaryOp.Op.MINUS, this.getLeftOperand().derivative(), this.getRightOperand().derivative());
        break;
      case MULT:
        leftDerivative = new BinaryOp(BinaryOp.Op.MULT, this.getLeftOperand().derivative(), this.getRightOperand());
        rightDerivative = new BinaryOp(BinaryOp.Op.MULT, this.getLeftOperand(), this.getRightOperand().derivative());
        output = new BinaryOp(BinaryOp.Op.PLUS, leftDerivative, rightDerivative);
        break;
      case DIV:
        leftDerivative = new BinaryOp(BinaryOp.Op.MULT, this.getLeftOperand().derivative(), this.getRightOperand());
        rightDerivative = new BinaryOp(BinaryOp.Op.MULT, this.getLeftOperand(), this.getRightOperand().derivative());
        top = new BinaryOp(BinaryOp.Op.MINUS, leftDerivative, rightDerivative);
        bottom = new Poly(this.getRightOperand(), 2);
        output = new BinaryOp(BinaryOp.Op.DIV, top, bottom);
        break;
    }
    return output;
  }   
  }