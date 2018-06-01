/**
* The class that display the common parent of the 8 data type
* @author <em>Phan Trinh Ha</em>
*/
public abstract class Calc extends Object{
  
  /**
   * the method that takes the input, and give the variable that value
   * @param input the value to be replaced
   * @return the value of the function
   * */
  abstract double value(double input);
  
  /** 
   * the method that return the value of a function that takes has no variables
   * @return the value of the function
   * */
  abstract double value() throws UnsupportedOperationException;
  
  /** 
   * return the derivative of the function in calc type
   * @return the object of the derivative of the function
   * */
  abstract Calc derivative();
}