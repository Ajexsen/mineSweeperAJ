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
            final Stage settingPop = new Stage();
            settingPop.resizableProperty().setValue(Boolean.FALSE);
            settingPop.setTitle("Setting");
            settingPop.initModality(Modality.APPLICATION_MODAL);
            settingPop.initOwner(menuBar.getScene().getWindow());

            GridPane settingPane = new GridPane();
            TextField widthText = new TextField();
            TextField heightText = new TextField();
            TextField boomText = new TextField();
            Button submit = new Button("Submit");
            settingPane.add(new Label("Width:"),0,1,1,1);
            settingPane.add(widthText, 1, 1,1,1);

            settingPane.add(new Label("Height:"),0,2,1,1);
            settingPane.add(heightText, 1, 2,1,1);

            settingPane.add(new Label("Mines:"),0,3,1,1);
            settingPane.add(boomText, 1, 3,1,1);

            settingPane.add(submit, 1, 4,2,1);

            settingPane.setHgap(10);
            settingPane.setVgap(10);
            settingPane.setPadding(new Insets(5, 10, 5, 10));

            submit.setOnAction(event2 -> {
                int width = Integer.valueOf(widthText.getText());
                int height = Integer.valueOf(heightText.getText());
                int boomNr = Integer.valueOf(boomText.getText());
                restart(width, height, boomNr);
                settingPop.close();
            });

            Scene settingScene = new Scene(settingPane);

            settingPop.setScene(settingScene);
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
