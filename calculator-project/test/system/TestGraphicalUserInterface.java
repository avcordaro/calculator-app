package system;

import static org.junit.Assert.assertEquals;

import calc.controller.CalcController;
import calc.model.CalcModel;
import calc.view.GuiView;

import org.junit.Before;
import org.junit.Test;

/**
 * System test for release_v2.0_text_interface, to show the Graphical User Interface 
 * for the system responds correctly to various user actions.
 * @author Alex Cordaro ZDAC051
 */
public class TestGraphicalUserInterface {
  
  private GuiView gui;
  
  @Before
  public void setUp() {
    gui = GuiView.getInstance();
    new CalcController(new CalcModel(), gui);
  }

  @Test
  public void testInfixInputOnInfixCalc() {
    gui.txtInput.setText("3 + 5");
    gui.btnCalculate.fire();
    assertEquals(gui.lblAnswer.getText(), "Answer: 8.0");
  }
  
  @Test
  public void testInfixInputOnPostfixCalc() {
    gui.rbPostfix.fire();
    gui.txtInput.setText("3 + 5");
    gui.btnCalculate.fire();
    assertEquals(gui.lblAnswer.getText(), "Unbalanced expression.");
    gui.rbInfix.fire();
  }
  
  @Test
  public void testPostfixInputOnPostfixCalc() {
    gui.rbPostfix.fire();
    gui.txtInput.setText("3 5 +");
    gui.btnCalculate.fire();
    assertEquals(gui.lblAnswer.getText(), "Answer: 8.0");
    gui.rbInfix.fire();
  }
  
  @Test
  public void testPostfixInputOnInfixCalc() {
    gui.txtInput.setText("3 5 +");
    gui.btnCalculate.fire();
    assertEquals(gui.lblAnswer.getText(), "Unbalanced expression.");

  }
  
  @Test
  public void testEmptyInput() {
    gui.btnCalculate.fire();
    assertEquals(gui.lblAnswer.getText(), "Invalid expression.");
  }
  
  @Test
  public void testCalculateButtonSpam() {
    gui.txtInput.setText("3 + 5");
    for (int i = 0; i < 100; i++) {
      gui.btnCalculate.fire();
    }
    assertEquals(gui.lblAnswer.getText(), "Answer: 8.0");
  }
  
  @Test
  public void testInfixRadioButtonSpam() {
    for (int i = 0; i < 100; i++) {
      gui.rbInfix.fire();
    }
    gui.txtInput.setText("3 + 5");
    gui.btnCalculate.fire();
    assertEquals(gui.lblAnswer.getText(), "Answer: 8.0");
  }
  
  @Test
  public void testPostfixRadioSpam() {
    for (int i = 0; i < 100; i++) {
      gui.rbPostfix.fire();
    }
    gui.txtInput.setText("3 5 +");
    gui.btnCalculate.fire();
    assertEquals(gui.lblAnswer.getText(), "Answer: 8.0");
    gui.rbInfix.fire();
  }
  
}
