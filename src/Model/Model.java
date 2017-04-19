package Model;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */

public class Model {

    private int width;
    private int height;

    private int boomNr;
    private Field field;

    private int[][] surroundingBoom;
    private boolean[][] isMine;


    public Model(int w, int h, int b) {
        width = w;
        height = h;
        int pix = width * height;
        if (b <= pix) {
            boomNr = b;
        } else {
            boomNr = (int) Math.round(pix * 0.4);
            // default setting, boomNr rate 40%
        }
        field = new Field(width, height, boomNr);
        surroundingBoom = field.getSurroundingBoom();
        isMine = field.getIsMine();
    }

    public int getSurroundingNr(int x, int y) {
        return surroundingBoom[x][y];
    }

    public boolean isMine(int x, int y) {
        return isMine[x][y];
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getBoomNr() {
        return boomNr;
    }



}
