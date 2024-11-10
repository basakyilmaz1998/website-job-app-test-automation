import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EndToEndTest extends BaseTest {
    HomePage homePage;
    CareersPage careersPage;
    QualityAssurancePage qualityAssurancePage;
    OpenPositionsPage openPositionsPage;
    LeverAppFormPage leverAppFormPage;



    @Test
    public void InsiderTest() throws InterruptedException{

        homePage = new HomePage(driver);
        careersPage = new CareersPage(driver);
        qualityAssurancePage = new QualityAssurancePage(driver);
        openPositionsPage = new OpenPositionsPage(driver);
        leverAppFormPage = new LeverAppFormPage(driver);

        // https://useinsider.com/ adresine gidilir ve Insider ana sayfasinin acildigi kontrol edilir
        driver.get("https://useinsider.com/");
        homePage.waitUntilHomePageLoad();
        // Pop-up varsa kapatilir
        homePage.clickPopupCloseButton();
        // "Company" menusu tiklanir
        homePage.clickCompanyMenu();
        // "Careers" butonuna tiklanir
        homePage.clickCareersButton();

        // Careers sayfasinda Teams, Locations ve Life blocks'un goruntulendigi kontrol edilir
        careersPage.scrollUntilTeamsBlock();
        careersPage.scrollUntilLocationsBlock();
        careersPage.scrollUntilLifeBlock();

        // Quality Assurance sayfasina gidilir
        driver.get("https://useinsider.com/careers/quality-assurance/");
        qualityAssurancePage.waitUntilQaPageLoad(); // Sayfanin yüklendigini kontrol eder
        // Sayfada cookies cikarsa kapatilir
        qualityAssurancePage.clikcAcceptCookiesButton();
        // "See All QA Jobs" butonuna tiklanir
        qualityAssurancePage.clickSeeAllQaJobsButton();
        openPositionsPage.waitUntillOpenPositionsPageLoad(); // Sayfanin yüklendigini kontrol eder

        //Menude Location ve Departmant filter'ı uygulanir
        openPositionsPage.clickLocationFilter();
        openPositionsPage.clickLocationIstanbulTurkey();
        openPositionsPage.clickDepartmentFilter();
        openPositionsPage.clickDepartmentQualityAssurance();

        Thread.sleep(8000); // Filter'ın uygulanmasi icin bekleme suresi
        // Sayfa en asagi kaydirilir
        openPositionsPage.scrollDownAtOpenPositionPage();
        // Job list görünüyor mu kontrol edilir
        openPositionsPage.scrollUntilJobListVisible();
        // Sayfa biraz yukari kaydirilarak hizalanir
        openPositionsPage.scrollUpAtOpenPositionPage();

        // Job Card'da Location ve Department bilgileri kontrol edilir
        openPositionsPage.checkDepartmentQualityAssuranceOnJobCard();
        openPositionsPage.checkLocationIstanbulTurkeyOnJobCard();

        // Job Card'a hover yapilir ve "View Role" butonuna tiklanir
        openPositionsPage.hoverOnJobCard();
        openPositionsPage.clickViewRoleButton();
        Thread.sleep(8000); // Tab'in açilmasi icin bekleme suresi
        leverAppFormPage.changeTabToLeverAppFormPage();
        leverAppFormPage.waitUntilLeverAppFormPageOpen(); // Lever Application Form sayfasinin acildigi kontrol edilir

        // Lever Application Form sayfasina yönlendirme yapildigi kontrol edilir
        openPositionsPage.checkLeverApplicationPageRedirectedWithUrl();
    }

}