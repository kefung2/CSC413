package edu.csc413.calculator.evaluator;
/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {

  private int input;

  /**
  * construct operand from string token.
  */
  public Operand( String token ) {
    input = Integer.parseInt(token);
  }
  /**
   * construct operand from integer
   */
  public Operand( int value ) {
    input = value;
  }
  /**
   * return value of opernad
   */
  public int getValue() {
      return input;
  }
  /**
   * Check to see if given token is a valid
   * operand.
   */
  public static boolean check( String token ) {
    try {
      Integer.parseInt(token);
      return true;
    } catch (NumberFormatException e){
      return false;
    }
  }
}
