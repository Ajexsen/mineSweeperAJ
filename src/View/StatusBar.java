package View;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
public class StatusBar extends HBox {
    private Button startButt;
    public StatusBar(){
        startButt = new Button("Start");
        this.getChildren().add(startButt);
    }
}
