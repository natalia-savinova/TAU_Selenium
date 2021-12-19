package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By decreaseIndentButton = By.xpath("//button[@aria-label = 'Increase indent']");


    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToEditorAres() {
        driver.switchTo().frame(editorIframeId);
    }

    public void clearTextArea() {
        switchToEditorAres();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        switchToEditorAres();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

    public void decreaseIndention() {
        driver.findElement(decreaseIndentButton).click();
    }

    public String getTextFromEditor() {
        switchToEditorAres();
        String test = driver.findElement(textArea).getText();
        switchToMainArea();
        return test;
    }
}
