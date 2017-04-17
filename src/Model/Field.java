package Model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */

public class Field{

    private final int[][] surroundingBoom; // 99 is isMine
    private final boolean[][] isMine;

    private final int width;
    private final int height;
    private final int boomNr;

    public Field(int w, int h, int b){
        width = w;
        height = h;
        boomNr = b;
        surroundingBoom = new int[width][height];
        isMine = new boolean[width][height];
        Set<Integer> boomSet = RandomNrSet(1,(width*height), boomNr);

        for(Integer nr : boomSet){
            int cellNr = nr;
            int x = (cellNr-1) % width;
            int y = (cellNr-1) / width;
            //System.out.println("(" + x + ", " + y + ")");
            surroundingBoom[x][y] = 9;
            isMine[x][y] = true;
        }

        for(int i = 0 ; i < width ; i++){
            for(int j = 0 ; j < height ; j++){
                int count = 0;
                if(!isMine[i][j]){

                    // 1 2 3
                    // 4 X 5
                    // 6 7 8

                    if(booleanChecker(i-1,j-1)){count++;}    // 1
                    if(booleanChecker(i,j-1)){count++;}         // 2
                    if(booleanChecker(i+1,j-1)){count++;}    // 3
                    if(booleanChecker(i-1,j)){count++;}         // 4
                    if(booleanChecker(i+1,j)){count++;}         // 5
                    if(booleanChecker(i-1,j+1)){count++;}    // 6
                    if(booleanChecker(i,j+1)){count++;}         // 7
                    if(booleanChecker(i+1,j+1)){count++;}    // 8

                    surroundingBoom[i][j] = count;


                } else { continue; }


            }
        }

    }

    public int[][] getSurroundingBoom(){
        return surroundingBoom;
    }
    public boolean[][] getIsMine() {
        return isMine;
    }


    private Set<Integer> RandomNrSet(int start, int end, int count){
        Random rand = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (uniqueNumbers.size()<count){
            uniqueNumbers.add(rand.nextInt((end - start) + 1) + start);
        }
        return uniqueNumbers;
    }


    private boolean booleanChecker(int x, int y){
        if(x < width && y < height && x >= 0 && y >= 0){
            return isMine[x][y];
        } else return false;
    }

}
