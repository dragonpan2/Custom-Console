/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxconsole;

import java.time.ZonedDateTime;
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

    static final String labelTextColor = "#bdc3c7";
    static final String PROMPT_VERSION = "U1.0"; 
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
        
        labelInputSide.setTextFill(Color.web(labelTextColor));
        labelInputSide.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        labelInputSide.setLayoutX(11);
        labelInputSide.setLayoutY(300);
        
        label.setTextFill(Color.web(labelTextColor));
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
        Scene scene = new Scene(root, 600, 350);

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
                    commandInterp(command, vBox, vBoxSide, primaryStage); ///
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
                else if (digiConv.equals("PAGE_UP")) {
                    vBox.setLayoutY(100);
                    vBoxSide.setLayoutY(100);
                }
                else if (digiConv.equals("PAGE_DOWN")) {
                    vBox.setLayoutY(-100);
                    vBoxSide.setLayoutY(-100);
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
        primaryStage.setResizable(false);
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
    
    public void commandInterp(String command, VBox vBox, VBox vBoxSide, Stage stage) {
        if (command.equals("QUIT")) {
            closeThisWindow(stage);
        }
        if (command.equals("EXIT")) {
            closeThisWindow(stage);
        }
        if (command.equals("HELP")) {
            
        }
        if (command.equals("DATE")) {
            getDate(vBox, vBoxSide);
        }
        if (command.equals("VERSION")) {
            
        }
        if (command.equals("CLEAR")) {
            clearConsole(vBox, vBoxSide);
        }
        
        
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
        label.setTextFill(Color.web(labelTextColor));
        label.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vBox.getChildren().add(label);
        vBox.setLayoutY(vBox.getLayoutY()-17);
        
    }
    public void addLine(VBox vBox,String string, VBox vBoxSide) {
         Label label = new Label(string);
        label.setTextFill(Color.web(labelTextColor));
        label.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vBox.getChildren().add(label);
        vBox.setLayoutY(vBox.getLayoutY()-17);
        
        // the <
        Label labelSide = new Label(">");
        labelSide.setTextFill(Color.web(labelTextColor));
        labelSide.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vBoxSide.getChildren().add(labelSide);
        vBoxSide.setLayoutY(vBoxSide.getLayoutY()-17);
    }
    public void addLine(boolean improvedModeOn, VBox vBox,String string, VBox vBoxSide) {
        if (string.length() > 40) {
            Label label2 = new Label();
            // continu split
        }
        
        //as before
         Label label = new Label(string);
        label.setTextFill(Color.web(labelTextColor));
        label.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vBox.getChildren().add(label);
        vBox.setLayoutY(vBox.getLayoutY()-17);
        
        // the <
        Label labelSide = new Label(">");
        labelSide.setTextFill(Color.web(labelTextColor));
        labelSide.setFont(Font.font("Abel",FontWeight.BOLD, 12));
        vBoxSide.getChildren().add(labelSide);
        vBoxSide.setLayoutY(vBoxSide.getLayoutY()-17);
    }
    public void closeThisWindow(Stage stage) {
        stage.close();
    }
    public void listCommand(VBox vBox, VBox vBoxSide) {
        addLine(vBox, "Exit: close the prompt ", vBoxSide);
        addLine(vBox, "QUIT: close the prompt ", vBoxSide);
        addLine(vBox, "DATE: show the local zone date ", vBoxSide);
        addLine(vBox, "VERSION: show prompt version", vBoxSide);
    }
    
    public void getDate(VBox vBox, VBox vBoxSide) {
        addLine(vBox, ZonedDateTime.now().toString(), vBoxSide);
    }
    public void getVersion(VBox vBox, VBox vBoxSide) {
        addLine(vBox, PROMPT_VERSION, vBoxSide);
    }
    public void clearConsole(VBox vBox, VBox vBoxSide) {
        vBox.getChildren().removeAll();
        vBoxSide.getChildren().removeAll();
        vBoxSide = new VBox();
        vBox.setLayoutY(300);
        vBoxSide.setLayoutY(300);
    }
}
