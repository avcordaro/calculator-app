package calc.view;

/**
 * This interface is inheritedd by the two View classes, instructing 
 * them to implement the follow methods and parameters.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public interface ViewInterface {
  
  public String getExpression();
  
  public void setAnswer(String s);
  
  public void addCalcObserver(Runnable r);
  
  public void addTypeObserver(Runnable r);
  
}
