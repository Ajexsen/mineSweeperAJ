package View;

import Controller.Controller;
import Model.Model;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
public class FieldBox extends GridPane {
    private Cell cells[][];
    private int width;
    private int height;

    public FieldBox(Controller controller){
        this.width = controller.getWidth();
        this.height = controller.getHeight();
        cells = new Cell[width][height];
        for(int i = 0; i < width ; i++){
            for(int j = 0; j < height; j++ ){
                cells[i][j] = new Cell(i,j);
                cells[i][j].setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        MouseButton button = event.getButton();
                        Cell cell = (Cell) event.getSource();
                        if(button == MouseButton.PRIMARY){
                            int nr = controller.surroundingNr(cell.getX(), cell.getY());
                            cell.setText("" + nr);
                            cell.disable();
                        } else if(button == MouseButton.SECONDARY){
                            cell.setText("F");
                        } else if(button == MouseButton.MIDDLE){
                        }
                    }
                });

                this.add(cells[i][j],i,j,1,1);
            }
        }
    }

    /*

    public void setField(boolean[][] boomCell, int[][] board){
        if(boomCell.length > 0){
            int x = boomCell.length;
            int y = boomCell[0].length;
            if(x == width && y == height){
                for(int i = 0; i < width ; i++){
                    for(int j = 0 ; j < height ; j++){
                        if(board[i][j] == 0){
                            cells[i][j].setText("");
                        } else if(board[i][j] == 99){
                            cells[i][j].setText("X");
                        } else {
                            cells[i][j].setText("" + board[i][j]);
                        }
                    }
                }
            } else {}
        }
    }

    */

}
