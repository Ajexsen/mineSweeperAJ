package View;

import Controller.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */

public class View extends VBox {

    private Controller controller;

    private MenuBar menuBar;
    private StatusBar statusBar;
    private FieldBox fieldBox;




    public View(Controller controller) {
        this.controller = controller;
        controller.subscribe(this);

        menuBar = new MenuBar();
        // --- Menu File
        Menu menuFile = new Menu("File");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(t -> System.exit(0));
        menuFile.getItems().addAll(exit);

        // --- Menu View
        Menu menuHelp = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(t -> {
            final Stage dialog = new Stage();
            dialog.resizableProperty().setValue(Boolean.FALSE);
            dialog.setTitle("About");
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(menuBar.getScene().getWindow());
            VBox dialogVbox = new VBox(20);
            dialogVbox.getChildren().add(new Text("This is a Dialog"));
            Scene dialogScene = new Scene(dialogVbox, 100, 100);
            dialog.setScene(dialogScene);
            dialog.show();

        });


        menuHelp.getItems().addAll(about);
        menuBar.getMenus().addAll(menuFile, menuHelp);

        statusBar = new StatusBar(controller);
        fieldBox = new FieldBox(controller);


        this.getChildren().addAll(menuBar);
        this.getChildren().addAll(statusBar);
        this.getChildren().addAll(fieldBox);
    }

    public void setNr(int nr){
        statusBar.setNr(nr);
    }

    public void restart(){
        controller.restart();
        this.getChildren().remove(fieldBox);
        fieldBox = new FieldBox(controller);
        this.getChildren().addAll(fieldBox);
    }
}
