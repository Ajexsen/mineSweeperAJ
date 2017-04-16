package Model;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */

public class Model {

    private final int width;
    private final int height;

    private final int boom;
    private final Field field;

    private final int[][] surroundingBoom;
    private final boolean[][] isMine;


    public Model(int w, int h, int b){
        width = w;
        height = h;
        int pix = width * height;
        if( b <=  pix ){
            boom = b;
        } else {
            boom = (int) Math.round(pix*0.4);
            // default setting, boom rate 40%
        }
        field = new Field(width, height, boom);
        surroundingBoom = field.getSurroundingBoom();
        isMine = field.getIsMine();
    }

    public int getSurroundingNr(int x, int y){ return surroundingBoom[x][y]; }
    public boolean isMine(int x, int y){ return isMine[x][y]; }


    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

}
