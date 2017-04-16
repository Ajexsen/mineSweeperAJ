package View;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
public class Cell extends Button {


    private final int x;
    private final int y;

    private boolean isPressed = false;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        int defaultSize = 25;
        this.setMinWidth(defaultSize);
        this.setMinHeight(defaultSize);
        this.setMaxWidth(defaultSize);
        this.setMaxHeight(defaultSize);

    }


    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void disable(){
        isPressed = true;
        this.setDisable(true);
    }



}
