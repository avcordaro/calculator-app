package calc.view;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The CalcView class is responsible for loading the FXView fxml file, and communicates 
 * with CalcController to handle user inputs and display outputs.
 * @author Dave Cohen
 * @version 1.0
 */
public class GuiView extends Application implements ViewInterface {
  
  private String expression; 
  private String answer;
  
  @FXML 
  public Label lblAnswer;
  @FXML
  public TextField txtInput;
  @FXML
  public Button btnCalculate = null;
  @FXML 
  public RadioButton rbInfix;
  @FXML 
  public RadioButton rbPostfix;
  
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
    primaryStage.setScene(scene);
    primaryStage.setTitle("Graphical Calculator");
    primaryStage.show();
  }
  
  /**
   * Allows an observer (the controller) to listen for button events, so that 
   * an event handler can be run.
   * @param handler the handler to be run
   */
  public void addCalcObserver(Runnable handler) {
    btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        handler.run();       
      }
    });
  }
  
  /**
   * Allows an observer (the controller) to listen for radio button events, so 
   * the event handler can be run to change the calculator type.
   * @param handler the handler to be run
   */
  public void addTypeObserver(Runnable handler) {
    EventHandler<ActionEvent> mal = new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        handler.run();       
      }
    };
    rbInfix.setOnAction(mal);
    rbPostfix.setOnAction(mal);
  }
  
  /**
   * Gets the user input stored in the textbox on the display.
   * @return the user input
   */
  public String getExpression() {
    expression = txtInput.getText();
    return expression;
  }
  
  /**
   * Sets the answer label on the display to the string argument given.
   * @param output result string to be displayed
   */
  public void setAnswer(String output) {
    answer = output;
    lblAnswer.setText(answer);
  }
}
