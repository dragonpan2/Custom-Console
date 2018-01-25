/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxconsole;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author panbe
 */
public class JavaFXConsole extends Application implements EventHandler<KeyEvent> {

    @Override
    public  void start(Stage primaryStage) {

        VBox vBox = new VBox();
        VBox vBoxSide = new VBox();
        vBoxSide.setLayoutX(11);
        vBoxSide.setLayoutY(300);
        vBox.setLayoutX(20);
        vBox.setLayoutY(300);
        
        Label label = new Label();
        Label labelInputSide = new Label(">");
        Pane pane = new Pane();
        
        labelInputSide.setTextFill(Color.web("#bdc3c7"));
        labelInputSide.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        labelInputSide.setLayoutX(11);
        labelInputSide.setLayoutY(300);
        
        label.setTextFill(Color.web("#bdc3c7"));
        label.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        label.setLayoutX(20);
        label.setLayoutY(300);
        
        pane.setStyle("-fx-background-color:#2c3e50;");
        pane.getChildren().add(label);
        pane.getChildren().add(vBox);
        pane.getChildren().add(vBoxSide);
        pane.getChildren().add(labelInputSide);
        
        StackPane root = new StackPane();
        root.getChildren().add(pane);
        Scene scene = new Scene(root, 500, 350);

        ///
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                System.out.println(event.getCode().toString());

                String input = event.getCode().toString();
                String digiConv = digitConverter(input);

                if (digiConv.equals("ENTER")) {
                    String command = label.getText();
                    addLine(vBox, command, vBoxSide);
                    commandInterp(command); ///
                    label.setText("");
                } 
                else if (digiConv.equals("BACK_SPACE")) {
                    StringBuilder sb = new StringBuilder(label.getText());
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                        label.setText(sb.toString());
                    }
                }
                else if(digiConv.equals("SPACE")) {
                    label.setText(label.getText()+" ");
                }
                else if (digiConv.equals("notn")) {
                    label.setText(label.getText() + input);

                } 
                else {
                    label.setText(label.getText() + digitConverter(input));
                }
            }
        });

        primaryStage.setTitle("Pan's Custom console");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void handle(KeyEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void commandInterp(String command) {
        
    }
    
    public String digitConverter(String digit) {
        String number = "";
        switch (digit) {
            case "DIGIT1":
                number = "1";
                break;
            case "DIGIT2":
                number = "2";
                break;
            case "DIGIT3":
                number = "3";
                break;
            case "DIGIT4":
                number = "4";
                break;
            case "DIGIT5":
                number = "5";
                break;
            case "DIGIT6":
                number = "6";
                break;
            case "DIGIT7":
                number = "7";
                break;
            case "DIGIT8":
                number = "8";
                break;
            case "DIGIT9":
                number = "9";
                break;
            case "DIGIT0":
                number = "0";
                break;
            default:
                return digit;
        }
        return number;
    }

    public void addLine(VBox vBox, String string) {
        Label label = new Label(string);
        label.setTextFill(Color.web("#bdc3c7"));
        label.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vBox.getChildren().add(label);
        vBox.setLayoutY(vBox.getLayoutY()-17);
        
    }
    public void addLine(VBox vBox,String string, VBox vBoxSide) {
         Label label = new Label(string);
        label.setTextFill(Color.web("#bdc3c7"));
        label.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vBox.getChildren().add(label);
        vBox.setLayoutY(vBox.getLayoutY()-17);
        
        // the <
        Label labelSide = new Label(">");
        labelSide.setTextFill(Color.web("#bdc3c7"));
        labelSide.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vBoxSide.getChildren().add(labelSide);
        vBoxSide.setLayoutY(vBoxSide.getLayoutY()-17);
    }
}
