import Utils.Utils;

public class UtilsToString {
    public static String checkFlipElementsHorizontal(int rows, int columns) {
        int[] test;
        test = new int[rows*columns];
        for(int i = 0 ; i < test.length; i++){
            test[i] = i;
        }
        Utils.flipElementsHorizontal(rows,columns,test);
        return java.util.Arrays.toString(test);
    }
}