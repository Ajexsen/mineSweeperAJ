package View;

import Controller.Controller;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
class FieldBox extends GridPane {
    private Cell cells[][];
    private int width;
    private int height;

    private Controller controller;

    FieldBox(Controller controller) {
        this.controller = controller;
        this.width = controller.getWidth();
        this.height = controller.getHeight();
        cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(i, j);
                cells[i][j].setOnMouseClicked(event -> {

                    MouseButton button = event.getButton();
                    Cell cell = (Cell) event.getSource();
                    int x = cell.getX();
                    int y = cell.getY();
                    if (button == MouseButton.PRIMARY) {
                        if (!controller.isMine(x, y)) {
                            uncoverCell(x, y);
                        } else {
                            cell.disable();
                            cell.setText(Parameter.mineChar);
                            gameOver();
                            controller.gameOver();
                        }
                    } else if (button == MouseButton.SECONDARY) {
                        if (!controller.isFlagged(x, y))
                            cell.setText(Parameter.flagChar);
                        else
                            cell.setText("");

                        controller.Flag(x, y);

                    } else if (button == MouseButton.MIDDLE) {
                        //System.out.println();
                    }
                });

                this.add(cells[i][j], i, j, 1, 1);
            }
        }
    }

    private void uncoverCell(int x, int y) {
        if (x < width && y < height && x >= 0 && y >= 0 && !controller.isUncovered(x, y)) {
            cells[x][y].disable();
            controller.uncover(x, y);
            int nr = controller.surroundingNr(x, y);
            controller.isGameCompleted();

            if (nr == 0) {
                cells[x][y].setText("");

                uncoverCell(x - 1, y - 1);
                uncoverCell(x - 1, y);
                uncoverCell(x - 1, y + 1);

                uncoverCell(x, y - 1);
                uncoverCell(x, y + 1);

                uncoverCell(x + 1, y - 1);
                uncoverCell(x + 1, y);
                uncoverCell(x + 1, y + 1);

            } else {
                cells[x][y].setText("" + nr);
            }
        }
    }

    private void gameOver() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(controller.isMine(i,j)){
                    cells[i][j].setText(Parameter.mineChar);
                    cells[i][j].greyOut();
                }
                cells[i][j].disable();
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
