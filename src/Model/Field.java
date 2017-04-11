package Model;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
public class Field {

    private String[][] board;
    private boolean[][] boom;

    private int width;
    private int height;
    private int boomNr;

    public Field(int w, int h, int b){
        width = w;
        height = h;
        boomNr = b;
        board = new String[width][height];
        boom = new boolean[width][height];
        int[] boomList = RandomNrNoDups(1, (width*height), boomNr);
        for(int i = 0; i < boomNr ; i++){
            int cellNr = boomList[i];
            int x = (cellNr % width) - 1;
            int y = cellNr / width;
            board[x][y] = "X";
        }
    }


    // http://stackoverflow.com/questions/16000196/java-generating-non-repeating-random-numbers
    public static int[] RandomNrNoDups(int start, int end, int count) {
        Random rng = new Random();

        int[] result = new int[count];
        int cur = 0;
        int remaining = end - start;
        for (int i = start; i < end && count > 0; i++) {
            double probability = rng.nextDouble();
            if (probability < ((double) count) / (double) remaining) {
                count--;
                result[cur++] = i;
            }
            remaining--;
        }
        return result;
    }

    public String[][] getBoard(){
        return board;
    }

}
