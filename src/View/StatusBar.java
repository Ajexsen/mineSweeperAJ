package View;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
class StatusBar extends HBox {
    private Controller controller;
    private Button startButt;

    StatusBar(Controller controller) {
        this.controller = controller;

        startButt = new Button("Start");
        startButt.setOnAction(e -> {
        });
        this.getChildren().add(startButt);
    }
}
