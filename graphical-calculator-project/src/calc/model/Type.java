package calc.model;

/**
 * The enum Type defines the list of the types of values an Entry can represent. 
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public enum Type {
  NUMBER, SYMBOL, STRING, INVALID;

  /**
   * Overrides the default toString() method to a more readable format. 
   * This keeps the first letter of the constants name as uppercase, 
   * then changes the rest to lowercase.
   * @return a more readable format of the constant's name
   */
  @Override 
  public String toString() {
    return name().charAt(0) + name().substring(1).toLowerCase();
  }
}
