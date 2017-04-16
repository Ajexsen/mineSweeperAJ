package Controller;

import Model.Model;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */

/*
when all non-boom field is discovered -> win
when a land mine is triggered -> game over

check if mine is triggered every round, and if the non mine are all opened.

get data from model and send to view for display
 */

public class Controller {
    private Model model;

    private int width;
    private int height;

    public Controller(Model model){
        this.model = model;
        width = model.getWidth();
        height = model.getHeight();
    }

    public boolean isMine(int x, int y){
        return model.isMine(x,y);
    }

    public int surroundingNr(int x, int y){
        return model.getSurroundingNr(x, y);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

}
