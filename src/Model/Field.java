package Model;

import java.util.HashSet;
import java.util.Observable;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
public class Field extends Observable{

    private String[][] board;

    public boolean[][] getBoom() {
        return boom;
    }

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
        Set<Integer> boomSet = RandomNrSet(1,(width*height), boomNr);

        for(Integer nr : boomSet){
            int cellNr = nr;
            int x = (cellNr-1) % width;
            int y = (cellNr-1) / width;
            System.out.println("(" + x + ", " + y + ")");
            board[x][y] = "X";
            boom[x][y] = true;
        }
        /*
        for(int i = 0; i < boomNr ; i++){
            int cellNr = boomList[i];
            int x = (cellNr-1) % width;
            int y = (cellNr-1) / width;
            System.out.println("(" + x + ", " + y + ")");
            board[x][y] = "X";
            boom[x][y] = true;
        }

        */
        for(int i = 0 ; i < width ; i++){
            for(int j = 0 ; j < height ; j++){
                int count = 0;
                if(!boom[i][j]){
                    // 1 2 3
                    // 4 X 5
                    // 6 7 8
                    if(booleanChecker(i-1,j-1)){count++;} // 1
                    if(booleanChecker(i,j-1)){count++;} // 2
                    if(booleanChecker(i+1,j-1)){count++;} // 3
                    if(booleanChecker(i-1,j)){count++;} // 4
                    if(booleanChecker(i+1,j)){count++;} // 5
                    if(booleanChecker(i-1,j+1)){count++;} // 6
                    if(booleanChecker(i,j+1)){count++;} // 7
                    if(booleanChecker(i+1,j+1)){count++;} // 8

                    if(count == 0){
                        board[i][j] = " ";
                    } else {
                        board[i][j] = "" + count;
                    }


                } else { continue; }


            }
        }

    }


    public static Set<Integer> RandomNrSet(int start, int end, int count){
        Random rand = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size()<count){
            uniqueNumbers.add(rand.nextInt((end - start) + 1) + start);
        }
        return uniqueNumbers;
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

    private boolean booleanChecker(int x, int y){
        if(x < width && y < height && x >= 0 && y >= 0){
            return boom[x][y];
        } else return false;
    }

}
