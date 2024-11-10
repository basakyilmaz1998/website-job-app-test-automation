import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareersPage extends BasePage {
    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public static final By careerTeamBlock = By.id("career-find-our-calling");
    public static final By careerLocationBlock = By.id("career-our-location");
    public static final By careerLifeBlock = By.xpath("//section[@data-id='a8e7b90']");


    // Teams block gorunur hale geline kadar sayfayi kaydirir
    public void scrollUntilTeamsBlock() {
        scrollUntilElementVisible(careerTeamBlock);
        log.info("Teams block displayed successfully.");
    }

    // Locations block gorunur hale geline kadar sayfayi kaydirir
    public void scrollUntilLocationsBlock() {
        scrollUntilElementVisible(careerLocationBlock);
        log.info("Locations block displayed successfully.");
    }

    // Life at Insider block elementini gorunur hale geline kadar sayfayi kaydirir
    public void scrollUntilLifeBlock() {
        scrollUntilElementVisible(careerLifeBlock);
        log.info("Life at Insider block displayed successfully.");
    }


}