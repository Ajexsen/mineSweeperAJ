package View;

import Controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
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
        MenuItem setting = new MenuItem("Setting");

        setting.setOnAction(event -> {
            final SettingPop settingPop = new SettingPop(this);
            settingPop.initOwner(menuBar.getScene().getWindow());
            settingPop.show();
        });

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(t -> System.exit(0));
        menuFile.getItems().addAll(setting, exit);

        // --- Menu View
        Menu menuHelp = new Menu("Help");
        MenuItem about = new MenuItem("About");
        about.setOnAction(t -> {
            final Stage dialog = new Stage();
            dialog.resizableProperty().setValue(Boolean.FALSE);
            dialog.setTitle("About");
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(menuBar.getScene().getWindow());
            VBox dialogVBox = new VBox(20);
            dialogVBox.getChildren().add(new Text("This is a Dialog"));
            Scene dialogScene = new Scene(dialogVBox, 100, 100);
            dialog.setScene(dialogScene);
            dialog.show();

        });


        menuHelp.getItems().addAll(about);
        menuBar.getMenus().addAll(menuFile, menuHelp);

        statusBar = new StatusBar(controller);
        statusBar.setAlignment(Pos.CENTER);
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

    public void restart(int width, int height, int boomNr){
        controller.restart(width, height, boomNr);
        this.getChildren().remove(fieldBox);
        fieldBox = new FieldBox(controller);
        this.getChildren().addAll(fieldBox);
    }
}
