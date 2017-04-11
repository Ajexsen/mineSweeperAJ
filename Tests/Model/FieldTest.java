package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
class FieldTest {
    @Test
    void randomNrNoDups() {
        Field field = new Field(50,50,70);
        String[][] testField = field.getBoard();
        for(int i = 0; i < 50; i++){
            for(int j = 0 ; j < 50 ; j++){
                System.out.print(testField[i][j] + " ");
            }
            System.out.println();
        }
    }

}