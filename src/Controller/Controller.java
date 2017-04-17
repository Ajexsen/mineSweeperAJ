package Controller;

import Model.Model;
import View.View;

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
    private View view;

    private int width;
    private int height;

    private int nonBoomNr;
    private int boomNr;
    private int countUncovered;


    private boolean[][] isFlagged;
    private boolean[][] isUncovered;


    public Controller(Model model) {
        this.model = model;

        width = model.getWidth();
        height = model.getHeight();

        boomNr = model.getBoomNr();
        nonBoomNr = (width * height) - boomNr;

        isFlagged = new boolean[width][height];
        isUncovered = new boolean[width][height];
    }

    public boolean isMine(int x, int y) {
        return model.isMine(x, y);
    }

    public int surroundingNr(int x, int y) {
        return model.getSurroundingNr(x, y);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void Flag(int x, int y) {
        isFlagged[x][y] = !isFlagged[x][y];
    }

    public boolean isFlagged(int x, int y) {
        return isFlagged[x][y];
    }

    public void uncover(int x, int y) {
        if (model.isMine(x, y)) {
            gameOver();
        } else {
            countUncovered++;
            isUncovered[x][y] = true;
        }
    }

    public boolean isGameCompleted() {
        if (countUncovered == nonBoomNr) {
            System.out.println("finish!!!");
            return true;
            // end
        }

        // check winning condition
        return false;
    }

    public void gameOver() {
        System.out.println("GAME OVER!!!!");
        // end game
    }

    public boolean isUncovered(int x, int y) {
        return isUncovered[x][y];
    }

    public void subscribe(View view) {
        this.view = view;
    }

}
