package View;

import javafx.scene.control.Button;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
public class Cell extends Button {

    public Cell(){
        int de = 25;
        this.setMinWidth(de);
        this.setMinHeight(de);
        this.setMaxWidth(de);
        this.setMaxHeight(de);
    }

}
