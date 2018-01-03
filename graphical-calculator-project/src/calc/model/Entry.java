package calc.model;

/**
 * The Entry class defines the values (read from an expression) that can be stored in a Stack.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class Entry {
  
  private Float number;
  private Symbol other;
  private String str;
  private Type type;
  
  /**
   * Constructs an Entry object which contains a numeric value.
   * @param value the numeric value 
   */
  public Entry(float value) {
    number = value;
    type = Type.NUMBER;
  }
  
  /**
   * Constructs an Entry object which contains a symbol type.
   * @param which the symbol type
   */
  public Entry(Symbol which) {
    other = which;
    type = Type.SYMBOL;
  }
  
  /**
   * Constructs an Entry object which contains a string value.
   * @param string the string value 
   */
  public Entry(String string) {
    str = string;
    type = Type.STRING;
  }
  
  /**
   * Getter method for indentifying the value type of the entry.
   * @return the value type of the entry
   */
  public Type getType() {
    return type;
  }
  
  /**
   * Getter method for a numeric entry object.
   * @return the numeric value of the entry
   * @throws BadTypeException if the entry type calling this getter method is not a number
   */
  public float getValue() throws BadTypeException {
    if (type == Type.NUMBER) {
      return number;
    } 
    throw new BadTypeException("This entry type is not numeric.");
  }
  
  /**
   * Getter method for a symbol entry object.
   * @return the symbol value of the entry
   * @throws BadTypeException if the entry type calling this getter method is not a symbol
   */
  public Symbol getSymbol() throws BadTypeException {
    if (type == Type.SYMBOL) {
      return other;
    }
    throw new BadTypeException("This entry type is not a symbol.");
  }
  
  /**
   * Getter method for a string entry object.
   * @return the string value of the entry
   * @throws BadTypeException if the entry type calling this getter method is not a string
   */
  public String getString() throws BadTypeException {
    if (type == Type.STRING) {
      return str;
    }
    throw new BadTypeException("This entry type is not a string.");
  }
  
  /**
   * This methods defines whether two Entry objects are equal to eachother. 
   * They are equal if and only if they have the same type and value.
   * @param other the reference to the object for comparing 
   * @return true if this object is the same as the object argument; false otherwise.
   */
  @Override
  public boolean equals(Object other) {
    //checks that the object argument given is not a reference to the same object
    if (other == this) {
      return true;
    } 
    //also checks that the argument given is an Entry object and not null
    if (!(other instanceof Entry) || other == null) {
      return false;
    }
    
    Entry entry = (Entry) other;
    
    //checks that the two entry objects have the same type, before comparing their type values
    if (getType() == entry.getType()) {
      try {
        switch (getType()) {
          case NUMBER:
            return getValue() == entry.getValue();
          case SYMBOL:
            return getSymbol() == entry.getSymbol();
          case STRING:
            return getString().equals(entry.getString());
          default: 
            return false;
        }
      } catch (BadTypeException e) { 
        System.out.println(e.getMessage());
      }
    }
    return false;
  }
  
  /**
   * Generates a hash code value for the current object.
   * @return a hash code value
   */
  @Override
  public int hashCode() {
    //hashcode method as described in Joshua Bloch's 'Effective Java'
    int result = 17;
    result = 31 * result + type.hashCode();
    
    switch (getType()) {
      case NUMBER:
        result = 31 * result + number.hashCode();
        break;
      case SYMBOL:
        result = 31 * result + other.hashCode();
        break;
      case STRING:
        result = 31 * result + str.hashCode();
        break;
      default: 
        break;
    }
    return result;   
  }
  
}
