import org.junit.Test;
import org.junit.Assert;

public class RunTests {

    @Test
    public void checkHorizontalFlipsIncorrect() {
        Throwable throwable = Assert.assertThrows(IllegalArgumentException.class, ()-> {
            UtilsToString.checkFlipElementsHorizontal(0, 0);
        });
        Assert.assertTrue(throwable.getMessage().contains("Incorrect input of currRow or column."));
    }

    @Test
    public void checkVerticalFlipIncorrect(){
        Throwable throwable = Assert.assertThrows(IllegalArgumentException.class, ()-> {
            UtilsToString.checkFlipElementsVertical(0, 0);
        });
        Assert.assertTrue(throwable.getMessage().contains("Incorrect input of currRow or column."));    }

    @Test
    public void checkRotationIncorrect(){
        Throwable throwable = Assert.assertThrows(IllegalArgumentException.class, ()-> {
            UtilsToString.checkElementsRotation(0, 0);
        });
        Assert.assertTrue(throwable.getMessage().contains("Incorrect input of row or column."));
    }
    @Test
    public void checkHorizontalFlips2X2() {
        Assert.assertEquals("[2, 3, 0, 1]", UtilsToString.checkFlipElementsHorizontal(2, 2));
    }

    @Test
    public void checkVerticalFlip2X2(){
        Assert.assertEquals("[1, 0, 3, 2]", UtilsToString.checkFlipElementsVertical(2, 2));
    }

    @Test
    public void checkRotation2X2(){
        Assert.assertEquals("[2, 0, 3, 1]", UtilsToString.checkElementsRotation(2, 2));
    }

    @Test
    public void checkHorizontalFlips3X3() {
        Assert.assertEquals("[6, 7, 8, 3, 4, 5, 0, 1, 2]", UtilsToString.checkFlipElementsHorizontal(3, 3));
    }

    @Test
    public void checkVerticalFlip3X3(){
        Assert.assertEquals("[2, 1, 0, 5, 4, 3, 8, 7, 6]", UtilsToString.checkFlipElementsVertical(3, 3));
    }
    @Test
    public void checkRotation3X3(){
        Assert.assertEquals("[6, 3, 0, 7, 4, 1, 8, 5, 2]", UtilsToString.checkElementsRotation(3, 3));
    }

    @Test
    public void checkHorizontalFlips4X4() {
        Assert.assertEquals("[12, 13, 14, 15, 8, 9, 10, 11, 4, 5, 6, 7, 0, 1, 2, 3]", UtilsToString.checkFlipElementsHorizontal(4, 4));
    }

    @Test
    public void checkVerticalFlip4X4(){
        Assert.assertEquals("[3, 2, 1, 0, 7, 6, 5, 4, 11, 10, 9, 8, 15, 14, 13, 12]", UtilsToString.checkFlipElementsVertical(4, 4));
    }
    @Test
    public void checkRotation4X4(){
        Assert.assertEquals("[12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3]", UtilsToString.checkElementsRotation(4, 4));
    }

}
