package dropdown;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownTest extends BaseTest {

    @Test
    public void testSelectOption() {
        var dropDownPage = homePage.clickDropDown();
        String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
        var selectedOptions = dropDownPage.getSelectedOption();

        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option is not collected");
    }
}
