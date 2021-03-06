package View;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
class Cell extends Button {


    private final int x;
    private final int y;

    private boolean isPressed = false;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
        int defaultSize = 25;
        this.setMinWidth(defaultSize);
        this.setMinHeight(defaultSize);
        this.setMaxWidth(defaultSize);
        this.setMaxHeight(defaultSize);
        this.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
    }


    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void disable() {
        isPressed = true;
        this.setStyle(
                "-fx-shadow-highlight-color : transparent;" +  // if you don't want a 3d effect highlight.
                        "-fx-outer-border : transparent;" +  // if you don't want a button border.
                        "-fx-inner-border : transparent;" +  // if you don't want a button border.
                        "-fx-focus-color: transparent;" +  // if you don't want any focus ring.
                        "-fx-faint-focus-color : transparent;"  // if you don't want any focus ring.
        );
        this.setDisable(true);
    }

    public void greyOut(){
        this.setStyle("fx-background-color: #999");
    }


}
