import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QualityAssurancePage extends BasePage {
    public QualityAssurancePage(WebDriver driver) {
        super(driver);
    }

    public static final By acceptCookiesButton = By.id("wt-cli-accept-btn");
    public static final By SeeAllQAJobsButton = By.xpath("//a[text()='See all QA jobs'][@href]");


    // Quality Assurance sayfasinin yuklenmesini bekler
    public void waitUntilQaPageLoad() {
        waitUntilVisible(SeeAllQAJobsButton);
    }

    // "See All QA Jobs" butonuna tiklar
    public void clickSeeAllQaJobsButton() {
        click(SeeAllQAJobsButton);
    }

    // Cookies varsa butona tiklayarak kabul eder
    public void clikcAcceptCookiesButton() {
        clickIfElementExists(acceptCookiesButton);
    }


}
