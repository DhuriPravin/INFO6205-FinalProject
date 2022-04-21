package Utils;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Utils {
	public static final Random RandomGenerator = new Random();
	public static final BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    String line = console.readLine();
	public static final String NEW_LINE = System.getProperty("line.separator");
    private static final Logger logger = LogManager.getLogger(Utils.class);

    public Utils() throws IOException {
        BasicConfigurator.configure();
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

    public static  void flipElementsHorizontal(int rows, int columns, int[] boardTransformation){
        if(boardTransformation == null) {
            throw new NullPointerException("Incorrect input: Null");
        }
        if (rows < 1 || columns < 1) {
            throw new IllegalArgumentException("Incorrect input of currRow or column.");
        }
        if (rows * columns != boardTransformation.length) {
            throw new IllegalArgumentException("rows * columns must be equal to the length of the matrix");
        }
        for (int currRow = 0; currRow < rows / 2; currRow++) { 
            int RowOpposite = rows - currRow - 1;
            for (int currColumn = 0; currColumn < columns; currColumn++) {
                int temp = boardTransformation[currRow * columns + currColumn];
                boardTransformation[currRow * columns + currColumn] = boardTransformation[RowOpposite * columns + currColumn];
                boardTransformation[RowOpposite * columns + currColumn] = temp;
            }
        }
    }

    public static  void flipElementsVertical(int rows, int columns, int[] boardTransformation){

        if(boardTransformation == null) {
            throw new NullPointerException("boardTransformation is null");
        }
        if (rows < 1 || columns < 1) {
            throw new IllegalArgumentException("Incorrect input of currRow or column.");
        }
        if (rows * columns != boardTransformation.length) {
            throw new IllegalArgumentException("The size of the array must be compatible with the parameters rows and columns");
        }

        for (int currColumn = 0; currColumn < columns / 2; currColumn++) {
            int ColumnOpposite = columns - currColumn - 1;
            for (int currRow = 0; currRow < rows; currRow++) {
                int temp = boardTransformation[currRow * columns + currColumn];
                boardTransformation[currRow * columns + currColumn] = boardTransformation[currRow * columns + ColumnOpposite];
                boardTransformation[currRow * columns + ColumnOpposite] = temp;
            }
        }

    }

    public static ArrayList<String> inputs = new ArrayList<String>();

    public static void addDefaults() {
        for (int i = 0; i < 10; i++) {
            inputs.add("");
        }
    }

    public static void removeAll() {
        inputs = new ArrayList<String>();
    }

    public static void getText(Integer place, String text) {
        inputs.set(place, "\u2B55");
    }

    public static void addText(Integer place) {
        inputs.set(place, "X");
    }

    public static ArrayList<String> getText() {
        return inputs;
    }
}
