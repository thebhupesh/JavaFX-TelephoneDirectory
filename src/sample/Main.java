package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;
import java.io.*;
import java.util.Scanner;
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("Telephone Directory");
            BorderPane root = new BorderPane();
            BorderPane pane_1 = new BorderPane();
            Text title = new Text("Telephone Directory");
            title.setX(150);
            title.setY(20);
            title.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 30));
            pane_1.setCenter(title);
            Image home = new Image(new FileInputStream("B:\\SourceCodes\\JAVA\\JAVAfx\\Telephone.jpg"));
            ImageView imv = new ImageView(home);
            imv.setFitWidth(250);
            imv.setFitHeight(250);
            BorderPane pane_2 = new BorderPane();
            pane_2.setCenter(imv);
            BorderPane pane1 = new BorderPane();
            pane1.setTop(pane_1);
            pane1.setCenter(pane_2);
            BorderPane pane2 = new BorderPane();
            Button add_btn = new Button("Add Contact");
            add_btn.setMinSize(90, 30);
            add_btn.setMaxSize(100, 30);
            add_btn.setPrefSize(100,30);
            Group add_root = new Group();
            Text add_title = new Text("New Contact");
            add_title.setX(165);
            add_title.setY(75);
            add_title.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 30));
            add_root.getChildren().add(add_title);
            GridPane add_grid = new GridPane();
            add_grid.setVgap(30);
            add_grid.setHgap(20);
            add_grid.setPadding(new Insets(95, 100, 95, 100));
            add_grid.setAlignment(Pos.BOTTOM_CENTER);
            TextField txt1_1 = new TextField();
            add_grid.add(new Label("Name"), 0, 1);
            add_grid.add(txt1_1, 1, 1);
            TextField txt2_1 = new TextField();
            add_grid.add(new Label("Address"), 0, 2);
            add_grid.add(txt2_1, 1, 2);
            TextField txt3_1 = new TextField();
            add_grid.add(new Label("Contact Number"), 0, 3);
            add_grid.add(txt3_1, 1, 3);
            Button submit = new Button("Submit");
            Button back_1 = new Button("Back");
            HBox btn_box_1 = new HBox(50,submit,back_1);
            add_grid.add(btn_box_1, 1, 5);
            add_root.getChildren().add(add_grid);
            Scene scene_add = new Scene(add_root, 500, 500);
            add_btn.setOnAction(event -> primaryStage.setScene(scene_add));
            submit.setOnAction(event -> {
                try {
                    String name = txt1_1.getText();
                    String add = System.lineSeparator() + txt2_1.getText();
                    String number = System.lineSeparator() + txt3_1.getText() + System.lineSeparator();
                    File file = new File("Contacts.txt");
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    br.write(name);
                    br.write(add);
                    br.write(number);
                    br.close();
                    fr.close();
                    Text t = new Text("Contact Added Succesfully!!!");
                    t.setX(120);
                    t.setY(400);
                    t.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 20));
                    Group g = new Group();
                    g.getChildren().add(add_root);
                    g.getChildren().add(t);
                    Scene s = new Scene(g, 500, 500);
                    primaryStage.setScene(s);
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            });
            pane2.setCenter(add_btn);
            BorderPane pane3 = new BorderPane();
            Button find_btn = new Button("Find Contact");
            find_btn.setMinSize(90, 30);
            find_btn.setMaxSize(100, 30);
            find_btn.setPrefSize(100,30);
            Group find_root = new Group();
            Text find_title = new Text("Find Contact");
            find_title.setX(155);
            find_title.setY(150);
            find_title.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 30));
            find_root.getChildren().add(find_title);
            GridPane find_grid = new GridPane();
            find_grid.setVgap(30);
            find_grid.setHgap(20);
            find_grid.setPadding(new Insets(180, 100, 100, 140));
            find_grid.setAlignment(Pos.BOTTOM_CENTER);
            TextField txt1_2 = new TextField();
            find_grid.add(new Label("Name"), 0, 1);
            find_grid.add(txt1_2, 1, 1);
            Button search = new Button("Search");
            Button back_2 = new Button("Back");
            HBox btn_box_2 = new HBox(50,search,back_2);
            find_grid.add(btn_box_2, 1, 3);
            find_root.getChildren().add(find_grid);
            Scene scene_find = new Scene(find_root, 500, 500);
            find_btn.setOnAction(event -> primaryStage.setScene(scene_find));
            search.setOnAction((ActionEvent event) -> {
                try {
                    int count = 0;
                    String add = "",number = "";
                    String name_ = txt1_2.getText();
                    FileInputStream fis = new FileInputStream("Contacts.txt");
                    Scanner srch = new Scanner(fis);
                    while(srch.hasNextLine()) {
                        if(srch.nextLine().equals(name_)) {
                            add = srch.nextLine();
                            number = srch.nextLine();
                            count++;
                            break;
                        }
                    srch.close();
                    }
                    if(count == 1) {
                        Text t = new Text("Contact Found");
                        t.setX(155);
                        t.setY(125);
                        t.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 30));
                        GridPane gp = new GridPane();
                        gp.setVgap(20);
                        gp.setHgap(10);
                        gp.setPadding(new Insets(175, 100, 100, 180));
                        gp.setAlignment(Pos.BOTTOM_CENTER);
                        Text t1_1 = new Text("Name: ");
                        t1_1.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        gp.add(t1_1, 0, 0);
                        Text t1_2 = new Text(name_);
                        t1_2.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        gp.add(t1_2,1,0);
                        Text t2_1 = new Text("Address: ");
                        t2_1.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        gp.add(t2_1, 0, 1);
                        Text t2_2 = new Text(add);
                        t2_2.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        gp.add(t2_2,1,1);
                        Text t3_1 = new Text("Phone No.: ");
                        t3_1.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        gp.add(t3_1, 0, 2);
                        Text t3_2 = new Text(number);
                        t3_2.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 15));
                        gp.add(t3_2,1,2);
                        Button back = new Button("Back");
                        back.setOnAction((ActionEvent event1) -> primaryStage.setScene(scene_find));
                        gp.add(back,1,4);
                        Group g = new Group();
                        g.getChildren().add(t);
                        g.getChildren().add(gp);
                        Scene s = new Scene(g, 500, 500);
                        primaryStage.setScene(s);
                    }
                    else {
                        Text t = new Text("Contact Does Not Exist!!!");
                        t.setX(130);
                        t.setY(400);
                        t.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR, 20));
                        Group g = new Group();
                        g.getChildren().add(find_root);
                        g.getChildren().add(t);
                        Scene s = new Scene(g, 500, 500);
                        primaryStage.setScene(s);
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            });
            pane3.setCenter(find_btn);
            VBox box = new VBox(30,pane2,pane3);
            VBox box1 = new VBox(50,pane1,box);
            root.setCenter(box1);
            Scene main_scene = new Scene(root, 500, 500);
            back_1.setOnAction(event -> primaryStage.setScene(main_scene));
            back_2.setOnAction(event -> primaryStage.setScene(main_scene));
            primaryStage.setScene(main_scene);
            primaryStage.show();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}