import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static final By insiderMainLogo = By.xpath("//img[@alt='insider_logo']");
    public static final By popupCloseButton = By.id("ins-close-button");
    public static final By companyMenu = By.xpath("//a[@id='navbarDropdownMenuLink'][contains(text(),'Company')]");
    public static final By careersButton = By.xpath("//a[@href='https://useinsider.com/careers/']");


    // Ana sayfanin yuklenmesini bekler
    public void waitUntilHomePageLoad() {
        waitUntilVisible(insiderMainLogo);
        log.info("The home page has been opened successfully.");
    }

    // Company menusune tiklar
    public void clickCompanyMenu() {
        click(companyMenu);
    }

    // Eger popup varsa kapatma butonuna tiklar
    public void clickPopupCloseButton() {
        clickIfElementExists(popupCloseButton);
    }

    // Careers sayfasina yonlendiren butona tiklar
    public void clickCareersButton() {
        click(careersButton);
    }


}