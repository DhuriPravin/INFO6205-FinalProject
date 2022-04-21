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

}
