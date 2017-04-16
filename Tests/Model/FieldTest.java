package Model;

import org.junit.jupiter.api.Test;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
class FieldTest {
    @Test
    void fieldT(){

    }

    @Test
    void randomNrNoDups() {
        int x = 50;
        int y = 45;
        int b = (int) 100 ;
        Field field = new Field(x,y,b);
        int[][] testField = field.getSurroundingBoom();
        System.out.print("   | ");
        for(int i = 0; i < x; i++){
            System.out.print(i%10 + " ");
        }
        System.out.println();
        for(int i = 0; i < x; i++){
            if(i/10 == 0) {
                System.out.print("0");
            }
            System.out.print(i + " | ");
            for(int j = 0 ; j < y ; j++){
                System.out.print(testField[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}