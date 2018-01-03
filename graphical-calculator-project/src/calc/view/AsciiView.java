package calc.view;

import java.util.Scanner;

/**
 * The AsciiView class is used to display a text-based interface on the command line
 * for this application, instead of a GUI.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class AsciiView implements ViewInterface {
  
  private String expression;
  private String answer;
  private Runnable calcHandler;
  private Runnable typeHandler;
  
  public AsciiView() {
    
  }
  
  /**
   * The menu method is used to display the menu interface in the command prompt, 
   * and call the appropriate handler methods for user inputs.
   */
  private void menu() {
    Scanner userInput = new Scanner(System.in);
    String input;
    String[] types = { "Standard", "Reverse Polish" };
    int inactiveType = 1;
    
    while (true) {
      System.out.println("==================================================");
      System.out.println("");
      System.out.println("[1] Enter an expression.");
      System.out.println("[2] Switch to " + types[inactiveType] + " calculator.");
      System.out.println("[3] Exit.");
      System.out.println("");
      System.out.println("==================================================");
      System.out.println("");
      System.out.print("Enter: ");
      input = userInput.nextLine();
      System.out.println("");
      
      switch (input) {
        case "1":
          System.out.println("==================================================");
          System.out.println("");
          System.out.print("Enter expression: ");
          expression = userInput.nextLine();
          calcHandler.run();
          System.out.println("");
          System.out.println(answer);
          System.out.println("");
          break;
        case "2":
          inactiveType = (inactiveType + 1) % 2;
          typeHandler.run();
          break;
        case "3":
          System.out.println("Exiting...");
          userInput.close();
          System.exit(0);
          break;
        default: 
          System.out.println("Invalid input. Please try again.");
          System.out.println("");
          break;
      }
    }
  }
  
  /**
   * Gets the user input stored in the expression field variable.
   * @return the user input
   */
  public String getExpression() {
    return expression;
  }
  
  /**
   * Sets the answer field variable to the string argument given.
   * @param output result string to be displayed
   */
  public void setAnswer(String output) {
    answer = output;
  }
  
  /**
   * Allows an observer (the controller) to listen for expression input events, 
   * so that an event handler can be run.
   * @param handler the handler to be run
   */
  public void addCalcObserver(Runnable handler) {
    calcHandler = handler;
  }
  
  /**
   * Allows an observer (the controller) to listen for type change events, so 
   * the event handler can be run to change the calculator type. The private 
   * method menu() is called to initiate displaying the menu interface on 
   * the command prompt.
   * @param handler the handler to be run
   */
  public void addTypeObserver(Runnable handler) {
    typeHandler = handler;
    menu();
  }
}
