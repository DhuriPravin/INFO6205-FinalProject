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

}
