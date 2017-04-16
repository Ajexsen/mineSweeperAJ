package View;

import javafx.scene.layout.GridPane;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
public class FieldBox extends GridPane {
    private Cell cells[][];
    private int width;
    private int height;

    public FieldBox(int width, int height){
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for(int i = 0; i < width ; i++){
            for(int j = 0; j < height; j++ ){
                cells[i][j] = new Cell();
                this.add(cells[i][j],i,j,1,1);
            }
        }
    }


    public void setField(boolean[][] boomCell){
        if(boomCell.length > 0){
            int x = boomCell.length;
            int y = boomCell[0].length;
            if(x == width && y == height){
                for(int i = 0; i < width ; i++){
                    for(int j = 0 ; j < height ; j++){
                        if(boomCell[i][j])
                            cells[i][j].setText("X");
                    }
                }
            } else {}
        }
    }
}
