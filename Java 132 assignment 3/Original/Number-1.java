/**
 * The class that represents numbers as double
 * @author Phan Trinh Ha
 * */
public class Number extends Calc{
  
  private double value;//the value of the number
  
    /** the constructor of the number
    * @param value the value of the number, type double
    * */
  public Number(double value){
    super();
    this.value = value;
  }
  
  /**
   * The method that returns the value of the number
   * @return a double value
   * */
  @Override
  public double value() throws UnsupportedOperationException{
    return this.value;
  }
  
    /**
   * The method that returns the value of the number, case the user calls for an input type
   * @return the value of the number
   * */
  @Override
  public double value(double input){
    return this.value;
  }
  
  /**
   * The method that return the string form of the Number
   * @return String
   * */
  @Override
  public String toString(){
    return String.valueOf(value());
  }
  
  /**
   * The method compares the number
   * @param o Object to compare, preferably Number type
   * @return equal or not equal
   * */
  @Override
  public boolean equals(Object o){
    if (o instanceof Number){
      Number n = (Number)o;
      return this.value() == n.value();
    }
    else return false;
  }
  
   /**
   * return the derivative of the instance of the number(constant)
   * @return the derivative in Calc type, which will be usable in anyother classes' constructor
   * */
  @Override
  public Calc derivative(){
    return new Number(0);
  }
  
}

