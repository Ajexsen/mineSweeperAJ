package View;

import Model.Field;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */

public class View extends Application{

    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("MineSweeper");
        VBox vBox = new VBox();


        MenuBar menuBar = new MenuBar();

        // --- Menu File
        Menu menuFile = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        menuFile.getItems().addAll(exit);

        // --- Menu View
        Menu menuHelp = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                final Stage dialog = new Stage();
                dialog.resizableProperty().setValue(Boolean.FALSE);
                dialog.setTitle("About");
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(primaryStage);
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text("This is a Dialog"));
                Scene dialogScene = new Scene(dialogVbox, 100, 100);
                dialog.setScene(dialogScene);
                dialog.show();

            }
        });


        menuHelp.getItems().addAll(about);

        menuBar.getMenus().addAll(menuFile, menuHelp);

        FieldBox fieldBox = new FieldBox(30,25);
        Field field = new Field(30,25,70);
        fieldBox.setField(field.getBoom());

        vBox.getChildren().addAll(menuBar);
        vBox.getChildren().addAll(fieldBox);

        Scene scene = new Scene(vBox);
        scene.setFill(Color.OLDLACE);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
