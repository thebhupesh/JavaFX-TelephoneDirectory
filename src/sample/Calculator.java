package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
    	VBox root = new VBox();

    	Button add = new Button("+");
    	Button sub = new Button("-");
    	Button mul = new Button("*");
    	Button div = new Button("/");
    	Button exp = new Button("%");
    	TextField op1 = new TextField();
    	TextField op2 = new TextField();
    	TextField rslt = new TextField();

    	op1.setPrefWidth(40);
    	op2.setPrefWidth(40);
    	rslt.setPrefWidth(80);


    	 Label l1 = new Label("\t\t\t\t"+"Enter Numbers Here");
    	 Label l2 = new Label("\t\t\t"+"Click to Select an Operation");
    	 Label l3 = new Label("Result of the Operation");
    	 
    	 root.getChildren().add(l1);
    	 
    	GridPane g1 = new GridPane();
    	g1.setVgap(5);
    	g1.setHgap(5);
    	g1.setAlignment(Pos.BOTTOM_CENTER);
    	g1.add(op1, 0, 0);
    	g1.add(op2, 1, 0);
    	 root.getChildren().add(g1);
    	 Scene scene = new Scene(root, 300, 300);
    	 primaryStage.setScene(scene);
    	 primaryStage.show();
    	 root.getChildren().add(l2);
    	 GridPane g2 = new GridPane();
    	 g2.setVgap(5);
    	 g2.setHgap(5);
    	 g2.setAlignment(Pos.BOTTOM_CENTER);
    	 g2.add(add, 0, 0);
    	 g2.add(sub, 1, 0);
    	 g2.add(mul, 2, 0);
    	 g2.add(div, 3, 0);
    	 g2.add(exp, 4, 0);
    	 root.getChildren().add(g2);
    	 root.getChildren().add(l3);
    	 GridPane g3 = new GridPane();
    	 g3.setVgap(5);
    	 g3.setHgap(5);
    	 g3.setAlignment(Pos.CENTER);
    	 g3.add(l3, 0, 0);
    	 g3.add(rslt, 0, 1);
    	 root.getChildren().add(g3);
        add.setOnAction(event -> {
        	double a = Double.parseDouble(op1.getText());
        	double b = Double.parseDouble(op2.getText());
        	a += b;
        	rslt.setText(Double.toString(a));
        });
        sub.setOnAction(event -> {
        	double a = Double.parseDouble(op1.getText());
        	double b = Double.parseDouble(op2.getText());
        	a -= b;
        	rslt.setText(Double.toString(a));
        });
        mul.setOnAction(event -> {
        	double a = Double.parseDouble(op1.getText());
        	double b = Double.parseDouble(op2.getText());
        	a *= b;
        	rslt.setText(Double.toString(a));
        });
        div.setOnAction(event -> {
        	double a = Double.parseDouble(op1.getText());
        	double b = Double.parseDouble(op2.getText());
        	if(b==0D) {
        		rslt.setText("Division By Zero");
        	}
        	else {
        		a /= b;
            	rslt.setText(Double.toString(a));
        	}
        });
        exp.setOnAction(event -> {
        	double a = Double.parseDouble(op1.getText());
        	double b = Double.parseDouble(op2.getText());
        	if(b==0D) {
        		rslt.setText("Division By Zero");
        	}
        	else {
        		a %= b;
            	rslt.setText(Double.toString(a));
        	}
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
