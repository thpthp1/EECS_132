/**
 * The class that represents the classes that needs one operand
 * @author <em>Phan Trinh Ha</em>
 * */
public abstract class Unary extends Calc{
  
  /**
   * The are many uses of abstract clasees, 
   * the main purpose of abstract classes is to function as base classes
   * which can be extended by subclasses to create a full implementation
   * */
  private Calc operand; // the operand to be stored
  
    /** the constructor of every Unary function
    * @param operand the operand to be put inside that function
    * */
  public Unary(Calc operand){
    this.operand = operand;
  }
  
  /**
   * This method returns the operand input
   * @return Calc operand
   * */
  public Calc getOperand(){
    return this.operand;
  }
}