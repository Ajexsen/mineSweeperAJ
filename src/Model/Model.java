package Model;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */

public class Model {

    private final int width;
    private final int height;
    private final int boom;


    public Model(int w, int h, int b){
        width = w;
        height = h;
        int pix = width * height;
        if( b <=  pix ){
            boom = b;
        } else {
            boom = (int) Math.round(pix*0.4);
        }
    }

}
