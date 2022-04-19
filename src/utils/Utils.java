package src.utils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.io.Console;

public class Utils {
    public static final Random RandomGenerator = new Random();
    public static final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    public static final String NEW_LINE = System.getProperty("line.separator");
    private static final Logger logger = LogManager.getLogger(Utils.class);

    public Utils() throws IOException {
    }

    public static void rotateElementsWhenRowEqualsColumns(int rows, int columns, int[] boardTransformation){
        if(boardTransformation == null) {
            throw new NullPointerException("Incorrect input: Null");
        }
        if (rows < 1 || columns < 1) {
            throw new IllegalArgumentException("Incorrect input of row or column.");
        }
        if (rows * columns != boardTransformation.length) {
            throw new IllegalArgumentException("rows * columns must be equal to the length of the matrix");
        }
        if (rows != columns) {
            throw new IllegalArgumentException("Rows and columns must be same in a TicTacToe board.");
        }
        for (int currRow = 0; currRow < rows; currRow++) {

            for (int currColumn = currRow; currColumn < columns - currRow - 1; currColumn++) {

                int CRight = currColumn * columns + (rows - currRow - 1);
                int bottomRow = (rows - currRow - 1) * columns + (columns - currColumn - 1);
                int CLeft = (columns - currColumn - 1) * columns + currRow;

                int temp = boardTransformation[currRow * rows + currColumn];

                boardTransformation[currRow * rows + currColumn] = boardTransformation[CLeft];
                boardTransformation[CLeft] = boardTransformation[bottomRow];
                boardTransformation[bottomRow] = boardTransformation[CRight];
                boardTransformation[CRight] = temp;
            }
        }

    }
}