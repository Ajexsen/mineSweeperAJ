package View;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
public class Counter extends VBox {
    private Label title;
    private TextField counter;

    public Counter(String text){
        title = new Label(text);
        counter = new TextField("0");
        this.getChildren().add(title);
        this.getChildren().add(counter);
    }

    public void setCounter(int sec){
        counter.setText("" + sec);
    }

}
