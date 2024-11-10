import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeverAppFormPage extends BasePage {

    public LeverAppFormPage(WebDriver driver) {
        super(driver);
    }

    public static By appForJobButton = By.xpath("//div[@class='postings-btn-wrapper']/*[text()='Apply for this job']");


    // Lever Application Form sayfasinin acilmasini bekler
    public void waitUntilLeverAppFormPageOpen() {
        waitUntilVisible(appForJobButton);
    }

    // Tab'i Lever Application Form sayfasina degistirir
    public void changeTabToLeverAppFormPage() {
        changeToSecondTab();
    }


}

