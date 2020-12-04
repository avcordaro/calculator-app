package calc.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The CalcView class is responsible for loading the FXView fxml file, and communicates 
 * with CalcController to handle user inputs and display outputs.
 * @author Alex Cordaro
 */
public class GuiView extends Application implements ViewInterface {
  
  private String input = ""; 
  
  @FXML
  private TextArea txtInput;
  @FXML
  private Button btnCE;
  @FXML
  private Button btnDiv;
  @FXML
  private Button btnC;
  @FXML
  private Button btn8;
  @FXML
  private Button btn9;
  @FXML
  private Button btnEq;
  @FXML
  private Button btnSub;
  @FXML
  private Button btn6;
  @FXML
  private Button btnAdd;
  @FXML
  private Button btn7;
  @FXML
  private Button btn4;
  @FXML
  private Button btn5;
  @FXML
  private Button btn2;
  @FXML
  private Button btnMul;
  @FXML
  private Button btn3;
  @FXML
  private Button btn0;
  @FXML
  private Button btn1;
  @FXML
  private Button btnDot;
  
  private static volatile GuiView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * Used by the MVCDriver to pass the instance variable to the controller.
   * @return instance of class
   */
  public static synchronized GuiView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(GuiView.class)).start();
    }
    while (instance == null) {
    }
    return instance;
  }
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    VBox page = (VBox) FXMLLoader.load(GuiView.class
        .getResource("FXView.fxml"));
    Scene scene = new Scene(page);
    primaryStage.getIcons().add(new Image("http://www.bedardcpa.net/wp-content/uploads/2016/01/impots-300x300.png"));
    primaryStage.setScene(scene);
    primaryStage.setTitle("Calculator");
    primaryStage.show();
  }
  
  /**
   * Allows an observer (the controller) to listen for button events, so that 
   * an event handler can be run.
   * @param handler the handler to be run
   */
  public void addCalcObserver(Runnable handler) {
    btnEq.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        handler.run();
        input = "";       
      }
    });
  }
  
  /**
   * Gets the user input stored in the textbox on the display.
   * @return the user input
   */
  public String getExpression() {
    return input;
  }
  
  /**
   * Sets the answer label on the display to the string argument given.
   * @param output result string to be displayed
   */
  public void setAnswer(String output) {
    txtInput.setText(output);
  }

  @FXML
  public void button1_click() {
    input = input + "1";
    txtInput.setText(input);
  }
  @FXML
  public void button2_click() {
    input = input + "2";
    txtInput.setText(input);
  }
  @FXML
  public void button3_click() {
    input = input + "3";
    txtInput.setText(input);
  }
  @FXML
  public void button4_click() {
    input = input + "4";
    txtInput.setText(input);
  }
  @FXML
  public void button5_click() {
    input = input + "5";
    txtInput.setText(input);
  }
  @FXML
  public void button6_click() {
    input = input + "6";
    txtInput.setText(input);
  }
  @FXML
  public void button7_click() {
    input = input + "7";
    txtInput.setText(input);
  }
  @FXML
  public void button8_click() {
    input = input + "8";
    txtInput.setText(input);
  }
  @FXML
  public void button9_click() {
    input = input + "9";
    txtInput.setText(input);
  }
  @FXML
  public void button0_click() {
    input = input + "0";
    txtInput.setText(input);
  }
  @FXML
  public void buttonDot_click() {
    input = input + ".";
    txtInput.setText(input);
  }
  @FXML
  public void buttonAdd_click() {
    input = input + " + ";
    txtInput.setText(input);
  }
  @FXML
  public void buttonSub_click() {
    input = input + " - ";
    txtInput.setText(input);
  }
  @FXML
  public void buttonMul_click() {
    input = input + " * ";
    txtInput.setText(input);
  }
  @FXML
  public void buttonDiv_click() {
    input = input + " / ";
    txtInput.setText(input);
  }
  @FXML
  public void buttonC_click() {
    input = "";
    txtInput.setText(input);
  }
  @FXML
  public void buttonCE_click() {
    input = input.substring(0, input.length() - 1);
    txtInput.setText(input);
  }
}
