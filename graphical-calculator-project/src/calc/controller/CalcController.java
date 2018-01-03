package calc.controller;

import calc.model.BadTypeException;
import calc.model.CalcModel;
import calc.model.EmptyStackException;
import calc.model.InvalidExpressionException;
import calc.view.ViewInterface;

/**
 * The controller class determines the communication between an instance of CalcModel and 
 * CalcView, namely the inputs to be evaluated and and outputs to be displayed.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class CalcController {
  
  private CalcModel model;
  private ViewInterface view;
  
  /**
   * Defines the handler method for user expression inputs that need to be evaluated.
   */
  private Runnable calculate = new Runnable() {
    @Override
    public void run() {
      try {
        float answer = model.evaluate(view.getExpression());
        view.setAnswer("Answer: " + Float.toString(answer));
        
      } catch (InvalidExpressionException e) {
        view.setAnswer(e.getMessage());
        
      } catch (BadTypeException | EmptyStackException e) {
        e.printStackTrace();
      }
    }
  };
  
  /**
   * Defines the handler method for when the user changes the calculator type
   * between infix and postfix.
   */
  private Runnable exprType = new Runnable() {
    @Override
    public void run() {
      if (model.current == model.stdCalc) {
        model.current = model.rvpCalc;
      } else {
        model.current = model.stdCalc;
      }
    }
  };
  
  /**
   * Constructs an object of CalcModel, passing it's update runnables to the 
   * observable view methods.
   * @param m an instance of CalcModel
   * @param v an instance of ViewInterface
   */
  public CalcController(CalcModel m, ViewInterface v) {
    model = m;
    view = v;
    view.addCalcObserver(calculate);
    view.addTypeObserver(exprType);
  }
}