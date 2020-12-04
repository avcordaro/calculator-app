package calc.controller;

import calc.view.AsciiView;
import calc.view.GuiView;
import calc.view.ViewInterface;

/**
 * The ViewFactory class is used by MvcDriver, and decides whether to return an 
 * instance of AsciiView or GuiView.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public final class ViewFactory {
  
  /**
   * This is the factory method which decides which type of view instance to return, 
   * depending on whether the application has been run through the command line.
   * @return the appropriate view instance
   */
  public static ViewInterface createView() {
    if (System.console() == null) {
      return GuiView.getInstance();
    }
    return new AsciiView();
  }

}