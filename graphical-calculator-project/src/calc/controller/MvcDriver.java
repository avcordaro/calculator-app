package calc.controller;

import calc.model.CalcModel;
import calc.view.ViewInterface;

/**
 * MvcDriver is used as the main class, and creates an instance of the model and view, 
 * before passing them to an instance of the controller.
 * @author Dave Cohen
 * @version 1.0
 */
public class MvcDriver {
   
  /**
   * Creates an instance of CalcModel and CalcView, before 
   * passing them to a new CalcController object.
   * @param args command line arguments
   */
  public static void main(String[] args) { 
    CalcModel model = new CalcModel();
    ViewInterface view = ViewFactory.createView();
    new CalcController(model, view);
  }
}
