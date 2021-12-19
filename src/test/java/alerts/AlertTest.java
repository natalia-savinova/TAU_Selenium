package alerts;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class AlertTest extends BaseTest {

    @Test
    public void testAcceptAlert() {
        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerAlert();
        alertPage.alert_clickToAccept();

        assertEquals(alertPage.getResult(), "You successfully clicked an alert", "Result text is incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text is incorrect");
    }

    @Test
    public void testSetInputItAlert() {
        var alertsPge = homePage.clickJavaScriptAlerts();
        alertsPge.triggerPrmpt();

        String text = "Test text";
        alertsPge.alert_setInput(text);
        alertsPge.alert_clickToAccept();
        assertEquals(alertsPge.getResult(), "You entered: " + text, "Result text is incorrect");
    }
}
