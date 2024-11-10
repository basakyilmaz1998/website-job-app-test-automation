import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenPositionsPage extends BasePage {

    public OpenPositionsPage(WebDriver driver) {
        super(driver);
    }

    public static final By locationFilter = By.xpath("(//span[@class='select2-selection select2-selection--single']//b[@role='presentation'])[1]");
    public static final By departmentFilter = By.xpath("(//span[@class='select2-selection select2-selection--single']//b[@role='presentation'])[2]");
    public static final By locationIstanbulTurkey = By.xpath("//ul[@class='select2-results__options']/li[text()='Istanbul, Turkey']");
    public static final By departmentQualityAssurance = By.xpath("//ul[@id='select2-filter-by-department-results']/li[text()='Quality Assurance']");
    public static final By positionDepartment = By.xpath("//div[@id='jobs-list']//span[contains(@class,'department')]");
    public static final By positionLocation = By.xpath("//div[@id='jobs-list']//div[contains(@class,'location')]");
    public static By positionTitle = By.xpath("//*[@id=\"jobs-list\"]//p[contains(@class,'position-title')]");
    public static final By viewRoleButton = By.xpath("//a[text()='View Role']");
    public static final By departmentFilterDefaultText = By.xpath("(//span[@class='select2-selection__rendered'])[2]");


    // Location filter'ına tiklar
    public void clickLocationFilter() {
        click(locationFilter);
    }

    // Department filter'ına tiklar
    public void clickDepartmentFilter() {
        click(departmentFilter);
    }

    // Menude "Istanbul, Turkey"e tiklar
    public void clickLocationIstanbulTurkey() {
        click(locationIstanbulTurkey);
    }

    // Menude "Quality Assurance"ye tiklar
    public void clickDepartmentQualityAssurance() {
        click(departmentQualityAssurance);
    }

    // Job List gorunur olana kadar sayfayi kaydirir
    public void scrollUntilJobListVisible() {
        scrollUntilElementVisible(positionTitle);
        log.info("Job list displayed successfully.");
    }

    // Job Card'da Department text'ini alir
    public String getJobsCardDepartmentText() {
        return getText(positionDepartment);
    }

    // Job Card'da Location text'ini alir
    public String getJobsCardLocationText() {
        return getText(positionLocation);
    }

    // View Role butonuna tiklar
    public void clickViewRoleButton() {
        click(viewRoleButton);
    }

    // Job Card'in ustunde hover yapar
    public void hoverOnJobCard() {
        hoverToElement(viewRoleButton);
    }

    // Lever Application Form sayfasinin acildigini URL'i ile kontrol eder
    public void checkLeverApplicationPageRedirectedWithUrl() {
        checkLinkUrl("jobs.lever.co");
        log.info("Redirected to Lever Application form page successfully.");
    }

    // Open Positions sayfasinin yuklenmesini bekler
    public void waitUntillOpenPositionsPageLoad() {
        waitUntilTextEquals(departmentFilterDefaultText, "Quality Assurance");
    }

    // Open Positions sayfasinda asagi kaydirir
    public void scrollDownAtOpenPositionPage() {
        scrollDown();
    }

    // Open Positions sayfasinda yukari kaydirir
    public void scrollUpAtOpenPositionPage() {
        scrollUp();
    }

    // Job Card'daki Location bilgisinin "Istanbul, Turkey" oldugunu kontrol eder
    public void checkLocationIstanbulTurkeyOnJobCard() {
        try {
            Assertions.assertEquals("Istanbul, Turkey", getJobsCardLocationText());
            log.info("Location filter verification passed: Istanbul, Turkey.");
        } catch (AssertionError e) {
            log.error("Location filter verification failed: expected 'Istanbul, Turkey' but got '" + getJobsCardLocationText() + "'.");
            throw e;
        }
    }

    // Job Card'daki Department bilgisinin "Quality Assurance" oldugunu kontrol eder
    public void checkDepartmentQualityAssuranceOnJobCard() {
        try {
            Assertions.assertEquals("Quality Assurance", getJobsCardDepartmentText());
            log.info("Department filter verification passed: Quality Assurance.");
        } catch (AssertionError e) {
            log.error("Department filter verification failed: expected 'Quality Assurance' but got '" + getJobsCardDepartmentText() + "'.");
            throw e;
        }
    }


}