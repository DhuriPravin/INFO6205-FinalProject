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

    public static String checkFlipElementsVertical(int rows, int columns){
        int[] test;
        test = new int[rows*columns];
        for(int i = 0 ; i < test.length; i++){
            test[i] = i;
        }
        Utils.flipElementsVertical(rows,columns,test);
        return java.util.Arrays.toString(test);
    }

    public static String checkElementsRotation(int rows, int columns){
        int[] test;
        test = new int[rows*columns];
        for(int i = 0 ; i < test.length; i++){
            test[i] = i;
        }
        Utils.rotateElementsWhenRowEqualsColumns(rows,columns,test);
        return java.util.Arrays.toString(test);
    }
}