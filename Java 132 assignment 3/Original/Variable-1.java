/**
* The class that display the variable
* @author <em>Phan Trinh Ha</em>
*/
public class Variable extends Calc {
  
 /**
  * the constructor of type Variable
  * */
 public Variable(){
  super();
 }
 
  /**
   * return the String representation of the Variable
   * @return String representation of "x"
   * */
 @Override
 public String toString(){
  return "x";
 }
 
 /**
  * the method that compares the variable to type of the instance to an object
  * @param o the object being compared
  * @return true if the object is of type variable, false if otherwise
  * */
 @Override
 public boolean equals(Object o){
  return o instanceof Variable; 
 }
 
 /** 
  * the method that returns the value of the variable
  * @param value the input of type double
  * @return return that value as input = x
  * */
 @Override
 public double value(double value){
   return value;
 }
 
 /**
  * the method that throws fault in case the user calls a blank input of type variable
  * @return UnsupportedOperationException
  * */
 @Override
 public double value() {
   throw new UnsupportedOperationException();
 }
 
  /**
   * return the derivative of the instance of the variable
   * @return the derivative in Calc type, which will be usable in anyother classes' constructor
   * */
 @Override
 public Calc derivative(){
   return new Number(1);
 }
}