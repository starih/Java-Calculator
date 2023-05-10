# Java-Calculator
A simple calculator application built in Java.
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class CalculatorApp extends Application {

    private TextField inputField;
    private ListView<String> calculationHistory;
    private ArrayList<String> historyList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        inputField = new TextField();
        inputField.setAlignment(Pos.CENTER_RIGHT);
        inputField.setEditable(false);
        inputField.setPrefWidth(150);

        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btn0 = new Button("0");

        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnMultiply = new Button("*");
        Button btnDivide = new Button("/");
        Button btnClear = new Button("C");
        Button btnEquals = new Button("=");

        HBox row1 = new HBox(10, btn1, btn2, btn3, btnPlus);
        HBox row2 = new HBox(10, btn4, btn5, btn6, btnMinus);
        HBox row3 = new HBox(10, btn7, btn8, btn9, btnMultiply);
        HBox row4 = new HBox(10, btn0, btnClear, btnEquals, btnDivide);
        VBox vBox = new VBox(10, inputField, row1, row2, row3, row4);

        calculationHistory = new ListView<>();
        calculationHistory.getItems().addAll(historyList);

        Label historyLabel = new Label("Calculation History:");
        VBox historyBox = new VBox(10, historyLabel, calculationHistory);

        btn1.setOnAction(e -> appendToInputField("1"));
        btn2.setOnAction(e -> appendToInputField("2"));
        btn3.setOnAction(e -> appendToInputField("3"));
        btn4.setOnAction(e -> appendToInputField("4"));
        btn5.setOnAction(e -> appendToInputField("5"));
        btn6.setOnAction(e -> appendToInputField("6"));
        btn7.setOnAction(e -> appendToInputField("7"));
        btn8.setOnAction(e -> appendToInputField("8"));
        btn9.setOnAction(e -> appendToInputField("9"));
        btn0.setOnAction(e -> appendToInputField("0"));
        btnPlus.setOnAction(e -> performOperation("+"));
        btnMinus.setOnAction(e -> performOperation("-"));
        btnMultiply.setOnAction(e -> performOperation("*"));
        btnDivide.setOnAction(e -> performOperation("/"));
        btnClear.setOnAction(e -> clearInputField());
        btnEquals.setOnAction(e -> performOperation("="));

        Scene scene = new Scene(new HBox(20, vBox, historyBox));
        primaryStage.setScene(scene);
        primaryStage.setTitle("
